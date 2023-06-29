package fullstack.ioex;

import java.io.File;

public class DeleteExam {

	// 삭제 대상에 지워진 파일 갯수 변수 선언
	static int deletedFiles = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File parent = new File("D:\\players");
		File child = new File(parent, "bUser.dat");

		/*
		 * //파일 삭제 할게요. if(parent.delete()) { System.out.println(parent.getName() +
		 * " 이 삭제됨"); }
		 */

		delete(parent);
		System.out.println("총 " + deletedFiles + " 개의 파일 삭제됨");

	}
	// 삭제 메서드를 정의합니다.
	// 알고리즘은 폴더가 나오지 않을 때까지 하위 폴더를 찾아서 들어가야 합니다.
	// 때문에 현재 폴더에 하위 폴더가 몇 개 있는지를 리스트 형식으로 담아둬야 합니다.
	// 또한 재귀호출은 내가 나를 호출하는(a메서드가 a메서드 자신을 호출하는) 형태이기
	// 때문에 호출할 때마다 새로운 stack()이 생기고 여기서 list 등의 instance를 생성하면
	// 각 stack마다 고유한 list를 보유하게 된다는걸 꼭 이해해야 합니다.

	private static void delete(File dir) {
		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				delete(files[i]);
			} else {
				String fileName = files[i].getAbsolutePath();

				if (files[i].delete()) {
					System.out.println(fileName + " 이 삭제됨");
					deletedFiles++;

				}

			}

		}

	}

}
