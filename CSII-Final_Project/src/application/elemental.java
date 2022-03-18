package application;

public class elemental {

	private static int element; // 0 = none, 1 = fire, 2 = aqua/water, 3 = wood, 4 = electric, 5 = all attacks
								// do double damage

	public elemental(int e) { // constructor
		element = e;
	}

	public elemental() { // default constructor
		element = 0;
	}

	public int eleDamage(int base, int e) { // damage calculator
		int total = base;
		if (element == 0) { // no element, no damage boost or damage reduction
			total = base;
		} else if (strength(e) == true) { // if it's weak, do calculation
			total = weak(base);
		} else if (strength(e) == false) { // if it's strong, do calculation
			total = strong(base);
		}
		return total;
	}

	private int strong(int b) {
		return (b / 2);
	}

	private int weak(int b) {
		return (b * 2);
	}

	private boolean strength(int e) {
		if (element == 1 && e == 2) { // checks fire weakness to water
			return true;
		} else if (element == 2 && e == 4) { // checks water weakness to electric
			return true;
		} else if (element == 3 && e == 1) { // checks wood weakness to fire
			return true;
		} else if (element == 4 && e == 3) { // checks electric weakness to wood
			return true;
		} else if (element == 5) {
			return true;
		} else {
			return false;
		}
	}

}
