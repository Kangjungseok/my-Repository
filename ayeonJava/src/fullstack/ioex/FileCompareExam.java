package fullstack.ioex;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

/*
 * 이 클래스는 compare 기능을 이용해서 파일의 속성 등에 따른 정렬을 작성해봅니다.
 *  
*/

public class FileCompareExam {

	static String theFolder = null;
	static String sortOption = null;
	
	
	private static void getOption() {
System.out.println("폴더 명을 입력하세요 : ");
		
		JOptionPane.showMessageDialog(null, 
				"---- 정렬 조건 ----\n" + 
				"---- t : Time Asceding sort.\n" +
				"---- T : Time Desceding sort.\n" +
				"---- l : Length Asceding sort.\n" +
				"---- L : Length Desceding sort.\n" +
				"---- n : Name Asceding sort\n" +
				"---- N : Name Desceding sort"
				);
		
		String inputDate =JOptionPane.showInputDialog("폴더Path와 정렬 조건을 / 구분으로 넣으세요.");
		
		JOptionPane.showConfirmDialog(null,inputDate);
		
		//StringToknizer 를 이용해서 : 로 분리된 값을 분리할게요
		StringTokenizer st = new StringTokenizer(inputDate, "/");
		
		while(st.hasMoreElements()) {
			theFolder = st.nextToken();
			sortOption = st.nextToken();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		getOption();
	
		/*
		System.out.println(theFolder);
		System.out.println(sortOption);
		*/
		
		
		/*
		 * 입력된 폴더명을 File 객체로 생성하구요, 먼저 내부에 있는 모든 파일 리스트를 가져옵니다.
		 * 가져온 후, 정렬 조건으로 쓰일 값들을 땡겨오구요, 이걸 가지고 비교(compare)를 한 후에
		 * 조건식에 넣어서 처리할 예정입니다.
		*/
		
		File currDir = new File(theFolder);//해당 폴더 대상으로 File 객체 생성하기
		File[] fileList = currDir.listFiles();//파일목록 얻기
		
		//아래는 드디어, 익명 객체를 이용하는 코드를 정의합니다.
		//잘 기억해보세요.
		
		Comparator comp = new Comparator() {
			
			@Override
			public int  compare(Object obj1, Object obj2) {
				
				
				//파일의 생성 시간값을 가져올게요..
				long time1 = ((File)obj1).lastModified();
				long time2 = ((File)obj2).lastModified();
				
				Long length1 = ((File)obj1).length();
				Long length2 = ((File)obj1).length();
				
				String name1 = ((File)obj1).getName();
				String name2 = ((File)obj2).getName();
				
				int result = 0; //비교 결과값을 리턴할 변수 초기화 함
				
				switch (sortOption) {
				case "t":
					result = (int)(time1 - time2);
					break;
				case "T":
					result = (int)(time2-time1);
					break;
				case "l":
					result = length1.compareTo(length2);
					break;
				case "L":
					result = length2.compareTo(length1);
					break;
				case "n":
					result = name1.compareTo(name2);
					break;
				case "N":
					result = name2.compareTo(name1);
					break;

				}//End of switch
				return result;
			};//End of compare()
		};//End of comparator..;
		
		//fileList의 배열에 있는 모든 요소를 comp 익명 객체가 순회를 하면서 
		//자동 정렬해 줍니다.
		Arrays.sort(fileList, comp);
		
		//출력하도록 정의합니다.
		for(int i = 0 ; i<fileList.length;i++) {
			File f = fileList[i];
			String name = f.getName();
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String attribute = "";
			String size = "";
			
			if(fileList[i].isDirectory()) {
				attribute = "DIR(folder)";
			}else {
				size = f.length() + "";
				attribute = f.canRead()?"R":"";
				attribute += f.canWrite()?"W":"";
				attribute += f.isHidden()?"H":"";
			}
			
			System.out.printf("%s %3s %6s %s\n",
			sdf.format(new Date(f.lastModified())), attribute,size, name);
			

			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
