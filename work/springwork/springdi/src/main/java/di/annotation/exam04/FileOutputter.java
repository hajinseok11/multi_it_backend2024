package di.annotation.exam04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("fileoutputter")
public class FileOutputter implements Outputter {
	@Value("파일경로")
	private String filePath;
	
	public FileOutputter(String filePath) {
		super();
		this.filePath = filePath;
	}
	public FileOutputter() {
	}
	
	@Override
	public void output(String message) {
		System.out.println("output: "+ message);
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
