package kang;

public class Computer_select {
	int comnum;

	public static int comnum() {
		int comnum = (int) (Math.random() * 3) + 1;
		return comnum;
	}
}