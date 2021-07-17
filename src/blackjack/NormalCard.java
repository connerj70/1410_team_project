package blackjack;

public class NormalCard implements Card {
	private boolean hidden;
	
	NormalCard() {
		
	}

	@Override
	public boolean getFaceUp() {
		return false;
	}

	@Override
	public void setFaceUp(boolean hidden) {
		this.hidden = hidden;
	}

	@Override
	public int value() {
		return 0;
	}

}
