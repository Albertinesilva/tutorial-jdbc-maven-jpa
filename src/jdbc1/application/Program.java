package jdbc1.application;

import java.sql.Connection;

import jdbc1.db.DB;

public class Program {

	public static void main(String[] args) {
		clearScreen();
		Connection conn = DB.getConnection();
		DB.closeConnection();

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
