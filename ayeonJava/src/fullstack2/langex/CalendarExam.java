package fullstack2.langex;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		// calendar 객체 생성함
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		now.set(Calendar.MONTH, Calendar.DECEMBER);
		
		
		
		
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		
		Date dnow = now.getTime();
		System.out.println(dnow);
		
		Date dnow2 = new Date(System.currentTimeMillis())  ;
		System.out.println(dnow2);
		
		
		Calendar convDnow2 = Calendar.getInstance();//^dnow2값을 파라미터로 받는 Calendar 객체 만들고 싶다면
		convDnow2.setTime(dnow2);
		
		int today = convDnow2.get(Calendar.DAY_OF_YEAR);
		
		
		 // 크리스마스
		int tillChristmas = today - now.DAY_OF_YEAR;
		System.out.println("올해 크리스마스까지"+ (convDnow2.get(Calendar.DAY_OF_YEAR) - now.DAY_OF_YEAR) + "일 남았습니다");
		
		
		
		//날짜를 특정 형식을 포맷하는 DateFormat 을 봅니다.
		//날짜, 문자, 숫자 등 모든 형식을 format하는 애가 있는데,
		//걔는 나중에 시간되면 보고, 날짜형식만 먼저 볼게요.
		
		
		String format = "지금은 yy년MM월dd일 a HH 시 mm 분 ss 초입니다.";
		//format을 SimpleDateFormat 객체의 파람으로 넘깁니다.
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//상속받은 format(Date)를 호출해서 위 포맷대로 현재 시간을 표현합니다.
		System.out.println(sdf.format(Calendar.getInstance().getTime())); 
		
		
		
		
		
		
		
		
	}

}
