package application;

public class dmgCalc {

	final static double MAX_RNG = 100;
	final static double MIN_RNG = 0;

	public dmgCalc() {

	}

	public static int enemyCalc(int d, int elPlayer, int elEnemy) { // crit calculator. Only enemies can crit, to help
																	// with their chances against the player.
		int dmg = d;
		elemental el = new elemental(elPlayer);
		if (isCrit() == true) {
			dmg = dmg * 2;
		}
		dmg = el.eleDamage(dmg, elEnemy);
		return dmg;
	}

	private static boolean isCrit() { // applies only to enemies;
		double rng = Math.random() * (MAX_RNG - MIN_RNG + 1) + MIN_RNG;
		if (rng >= 85) {
			return true;
		}
		return false;
	}

	public static int playerCalc(int d, int elPlayer, int elEnemy) { // player damage calculator
		int dmg = d;
		elemental el = new elemental(elEnemy);
		dmg = el.eleDamage(dmg, elPlayer);
		if (elPlayer == 5) {
			dmg = dmg * 2;
		}
		return dmg;
	}

}
