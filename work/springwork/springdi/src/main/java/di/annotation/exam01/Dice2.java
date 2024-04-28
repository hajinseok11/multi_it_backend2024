package di.annotation.exam01;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("dice2")
public class Dice2 extends Random implements AbstractDice{
	public Dice2() {
		System.out.println("Dice2 기본생성자");
	}

	@Override
	public int getDiceValue() {
		System.out.println("dice2");
		return (nextInt(6)+1)*2;
	}
	
}
