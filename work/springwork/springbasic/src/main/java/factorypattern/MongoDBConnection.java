package factorypattern;
public class MongoDBConnection extends Connection {
	public MongoDBConnection(String url) {
		super(url);
	}

	public void connect() {
		System.out.println(url + "위치의 MongoDB서버로 연결됐습니다.");
	}
}
