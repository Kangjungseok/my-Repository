package fullstack.objex;
class Account{
	private String accNo;
	private String name;
	private int balance;
	
	public Account(String accNo, String name, int balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
	}
	//객체의 속성값을 외부에 전달하도록 정의하는 메서드를 앞으로 getter라고 합니다. 꼭 기억
	public String getAccNo() {
		return accNo;
	}
	public int getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
}


class Loan{//대출계좌 클래스 
	private int loanMoney;
	private String expireDate;
	private String accNo; //대출금 및 이자 입출금 계좌
	private String lname;
	//final 키워드 : 클래스, 필드, 메서드에 모두 선언 가능합니다.
	//클래스에 선언하면 상속 금지, 필드에 선언하면 상수(즉 값 변경 금지 및 선언 시 반드시 초기화)
	//메서드에 선언하면 오버라이드 금지
	//메서드의 파라미터에 선언되면, 지역내에서 값 변경 금지, 만약 객체라면 객체변경 금지.
	public final static double RATE; //이자율
	
	//프로그램이 실행시 호출순서 --> static 초기화 블럭 --> static final field --> 
	//static fields --> static methods --> main() --> instance 초기화 블락 -->
	//instance 생성(만약 코드가 있다면)
	
	
	//static 초기화 블럭을 이용한 final 초기화
	static {
		RATE=3;
	}
	
	Account acc;
	
	public Loan(int loanMoney, String expireDate) {
		this.loanMoney = loanMoney;
		this.expireDate = expireDate;
		}
	
	
	//대출계좌주의 입출금 계좌와 계좌주 명을 setting 하는 setter 정의함.
	public void setAccNo(Account account) {
		this.accNo = account.getAccNo();
	}
	public void setLname(Account account) {
		this.lname = account.getName();
	}
	
	
	public String toString() {
		return "대출자 이름 " + lname + " 금액 : " + loanMoney + "\n" + 
				"계좌번호 : " + accNo + " 대출완납기한 : " + expireDate;
	}
	
	//월 이자율 계산해서 리턴하는 메서드 정의
	public double getInterest() {
		return this.loanMoney * this.RATE/ 6;
	}
	
	public static double getRate() {
		return RATE;
	}
	
	
}
public class StaticExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account kause = new Account("12345", "kause", 10000);
		Account hank = new Account("67890", "hank", 10000);
		
		//두 사람의 대출 계좌를 생성합니다. 금리는 6.5, 날짜는 2023-12-31
		Loan kLoan = new Loan(100000000, "2023-12-31");
		Loan hLoan = new Loan(50000000, "2023-12-31");
		
		
		//계좌번호와 이름을 세팅하도록 setter 호출합니다.
		kLoan.setAccNo(kause);
		kLoan.setLname(kause);
		
		hLoan.setAccNo(hank);
		hLoan.setLname(hank);
		
		/*
		System.out.println(kLoan.getInterest());
		System.out.println(hLoan.getInterest());
		*/
		
		System.out.println(kLoan.RATE);
		//Loan.RATE = 5;
		
		
		
		
		
	}

}
