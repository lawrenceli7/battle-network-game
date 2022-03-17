package application;

public class playerChar {
	
	final static double MAX_RNG = 100;
	final static double MIN_RNG = 0;
	
	protected int[] deck = new int[4];
	
	protected String characterName; //placeholders for now
	protected int hp; 
	protected int tempHp;
	protected int speed; // 0 is lowest, 10 is highest
	protected int element; // maybe use an elemental variable type?
	protected int weaponDmg;
	protected int kills;
	
	public playerChar() { //default player model is just the sword user
		this("Swordsmen", 100, 0, 0, 0, 0);
	}
	
	public playerChar(String characterName, int hp, int speed, int element, int weaponDmg, int kills) {
		this.characterName = characterName;
		this.hp = hp;
		this.tempHp = hp;
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
	
	public void Shuffle() { // shuffles attacks
		double rng = Math.random() * (MAX_RNG - MIN_RNG + 1) + MIN_RNG;
		if(rng >= 0 && rng <25) {
			deck[0] = 1;
			deck[1] = 2;
			deck[2] = 3;
			deck[3] = 4;
		}
		else if(rng >= 25 && rng <50) {
			deck[0] = 3;
			deck[1] = 1;
			deck[2] = 4;
			deck[3] = 2;
		}
		else if(rng >= 50 && rng <75) {
			deck[0] = 4;
			deck[1] = 2;
			deck[2] = 3;
			deck[3] = 1;
		}
		else if(rng >=75 && rng <=100) {
			deck[0] = 2;
			deck[1] = 4;
			deck[2] = 3;
			deck[3] = 1;
		}
		
		
	}
	
	public void printDeck() {
		for(int i = 0; i < deck.length; i++) {
			System.out.print(deck[i]);
		}
		System.out.println("");
	}
}	


		
