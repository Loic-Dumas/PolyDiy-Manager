package persistent.abstractclass.list;

import common.set.SetWithKey;
import persistent.abstractclass.InterfaceModel;
import persistent.abstractclass.Task;

/**
 * an aggregation of task accessible by index
 * @author loicd_000
 *
 */
public abstract class SetTask extends SetWithKey<Task> implements InterfaceModel {
	protected int idUser = -1;

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
