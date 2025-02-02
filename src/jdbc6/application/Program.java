package jdbc6.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import jdbc6.db.DB;
import jdbc6.db.DbException;

public class Program {

	public static void main(String[] args) throws ParseException {
		clearScreen();
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();

			conn.setAutoCommit(false);

			st = conn.createStatement();

			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			// simulando um erro intencionalmente de rollback.
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake erro!");
			}

			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

			conn.commit();

			System.out.println("rows1: " + rows1);
			System.out.println("rows2: " + rows2);

		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());

			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by:" + e1.getMessage());
			}

		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

	public static void clearScreen() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			// Trata exceções (pode ser uma exceção de interrupção)
			e.printStackTrace();
		}
	}

}
