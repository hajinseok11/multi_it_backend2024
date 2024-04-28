package di.annotation.exam04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("messageBean")
public class MessageBean implements InterMessage {
	@Value("정국")
	private String name;
	@Value("안녕하세요")
	private String greeting;
	@Autowired
	private Outputter outputter;
	public MessageBean() {
	}
	public MessageBean(String name) {
		super();
		this.name = name;
	}
	public MessageBean(String name, String greeting, Outputter outputter) {
		super();
		this.name = name;
		this.greeting = greeting;
		this.outputter = outputter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public Outputter getOutputter() {
		return outputter;
	}
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	@Override
	public void sayHello() {
		System.out.println("Hello");
	}
	
	
	
	

}
