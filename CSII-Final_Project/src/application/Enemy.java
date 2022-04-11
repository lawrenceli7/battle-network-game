package application;

public class Enemy extends playerChar {

	public Enemy() {
		setName("Enemy");
		setHP(0);
		setSpeed(0);
		setElement(0);
		setDMG(0);
		setKills(0);
	}
	
	public Enemy(String name, int r, int c) {
		setName(name);
		setLocation(r, c);
		if (name.contentEquals("rat")) {
			setHP(40);
			setElement(0);
			setDMG(20);
		}
		else if (name.contentEquals("goblin")) {
			setHP(80);
			setElement(0);
			setDMG(30);
		}
		else if (name.contentEquals("skeleton")) {
			setHP(120);
			setElement(0);
			setDMG(40);
		}
		else {
			setHP(200);
			setElement(0);
			setDMG(60);
		}
	}
}
