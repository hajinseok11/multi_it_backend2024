package factorypattern;
// 객체생성만 담당하는 클래스
public class ConnectionFactory {
	public Connection getConnection(String str) {
		String url = str.toLowerCase();
		// 지금은 if문을 이용해서 객체를 가져오지만 자동으로 객체가 만들어질 수 있도록
		// properties 파일, xml에 객체를 등록하면 시작될 때 파일에 등록된 객체를 자동으로 만들고 시작하도록 구현
		if (url.indexOf("oracle") >= 0) {
			return new OracleConnection(url);
		} else if (url.indexOf("mysql") >= 0) {
			return new MySQLConnection(url);
		} else if (url.indexOf("mongo") >= 0){
			return new MongoDBConnection(url);
		} else {
			return null;
		}
	} 	
}
