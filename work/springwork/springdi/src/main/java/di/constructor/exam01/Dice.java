package di.constructor.exam01;
import java.util.Random;

public class Dice extends Random implements AbstractDice{
	public Dice() {
		System.out.println("Dice 기본생성자");
	}
	
	@Override
	public int getDiceValue(){
		return nextInt(6)+1;
	}

}

