package blackjack;

public class NormalCard implements Card {
	private boolean faceUp = true;
	private int value = 0;
	
	NormalCard(int value, boolean faceUp) {
		this.faceUp = faceUp;
		this.value = value;
	}

	@Override
	public boolean getFaceUp() {
		return faceUp;
	}

	@Override
	public void setFaceUp() {
		faceUp = true;
	}

	@Override
	public int value() {
		return value;
	}

}
