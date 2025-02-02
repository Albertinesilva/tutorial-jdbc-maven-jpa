package jdbc2.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	/**
	 * Obtém uma conexão com o banco de dados usando as configurações definidas no
	 * arquivo db.properties.
	 * Este método deve ser utilizado quando a senha estiver definida diretamente no
	 * arquivo db.properties,
	 * ou seja, sem o uso de variáveis de ambiente (${MYSQL_DATASOURCE_PASSWORD}).
	 * 
	 * Se a senha for configurada como uma variável de ambiente, é necessário tratar
	 * essa substituição
	 * antes de chamar este método para evitar erros de autenticação.
	 * 
	 * @return Connection objeto de conexão com o banco de dados
	 * @throws DbException se houver falha na conexão
	 */
	// public static Connection getConnection() {
	// if (conn == null) {

	// try {
	// Properties props = loadProperties();
	// String url = props.getProperty("dburl");
	// conn = DriverManager.getConnection(url, props);

	// } catch (SQLException e) {
	// throw new DbException(e.getMessage());
	// }
	// }
	// return conn;
	// }

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");

				// Tratando a variável de ambiente manualmente
				String password = props.getProperty("password");
				if (password.startsWith("${") && password.endsWith("}")) {
					String envVar = password.substring(2, password.length() - 1);
					password = System.getenv(envVar);
					props.setProperty("password", password); // Atualiza a senha real no properties
				}

				// Define a senha diretamente do ambiente
				// String password = System.getenv("MYSQL_DATASOURCE_PASSWORD");
				// if (password != null) {
				// props.setProperty("password", password);
				// }

				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException("Erro ao conectar ao banco: " + e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("D:\\conexao_com_banco\\src\\jdbc2\\db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {

		if (st != null) {

			try {
				st.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {

		if (rs != null) {

			try {
				rs.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}