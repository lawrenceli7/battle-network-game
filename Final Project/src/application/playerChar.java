package application;

public class playerChar {
	
	protected String characterName; //placeholders for now
	protected int hp; 
	protected int speed; // 0 is lowest, 10 is highest
	protected int element; // maybe use an elemental variable type?
	protected int weaponDmg;
	private int kills;
	
	public playerChar() { //default player model is just the sword user
		this("Swordsmen", 100, 0, 0, 0, 0);
	}
	
	public playerChar(String characterName, int hp, int speed, int element, int weaponDmg, int kills) {
		this.characterName = characterName;
		this.hp = hp;
		this.speed = speed;
		this.element = element;
		this.weaponDmg = weaponDmg;
		this.kills = kills;
	}
	
	public boolean isDead() {
		return this.hp <= 0;
	}
	
	public void setName(String name) {
		this.characterName = name;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setElement(int element) {
		this.element = element;
	}
	
	public void setDMG(int weaponDmg) {
		this.weaponDmg = weaponDmg;
	}
	
	public void setKills(int kills) {
		this.kills = kills;
	}
	
	public String getName() {
		return characterName;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDMG() {
		return weaponDmg;
	}
	
	public int getKills() {
		return kills;
	}
}	
		
