package testeDb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	private static final String URL = "jdbc:mysql://ueco7ipuee6x6zyl:ELwg1kpE0Kuf5SdrPPYI@bvckpfp5jufcajrfeby3-mysql.services.clever-cloud.com:3306/bvckpfp5jufcajrfeby3";
	private static final String USER = "ueco7ipuee6x6zyl";
	private static final String PASSWD = "ELwg1kpE0Kuf5SdrPPYI";

	public static Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Conexaoo Feita com sucesso!!!");
		} catch (SQLException e) {
			System.out.println("Erro de conexao");
		}
		return con;
	}
}
