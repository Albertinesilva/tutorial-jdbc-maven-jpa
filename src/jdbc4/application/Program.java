package jdbc4.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import jdbc4.db.DB;

public class Program {

	public static void main(String[] args) throws ParseException {
		clearScreen();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement("UPDATE seller " 
										+ "SET BaseSalary = BaseSalary + ? " 
										+ "WHERE " 
										+ "(DepartmentId = ?)");
			st.setDouble(1, 500.0);
			st.setInt(2,  2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		finally {
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
