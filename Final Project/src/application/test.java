package application;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		battleGrid battle = new battleGrid(6, 3);
		battle.playerSide(0);
		battle.enemyGen('S', 'G', 'R', 150);
		
		battle.printGrid();
		System.out.println("");
		
		battleGrid battle2 = new battleGrid(6, 3);
		battle2.playerSide(0);
		battle2.bossMaxEnemyGen('S');
		battle2.spawnObstacle(70);
		
		battle2.printGrid();
		
		
		System.out.println(dmgCalc.enemyCalc(30, 1, 2));
		

	}

}