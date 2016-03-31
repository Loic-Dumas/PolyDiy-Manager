package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.UnknownIDProductException;
import common.exception.needHaveBothIDUserAndLabelException;
import common.exception.wishListAlreadyExistException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.list.WishList;
import persistent.factory.ProductFactory;
import persistent.factory.jdbcFactory.JDBCProductFactory;


/**The JDBC implementation of a wishList
 * @author loicd_000
 *
 */
public class JDBCWishList extends WishList {
	private JDBCComponent component = null;
	ProductFactory productFactory = new JDBCProductFactory();

	/**
	 * Constructor of the wishList. When a wish list is created, add all the items in this wishList
	 * @param IDWishList
	 * @throws ErrorConnectionException
	 * @throws AlertDriver
	 */
	public JDBCWishList(int IDWishList) throws ErrorConnectionException, AlertDriver {
		super(IDWishList);
		this.component = new JDBCComponent();
		try {
			ResultSet result = this.component.select("*", "wishlist ", "id_wishlist = '" + IDWishList + "'");
			if (result.first()) {
				// we add the label (name) of the wish list
				this.setLabel(result.getString("label"));

				// we get all items of the wish list.
				result = this.component.select("i.id_wishlist, i.id_product, i.quantity, i.unitPrice, w.label",
						"wishlist w, item_wishlist i",
						"w.id_wishlist = '" + IDWishList + "' AND i.id_wishlist = w.id_wishlist");
			} else {
				System.err.println("No wish list returned.");
			}
			
			if (result.first()) {
				// we add all the elements found to the set
				do {
					try {
						this.addElement(String.valueOf(result.getInt("id_product")),
								productFactory.buildProductWishList(result.getInt("id_product"),
										result.getInt("id_wishlist"), result.getInt("quantity"),
										result.getFloat("unitPrice")));

					} catch (UnknownIDProductException e) {
						System.err.println("Impossible to create the product with id : " + result.getInt("id_product"));
						e.printStackTrace();
					}
				} while (result.next());
			} 

		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}

	}

	/**
	 * create a wishlist with IDUser and label
	 * @param IDUser
	 * @param label
	 * @throws needHaveBothIDUserAndLabelException
	 * @throws wishListAlreadyExistException
	 */
	public JDBCWishList(int IDUser, String label)
			throws needHaveBothIDUserAndLabelException, wishListAlreadyExistException {
		super(IDUser, label);
	}

	/**
	 * @return true if the wishList already exists in the database with a same IDUser and a label
	 * @throws needHaveBothIDUserAndLabelException
	 * @throws ErrorConnectionException
	 * @throws AlertDriver
	 */
	public Boolean isExistingWithIDUserAndLabel()
			throws needHaveBothIDUserAndLabelException, ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
		if ((new Integer(this.IDUser) == null) || (this.label == null)) {
			System.err.println();
			throw new needHaveBothIDUserAndLabelException();
		}
		
		ResultSet result = this.component.select("*", "wishList",
				"id_user = " + this.IDUser + " AND label = '" + this.label + "'");

		try {
			return result.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#isExisting()
	 */
	@Override
	public Boolean isExisting() throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#insert()
	 */
	@Override
	public void insert()
			throws AlreadyExistTuple, needHaveBothIDUserAndLabelException, ErrorConnectionException, AlertDriver {
		this.component = new JDBCComponent();
		if (!this.isExistingWithIDUserAndLabel()) {
			this.component.insert("wishList(id_user, label)", " '" + this.IDUser + "', '" + this.label + "'");
		} else {
			throw new AlreadyExistTuple("WishList");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#update()
	 */
	@Override
	public void update() throws Exception {

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#delete()
	 */
	@Override
	public void delete() throws Exception {
		this.component = new JDBCComponent();

		for (Iterator<String> i = this.getAllKeys().iterator(); i.hasNext();) {
			String key = i.next();
			this.getElementByKey(key).delete();
		}
		
		this.component.delete("wishList", "id_wishList = " + this.IDWishList);

	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#hasChanged()
	 */
	@Override
	public Boolean hasChanged() throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#loadFromKeys(java.util.List, java.util.List)
	 */
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {

	}

}
