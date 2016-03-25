package common.factory;

import persistent.Account;
import persistent.jdbc.JDBCAccount;

public class JDBCAccountFactory extends ModifyAccountFactory{

	public Account buildAccount(String loginIn) throws Exception {
		return new JDBCAccount(loginIn);
		
	}
	
	@Override
	public Account buildAccountwithID(int IDin) throws Exception {
		return new JDBCAccount(IDin);
		
	}
}
