
public class DebugerB {

	int a;
	int b;
	
	int result;
	
	
	void methoda(int a, int b) {
		this.a = a;
		this.b = b;
		
		result = this.a + this.b;
		
		makeArr();
	}
	void makeArr() {
		int arr[] = {1,2,3};
		for(int a : arr) {
			this.a = a;
		}
	}
	
	
}
