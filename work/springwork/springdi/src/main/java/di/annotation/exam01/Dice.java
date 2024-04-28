package di.annotation.exam01;
import java.util.Random;

import org.springframework.stereotype.Service;
@Service("dice")
public class Dice extends Random implements AbstractDice{
	public Dice() {
		System.out.println("Dice 기본생성자");
	}
	@Override
	public int getDiceValue(){
		System.out.println("dice");
		return nextInt(6)+1;
	}

}

