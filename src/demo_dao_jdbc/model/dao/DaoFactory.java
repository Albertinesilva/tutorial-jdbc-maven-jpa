package demo_dao_jdbc.model.dao;

import demo_dao_jdbc.db.DB;
import demo_dao_jdbc.model.dao.impl.DepartmentDaoJDBC;
import demo_dao_jdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
