package persistent.abstractclass.list;

import common.set.SetWithKey;
import persistent.abstractclass.Activity;
import persistent.abstractclass.InterfaceModel;

public abstract class SetActivity extends SetWithKey<Activity> implements InterfaceModel {
	protected int idUser = -1;

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
