package fullstack.ioex;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 이 코드는 여러분이 입력한 폴더명을 기준으로 해당 폴더의 내용과 그 하위에 있는 모든 파일들의 
 * 정보를 다 조회하도록 정의합니다.
 * 
 *  
*/

public class ShowFileListEx1 {

	
	
	//폴더의 갯수와 파일의 갯수 변수 선언합니다.
	static int totalFiles = 0;
	static int totalFolders = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("폴더명 넣으세요.");
		String dirName = new Scanner(System.in).next();
		
		File dir = new File(dirName);
		if(!dir.exists() || !dir.isDirectory()) {//폴더가 없거나, 아니라면
			System.out.println("폴더 아님..");
			System.exit(0);
		}
		
		//폴더의 내용을 찾아서 하위에 폴더가 존재 시 재귀호출(Recursive)을 이용해서
		//계속 찾아내는 로직을 구현하는 메서드를 호출합니다.
		findPrintFileList(dir);
		
		System.out.println();
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalFolders + "개의 폴더");
		
		

	}


	private static void findPrintFileList(File dir) {
		System.out.println(dir.getAbsolutePath()+" 폴더");
		
		//폴더로부터 전체 파일리스트 얻어냅니다.
		File[] files = dir.listFiles();
		
		//폴더가 하나 이상인 경우 관리할 ArrayList 생성합니다.
		ArrayList subDir = new ArrayList();
		
		for(int i = 0; i<files.length;i++) {
			String fileName = files[i].getName();
			
			if(files[i].isDirectory()) {
				fileName = "[" + fileName + "]";
				//subDir.add(i+"");
				subDir.add(i);
				
			}
			System.out.println(fileName);
			
		}
		
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;
		
		totalFiles += fileNum;
		totalFolders += dirNum;
		
		System.out.println(fileNum + " 개의 파일, " + dirNum + " 개의 폴더를 찾음");
		System.out.println();
		
		for(int i = 0; i<subDir.size(); i++) {
			//int idx = Integer.parseInt((String)subDir.get(i));
			//findPrintFileList(files[idx]);
			int idx = (int)subDir.get(i);
			findPrintFileList(files[idx]);
			
		}
	}//End of findPrintFileList..

}
