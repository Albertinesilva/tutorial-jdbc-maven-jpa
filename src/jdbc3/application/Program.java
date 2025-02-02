package jdbc3.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jdbc3.db.DB;

public class Program {

	public static void main(String[] args) throws ParseException {
		clearScreen();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			/*
			st = conn.prepareStatement("INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)  " 
					+ "VALUES " 
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1,  "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3,  new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5,  4);
			*/
			
			st = conn.prepareStatement("insert into department (Name) values ('D1'), ('D2')",Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();
			
			//System.out.println("Done! Rows affected: " + rowsAffected);
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
				
			}else {
				System.out.println("No rown affected!");
			}
				
		}catch(SQLException e){
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
