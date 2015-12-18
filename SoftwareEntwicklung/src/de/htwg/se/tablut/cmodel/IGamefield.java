package de.htwg.se.tablut.cmodel;

public interface IGamefield {
	void setStart(int i);
	Field[][] getGameField();
	Field getField(int x, int y);
	void setGameField(Field[][] f);
	int getSizeOfGameField();
	void setSizeOfField(int i);
	void setStandard();
	void setHitAble1();
	void setHitAble2();
	void setHitAble3();
	void setHitAble4();
	void setHitAble5();
	void setHitAble6();
	void setHitAble7();
	void setHitAble8();
	void setStartfieldAttack();
	void setStartfieldDefense();
	void placeAtk();
}
