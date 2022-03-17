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
		if(rng <= 1/24 && rng >= 0) {
			int[] deck2 = {1, 2, 3, 4};
			deck = deck2;
			}
		else if(rng <= 2/24 && rng > 1/24) {
			int[] deck2 = {1, 2, 4, 3};
			deck = deck2;
		}
		else if(rng <= 3/24 && rng > 2/24) {
			int[] deck2 = {1, 4, 2, 3};
			deck = deck2;
		}
		else if(rng <= 4/24 && rng > 3/24) {
			int[] deck2 = {4, 1, 2, 3};
			deck = deck2;
		}
		else if(rng <= 5/24 && rng > 4/24) {
			int[] deck2 = {1, 3, 2, 4};
			deck = deck2;
		}
		else if(rng <= 6/24 && rng > 5/24) {
			int[] deck2 = {1, 3, 4, 2};
			deck = deck2;
		}
		else if(rng <= 7/24 && rng > 6/24) {
			int[] deck2 = {1, 4, 3, 2};
			deck = deck2;
		}
		else if(rng <= 8/24 && rng > 7/24) {
			int[] deck2 = {4, 1, 3, 2};
			deck = deck2;
		} 
		else if(rng <= 9/24 && rng > 8/24) {
			int[] deck2 = {3, 1, 2, 4};
			deck = deck2;
		}
		else if(rng <= 10/24 && rng > 9/24) {
			int[] deck2 = {3, 1, 4, 2};
			deck = deck2;
		}
		else if(rng <= 11/24 && rng > 10/24) {
			int[] deck2 = {3, 4, 1, 2};
			deck = deck2;
		}
		else if(rng <= 12/24 && rng > 11/24) {
			int[] deck2 = {4, 3, 1, 2};
			deck = deck2;
		}
		else if(rng <= 13/24 && rng > 12/24) {
			int[] deck2 = {2, 1, 3, 4};
			deck = deck2;
		}
		else if(rng <= 14/24 && rng > 13/24) {
			int[] deck2 = {2, 1, 4, 3};
			deck = deck2;
		}
		else if(rng <= 15/24 && rng > 14/24) {
			int[] deck2 = {2, 4, 1, 3};
			deck = deck2;
		}
		else if(rng <= 16/24 && rng > 15/24) {
			int[] deck2 = {4, 2, 1, 3};
			deck = deck2;
		}
		else if(rng <= 17/24 && rng > 16/24) {
			int[] deck2 = {2, 3, 1, 4};
			deck = deck2;
		}
		else if(rng <= 18/24 && rng > 17/24) {
			int[] deck2 = {2, 3, 4, 1};
			deck = deck2;
		}
		else if(rng <= 19/24 && rng > 18/24) {
			int[] deck2 = {2, 4, 3, 1};
			deck = deck2;
		}
		else if(rng <= 20/24 && rng > 19/24) {
			int[] deck2 = {4, 2, 3, 1};
			deck = deck2;
		}
		else if(rng <= 21/24 && rng > 20/24) {
			int[] deck2 = {3, 2, 1, 4};
			deck = deck2;
		}
		else if(rng <= 22/24 && rng > 21/24) {
			int[] deck2 = {3, 2, 4, 1};
			deck = deck2;
		}
		else if(rng <= 23/24 && rng > 22/24) {
			int[] deck2 = {3, 4, 2, 1};
			deck = deck2;
		}
		else if(rng <= 1 && rng > 23/24) {
			int[] deck2 = {4, 3, 2, 1};
			deck = deck2;
		}
		
		
	}
}	
		
