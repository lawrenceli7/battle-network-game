package application;

import java.util.Scanner;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Swordsmen extends playerChar {

	public Swordsmen() {
		setName("Swordsmen");
		setHP(100);
		setSpeed(5);
		setElement(0);
		setDMG(40);
		setKills(0);
	}

	public void ultAtk() { // activates ult
		setElement(5);
	}

	public void ultEnd() { // ult ends or battle ends, resets element
		setElement(0);
	}

	public void addKills(int k) { // need this for generation
		this.kills += k;
	}

	public int attack1() { // each return value is just the damage. Dunno what each one will actually do
							// though
		return 50;
	}

	public int attack2() {
		return 30;
	}

	public int attack3() {
		return 60;
	}

	public int attack4() { // this one heals and adds 2 hp for every use. Just so it doesn't become broken.
		if (tempHp >= hp - 10) {
			tempHp = hp;
			hp = hp + 2;
		} else {
			tempHp = tempHp + 10;
			hp = hp + 2;
		}

		return 10;
	}

	public String action(int k) {

		String act = "";

		int code = k;
		if (code == KeyEvent.VK_LEFT) { // movements
			act = "LF";
			return act;
		} else if (code == KeyEvent.VK_UP) {
			act = "UP";
			return act;
		} else if (code == KeyEvent.VK_RIGHT) {
			act = "RT";
			return act;
		} else if (code == KeyEvent.VK_DOWN) {
			act = "DN";
			return act;
		} else if (code == KeyEvent.VK_X) { // attack
			for (int i = 0; i < deck.length; i++) {
				if (i == 3) {
					if (deck[i] == 1) {
						Shuffle();
						act = "ATK1";
						return act;
					} else if (deck[i] == 2) {
						Shuffle();
						act = "ATK2";
						return act;
					} else if (deck[i] == 3) {
						Shuffle();
						act = "ATK3";
						return act;
					} else if (deck[i] == 4) {
						Shuffle();
						act = "ATK4";
						return act;
					}
				} else if (i < 3) {
					if (deck[i] == 1) {
						deck[i] = 0;
						act = "ATK1";
						return act;
					} else if (deck[i] == 2) {
						deck[i] = 0;
						act = "ATK2";
						return act;
					} else if (deck[i] == 3) {
						deck[i] = 0;
						act = "AT3";
						return act;
					} else if (deck[i] == 4) {
						deck[i] = 0;
						act = "ATK4";
						return act;
					}
				}
			}
		} else if (code == KeyEvent.VK_Z) { // base weapon
			act = "WE";
			return act;
		} else if (code == KeyEvent.VK_SPACE) { // ult
			act = "ULT";
			return act;
		}
		return act;
	}

}
