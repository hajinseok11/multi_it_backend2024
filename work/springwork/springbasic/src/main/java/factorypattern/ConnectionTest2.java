package factorypattern;

public class ConnectionTest2 {
	public static void main(String[] args) {
		ConnectionFactory factory =  new ConnectionFactory();
		Connection mysql = factory.getConnection("ORACLE://127.0.0.1:5000");
		
		mysql.connect();
	}

}
