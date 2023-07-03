package kang;

public class Total {

	public Total() {
		// TODO Auto-generated constructor stub
	}

	private int totalplay;
	private int winR;
	private int drawR;
	private int loseR;

	public void pluswin() {
		totalplay++;
		winR++;
	}

	public void plusdraw() {
		totalplay++;
		drawR++;
	}

	public void pluslose() {
		totalplay++;
		loseR++;
	}

	public void myScore() {
		System.out.println("총 게임 수 : " + totalplay + " 승 : " + winR + " 무승부 : " + drawR + " 패 : " + loseR);
	}
}