package application;

public class singleShotAI extends playerChar{

	final int HP_1 = 50; // HP values for each level of the SinglEShot enemy
	final int HP_2 = 80;
	final int HP_3 = 130;
	final int HP_MAX = 150;

	final int ATK_1 = 15; // Attack values for each level of the SingleShot Enemy
	final int ATK_2 = 30;
	final int ATK_3 = 45;
	final int ATK_MAX = 60;
	
	private char type;
	
	public singleShotAI() {
		
	}
	
	public singleShotAI(int lvl) {
		this.type = 'S';
		this.element = 0;
		if(lvl == 1) {
			this.tempHp =HP_1;
			this.weaponDmg = ATK_1;
		}
		else if(lvl == 2) {
			this.tempHp =HP_2;
			this.weaponDmg = ATK_2;
		}
		else if(lvl == 3) {
			this.tempHp =HP_3;
			this.weaponDmg = ATK_3;
		}
		else if(lvl == 4) {
			this.tempHp =HP_MAX;
			this.weaponDmg = ATK_MAX;
		}
		
	}

	public boolean snglSht1_Behavior() {

		return true;
	}

}
