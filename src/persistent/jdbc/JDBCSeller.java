package persistent.jdbc;
/**
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.AlertDriver;
import common.exception.AlreadyExistTuple;
import common.exception.ErrorConnectionException;
import common.exception.NotExistingTuple;
import common.exception.UnknownIDSellerException;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.Seller;


public class JDBCSeller extends Seller{
	private JDBCComponent component = null;

	/**
	 * This constructor of JDBCSeller which call seller constructor.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Description
	 */
	public JDBCSeller () throws ErrorConnectionException, AlertDriver {
		super();
		this .component = new JDBCComponent();
	}

	/**
	 * This is constructor of JDBCSeller with id, which is the idaccount of this seller
	 * with this id we load all informations of seller froom DB 
	 * 
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param ID
	 */
	public JDBCSeller(int ID) throws ErrorConnectionException, AlertDriver, UnknownIDSellerException {
		super(ID);
		this .component = new JDBCComponent();

		try {
			ResultSet result = this.component.select("*", "seller_account", "id_account = '" + this.ID + "'");
			if (result.first()) {
				this.nameShop = result.getString("nameShop");
				this.description = result.getString("description");
				this.siret = result.getString("siret");
				this.website = result.getString("website");			
			} else {
				throw new UnknownIDSellerException(ID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	
	/**
	 * This method check is the seller exist in DB
	 * 
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param IDProduct 
	 * @return Boolean
	 */
	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "Seller_account", "id_account = '" + this.ID + "'");
		return result != null && result.first();
	}

	/**
	 * This method insert row in seller table of the seller exist.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	@Override
	public void insert() throws Exception {
		if(!this.isExisting()) {
			this.component.insert("Seller_account(id_account,nameshop,siret,website,description)", "'" + this.IDaccount + "', '" + this.nameShop + "', '"  + this.description + "', '"  + this.siret + "', '"  + this.website + "'");
		} else {
			throw new AlreadyExistTuple("Seller");
		}
	}
	/**
	 * This method update seller informations in DB if it exists.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	@Override
	public void update() throws Exception {
		if(this.isExisting()) {
			this.component.update("(nameshop, description, siret, website) = ('" + this.nameShop + "','" + this.description + "','" + this.siret + "','" +this.website + "')", "Seller_account","id_account = '" + this.ID + "'");
		} else {
			throw new NotExistingTuple("Seller");
		}
	}
	@Override
	public Boolean hasChanged() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete() throws Exception {
		// TODO Auto-generated method stub

	}

	/*@Override
	public void delete() throws Exception {
		if(this.isExisting()) {
			this.component.delete("Session", "ID=" + this.ID);
		} else {
			throw new NotExistingTuple("Session");
		}
	}*/


}
