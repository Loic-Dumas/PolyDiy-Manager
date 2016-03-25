package common.factory;

import persistent.Account;

public abstract class ModifyAccountFactory {
	public abstract Account buildAccountwithID(int IDin) throws Exception;

	
}
