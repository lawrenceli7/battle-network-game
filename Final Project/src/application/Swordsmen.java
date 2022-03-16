package application;

public class Swordsmen extends playerChar {

	public Swordsmen() {
		setName("Swordsmen");
		setHP(100);
		setSpeed(5);
		setElement(0);
		setDMG(40);
		setKills(0);
	}
	
	public void ultAtk() {
		setElement(5);
	}
	
	public void ultEnd() {
		setElement(0);
	}
	
}
