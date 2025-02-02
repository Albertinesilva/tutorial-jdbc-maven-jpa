package jdbc5.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import jdbc5.db.DB;
import jdbc5.db.DbIntegrityException;

public class Program {

	public static void main(String[] args) throws ParseException {
		clearScreen();
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();

			st = conn.prepareStatement("DELETE FROM department " + "WHERE " + "Id = ? ");
			st.setInt(1, 2);

			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException("Erro ao executar a operação: " + e.getMessage());
			// System.out.println("Erro ao executar a operação: " + e.getMessage());
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
