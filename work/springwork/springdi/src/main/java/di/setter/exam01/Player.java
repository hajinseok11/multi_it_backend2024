package di.setter.exam01;

public class Player implements AbstractPlayer {
	Dice d;
	int totalValue=0;	// totalValue변수는 주사위를 굴리고 얻은 결과가 저장되므로 컨테이너가 생성해주지 않아도 된다.
	public Player() {}
	
	public Player(Dice d) {
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

	public Dice getD() {
		return d;
	}

	public void setD(Dice d) {
		this.d = d;
	}
	
}