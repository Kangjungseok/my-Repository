package fullstack.objex;

//이 인터페이스는 모든 동물이 이동을 할 수 있는 수단을 제공합니다.
//걷는 형식으로는 moveSlow(int x, int y)
//moveFast(int x, int y)
//걷는 속도로는 speed와 superSpeed로 선언합니다.
public interface Moveable {

	int DOG_NORM_SPEED = 7;// 일반 걷는 속도 7km/h
	int CAT_NORM_SPEED = 10;
	int DUCK_NORM_SPEED = 3;
	
	int DOG_SUPER_SPEED = DOG_NORM_SPEED*3;// 일반 걷는 속도 7km/h
	int CAT_SUPER_SPEED = CAT_NORM_SPEED*3;
	int DUCK_SUPER_SPEED = DUCK_NORM_SPEED*3;
	
	void moveNorm(int x, int y);
	void moveFast(int x, int y);
	
}
