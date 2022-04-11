package application;

public class battleGrid extends Grid {
	final static double MAX_RNG = 100;
	final static double MIN_RNG = 0;

	public battleGrid(int x, int y) {
		super();
		this.blocks = new GridBlock[x][y];
		// May change later when
		for (int r = 0; r < x; r++) {
			for (int c = 0; c < y; c++) {
				blocks[r][c] = new GridBlock();
				blocks[r][c].setX(15+(210*r));
				blocks[r][c].setY(15+(160*c));
			}
		}
	}

	public void playerSide(int player) {
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				if (i > 2) {
					blocks[i][j].setSide(2);

				} else if (i < 3) {
					blocks[i][j].setSide(1);
				}
			}
		}
		blocks[1][1].setPlayer(player);
	}

	public void enemyGen(char enemy, char enemy2, char enemy3, int health) {
		double rng;
		int enemyCount = 0;
		int limit = 3;
		if (health > 100 && health <= 200) { // updates enemy limit to allow for higher difficulty with more health
			limit = 4;
		}
		if (health > 200) {
			limit = 5;
		}
		for (int i = 3; i < blocks.length; i++) { // assigns the enemy location, type, and level
			for (int j = 0; j < blocks[0].length; j++) {
				rng = Math.random() * (MAX_RNG - MIN_RNG + 1) + MIN_RNG;
				if (rng > 70 && enemyCount < limit) {
					rng = Math.random() * (MAX_RNG - MIN_RNG + 1) + MIN_RNG;
					if (rng >= 0 && rng < 40.0) {
						blocks[i][j].setEnemy(enemy); // if statements with a new rng value in order to determine which
						blocks[i][j].setEnemy("rat", i, j);// of the three input enemy types spawn.
					} else if (rng >= 40 && rng < 70) {
						blocks[i][j].setEnemy(enemy2);
						blocks[i][j].setEnemy("goblin", i, j);
					} else {
						blocks[i][j].setEnemy(enemy3);
						blocks[i][j].setEnemy("skeleton", i, j);
					}
					enemyCount++;
				}
			}
		}
		if (enemyCount == 0) {
			blocks[3][2].setEnemy(enemy);
			blocks[3][2].setEnemy("rat", 2, 3);
			blocks[3][2].setLevel(2); // spawns 2 enemies if (somehow) at least one does not spawn.
			blocks[5][0].setEnemy(enemy2);
			blocks[5][0].setEnemy("goblin", 2, 3);
			blocks[5][0].setLevel(2);
		} else if (enemyCount < limit) { // assigns enemy level if spawn count is less than limit
			for (int i = 3; i < blocks.length; i++) {
				for (int j = 0; j < blocks[0].length; j++) {
					if ((blocks[i][j].getEnemy() == enemy || blocks[i][j].getEnemy() == enemy2
							|| blocks[i][j].getEnemy() == enemy3) && limit - enemyCount == 1) {
						blocks[i][j].setLevel(2);
						;
					} else if ((blocks[i][j].getEnemy() == enemy || blocks[i][j].getEnemy() == enemy2
							|| blocks[i][j].getEnemy() == enemy3) && limit - enemyCount == 2) {
						blocks[i][j].setLevel(3);
					} else if ((blocks[i][j].getEnemy() == enemy || blocks[i][j].getEnemy() == enemy2
							|| blocks[i][j].getEnemy() == enemy3)) {
						blocks[i][j].setLevel(4);
					}
				}
			}
		}
	}

	public void bossMaxEnemyGen(char enemy) {
		blocks[4][1].setEnemy(enemy);
		blocks[4][1].setLevel(4);
		blocks[4][1].setEnemy("boss", 4, 1);
	}

	public void spawnObstacle(int health) {
		if (health < 100) {
			blocks[0][2].setObstacle(6);
		}
		if (health > 70 && health < 90 && blocks[3][2].hasEnemy() == false) {
			blocks[3][2].setObstacle(6);
		}
	}

	public void printGrid() {
		for (int j = 0; j < blocks[0].length; j++) {
			for (int i = 0; i < blocks.length; i++) {
				System.out.printf("[%s] ", blocks[i][j]);
			}
			System.out.println("");
		}
	}

	public boolean isMoveable(String act, playerChar a) { // checks for mobility in battle grid using the gridblock function
		int[] current = a.getlocation();
		if (act == "LF") {
			if ((current[0] - 1) <= 2 && current[0] != 0) {
				return blocks[current[0] - 1][current[1]].isMoveable();
			}
			else {
				return false;
			}
		}
		else if (act == "UP") {
			if ((current[1] - 1) >= 0 && current[1] != 0) {
				return blocks[current[0]][current[1] - 1].isMoveable();
			}
			else {
				return false;
			}
		}
		else if (act == "RT") {
			if ((current[0] + 1) <= 2 && current[0] != 2) {
				return blocks[current[0] + 1][current[1]].isMoveable();
			}
			else {
				return false;
			}
		}
		else {
			if ((current[1] + 1) <= 2 && current[1] != 2) {
				return blocks[current[0]][current[1] + 1].isMoveable();
			}
			else {
				return false;
			}
		}
	}
	
	public void moveEntity(String act, playerChar a) {
		int[] current = a.getlocation();
		if (act == "LF") {
			blocks[current[0]][current[1]].setPlayer(10);
			blocks[current[0] - 1][current[1]].setPlayer(0);; //playerChar a
		}
		else if (act == "UP") {
			blocks[current[0]][current[1]].setPlayer(10);
			blocks[current[0]][current[1] - 1].setPlayer(0); //playerChar a
		}
		else if (act == "RT") {
			blocks[current[0]][current[1]].setPlayer(10);
			blocks[current[0] + 1][current[1]].setPlayer(0); //playerChar a
		}
		else {
			blocks[current[0]][current[1]].setPlayer(10);
			blocks[current[0]][current[1] + 1].setPlayer(0); //playerChar a
		}
	}
	
	public void moveEntity(playerChar p, playerChar e) {
		int[] plocate = p.getlocation();
		int[] elocate = e.getlocation();
		int diff = plocate[1] - elocate[1];
		if (diff >= 1) {
			blocks[elocate[0]][elocate[1]+1].setEnemy(blocks[elocate[0]][elocate[1]].getEnemy());
			blocks[elocate[0]][elocate[1]+1].setEnemy(e);
			blocks[elocate[0]][elocate[1]].setEnemy('1');
			blocks[elocate[0]][elocate[1]].setEnemy(null);
			
		}
		else if (diff <= -1) {
			e.setLocation(elocate[0], elocate[1]-1);
			blocks[elocate[0]][elocate[1]-1].setEnemy(blocks[elocate[0]][elocate[1]].getEnemy());
			blocks[elocate[0]][elocate[1]-1].setEnemy(e);
			blocks[elocate[0]][elocate[1]].setEnemy('1');
			blocks[elocate[0]][elocate[1]].setEnemy(null);
		}
		else {
			return;
		}
	}
	
	public int playerDistance(playerChar p, singleShotAI e) {
		int[] plocate = p.getlocation();
		int[] elocate = e.getlocation();
		return plocate[0] - elocate[0];
	}
}
