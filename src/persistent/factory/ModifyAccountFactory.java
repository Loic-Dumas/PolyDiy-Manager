package persistent.factory;

import persistent.abstractclass.Account;

public abstract class ModifyAccountFactory {
	public abstract Account buildAccountwithID(int IDin) throws Exception;

	
}
