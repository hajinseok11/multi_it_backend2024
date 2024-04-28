package di.annotation.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("player")
public class Player implements AbstractPlayer {
	@Autowired
	@Qualifier("dice2")
	AbstractDice d;
	int totalValue=0;	// totalValue변수는 주사위를 굴리고 얻은 결과가 저장되므로 컨테이너가 생성해주지 않아도 된다.
	public Player() {
		
	}
	public Player(AbstractDice d) {
		super();
		this.d = d;
	}
	@Override
	public void play(){
		totalValue=0; 
		for (int i = 0; i < 3; i++) {
			totalValue+=d.getDiceValue();
		}
	}
	@Override
	public int getTotalValue(){
		return totalValue;
	}
}