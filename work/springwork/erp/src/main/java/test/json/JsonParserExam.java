package test.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserExam {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		JSONObject root = (JSONObject) parser.parse(new FileReader("src/main/java/test/json/myjson2.json"));
		
		String id = (String) root.get("name");
		String age = (String) root.get("age");
		System.out.println("id="+id);
		System.out.println("age="+age);
		
		JSONArray subjectlists = (JSONArray)root.get("subjectlist");
		for (int i = 0;i<subjectlists.size(); i++) {
			String subject = (String)subjectlists.get(i);
			System.out.println("subject:"+subject);
		}
		JSONArray historylist = (JSONArray)root.get("historylist");
		for (int i = 0;i<historylist.size(); i++) {
			JSONObject history = (JSONObject)historylist.get(i);
			System.out.println("month:"+history.get("month"));
			System.out.println("subject:"+history.get("subject"));
			System.out.println("============================");
		}
		
		JSONObject addr = (JSONObject)root.get("addr");
		String zip = (String)addr.get("zip");
		String addr1 = (String)addr.get("addr1");
		System.out.println("zip:"+zip);
		System.out.println("addr1:"+addr1);

		}
		
	}

