package application;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		battleGrid battle = new battleGrid(6, 3);
		battle.playerSide(0);
		battle.enemyGen('S', 'G', 'R', 150);

		battle.printGrid();
		System.out.println("");
		
		System.out.println(battle.isMoveable(4, 1));

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

	}

}
