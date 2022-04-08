package application;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		battleGrid battle = new battleGrid(6, 3);
		battle.playerSide(0);
		battle.enemyGen('S', 'G', 'R', 150);

		battle.printGrid();
		System.out.println("");

		// player movement testing
		Swordsmen deez = new Swordsmen();
		String act = "LF"; //Testing
		//String act = deez.action(1); Call through .action
		System.out.println(battle.isMoveable(act, deez));
		Boolean canMove = battle.isMoveable(act, deez);
		if (canMove = true) {
			battle.moveEntity(act, deez);
			battle.printGrid();
		}
		System.out.println("");

		battleGrid battle2 = new battleGrid(6, 3);
		battle2.playerSide(0);
		battle2.bossMaxEnemyGen('S');
		battle2.spawnObstacle(70);

		battle2.printGrid();

		System.out.println(dmgCalc.enemyCalc(30, 1, 2));

		OWGrid bruh = new OWGrid(15, 10);
		bruh.enemySpawn('S', 'G', 'R', 30);
		bruh.playerSpawn(0, 1, 2, 3, 4);
		bruh.printGrid();

		System.out.println(bruh.isMoveable(1, 4));

		System.out.println(dmgCalc.playerCalc(30, 5, 0));

		System.out.println(dmgCalc.enemyCalc(30, 5, 0));

		Swordsmen sword = new Swordsmen();

		sword.Shuffle();

		sword.printDeck();

		System.out.println(sword.action(KeyEvent.VK_X));
		System.out.println(sword.action(KeyEvent.VK_X));
		System.out.println(sword.action(KeyEvent.VK_X));
		System.out.println(sword.action(KeyEvent.VK_X));

		System.out.println("");
		sword.printDeck();
		System.out.println(sword.action(KeyEvent.VK_X));
	}

}
