package di.setter.exam01;
import java.util.Random;

public class Dice extends Random implements AbstractDice{
	private Dice dice;
	public Dice() {
		System.out.println("Dice 기본생성자");
	}
	
	@Override
	public int getDiceValue(){
		return nextInt(6)+1;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

}

