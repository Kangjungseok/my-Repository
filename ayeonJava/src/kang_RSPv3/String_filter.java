package kang_RSPv3;

public class String_filter {
	String name;
	public String_filter(String user_input){this.name = user_input;} //생성자
	public String filter() {
		switch(this.name) {
			case "1":
				return "가위";
			case "2":
				return "바위";
			case "3":
				return "보";
			case "가위":
			case "바위":
			case "보":
				return (String)this.name;
			default:
				return "0";
		}
	};
}