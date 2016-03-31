package persistent.list;

import common.InterfaceModel;
import common.SetWithKey;
import persistent.Task;

public abstract class SetTask extends SetWithKey<Task> implements InterfaceModel {
	protected int idUser = -1;

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
