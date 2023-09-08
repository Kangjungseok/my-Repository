package fullstack.ioex;

import java.io.File;
import java.io.IOException;

public class FileExam {

	public static void main(String[] args) throws IOException {
		/*
		 * 시스템별 경로 구분자 : 우리가 윈도우에서 특정 파일을 선택하면 경로(path)창에
		 * 경로가 보일 것입니다. 이 중 드라이브 표시는 ; 보여지는데, Unix나 Linux 계열은
		 *  : 로 표시합니다. 또한 경로구분자는 윈도우는 역슬래쉬, 다른 계열은 슬래쉬로
		 *  표현합니다. 이 표식자를 자동으로 시스템에 맞게 표현해주는 애들이
		 *  File 클래스의 path....xxxx 라고 되어 있는 필드들입니다.
		*/
		String theFile = "chatting.log";
		
		File parentFolder = new File("C:\\Users\\Manic-063\\git\\my-Repository\\ayeonJava");

		File file = new File(parentFolder, theFile); 
		
		if(file.exists()) {
			System.out.println("경로 : " + file.getAbsolutePath());
			System.out.println("경로 제외 파일명 : " + file.getName());
			
			System.out.println("확장자 " + file.getName().substring(file.getName().lastIndexOf(".")));
			System.out.println("파일 크기 : " + file.length() + "bytes");
			
			
			File parent = file.getParentFile();
			System.out.println("부모 폴더명 : " + parent);
			
			if(parent.isDirectory()) {
				File newFile = new File(parent, "seungmin.win");
				newFile.createNewFile();
			}
			
			String otherFile = "D:" + File.separator + "players";
			System.out.println(otherFile);
			
			File f = new File(otherFile);
			if(f.isDirectory()) {
				for(String name : f.list()) {//만약 폴더라면 하위의 파일명 모두 리턴
					System.out.println(name);
					if(name.equalsIgnoreCase("aUser.dat")) {
						File ff = new File(f,name);
						System.out.println(ff.setReadOnly()); 
						
						ff.deleteOnExit();
					}
					
				}
			}
			
			
		}
		
		
	}

}
