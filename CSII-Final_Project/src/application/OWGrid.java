package application;

public class OWGrid extends Grid {

	final static double MAX_RNG = 100;
	final static double MIN_RNG = 0;

	public OWGrid(int x, int y) { // default over world is 15x10
		super();
		this.blocks = new GridBlock[x][y];
		for (int r = 0; r < x; r++)
			for (int c = 0; c < y; c++)
				blocks[r][c] = new GridBlock();
	}

	public void enemySpawn(char enemy1, char enemy2, char enemy3, int kills) {
		double rng = Math.random() * (MAX_RNG - MIN_RNG + 1) + MIN_RNG;
		if (kills <= 13) {
			if (rng >= 66.6) {
				blocks[7][1].setEnemy(enemy1);
				blocks[11][0].setEnemy(enemy2);
				blocks[14][2].setEnemy(enemy3);
			} else if (rng < 66.6 && rng >= 33.3) {
				blocks[12][3].setEnemy(enemy1);
				blocks[11][0].setEnemy(enemy2);
				blocks[13][1].setEnemy(enemy3);
			} else {
				blocks[12][3].setEnemy(enemy1);
				blocks[7][1].setEnemy(enemy2);
				blocks[14][2].setEnemy(enemy3);
			}
		}

		else if (kills > 13 && kills <= 24) {
			if (rng >= 66.6) {
				blocks[9][1].setEnemy(enemy1);
				blocks[11][0].setEnemy(enemy2);
				blocks[14][2].setEnemy(enemy3);
				blocks[12][3].setEnemy(enemy1);
			} else if (rng < 66.6 && rng >= 33.3) {
				blocks[12][3].setEnemy(enemy1);
				blocks[11][0].setEnemy(enemy2);
				blocks[13][1].setEnemy(enemy3);
				blocks[9][1].setEnemy(enemy2);
			} else {
				blocks[12][3].setEnemy(enemy1);
				blocks[9][1].setEnemy(enemy2);
				blocks[14][2].setEnemy(enemy3);
				blocks[11][0].setEnemy(enemy3);
			}
		}

		else {
			if (rng >= 0 && rng < 25) {
				blocks[9][1].setEnemy(enemy1);
				blocks[11][0].setEnemy(enemy2);
				blocks[14][2].setEnemy(enemy3);
				blocks[12][3].setEnemy(enemy2);
				blocks[13][1].setEnemy(enemy3);
			} else if (rng >= 25 && rng < 50) {
				blocks[9][1].setEnemy(enemy2);
				blocks[11][0].setEnemy(enemy3);
				blocks[14][2].setEnemy(enemy1);
				blocks[12][3].setEnemy(enemy2);
				blocks[13][1].setEnemy(enemy3);
			} else if (rng >= 50 && rng < 75) {
				blocks[9][1].setEnemy(enemy3);
				blocks[11][0].setEnemy(enemy1);
				blocks[14][2].setEnemy(enemy2);
				blocks[12][3].setEnemy(enemy3);
				blocks[13][1].setEnemy(enemy1);
			} else {
				blocks[9][1].setEnemy(enemy3);
				blocks[11][0].setEnemy(enemy2);
				blocks[14][2].setEnemy(enemy1);
				blocks[12][3].setEnemy(enemy3);
				blocks[13][1].setEnemy(enemy2);
			}

		}
	}

	public void playerSpawn(int player1, int player2, int player3, int player4, int player5) {
		double rng = Math.random() * (MAX_RNG - MIN_RNG + 1) + MIN_RNG;
		if (rng >= 0 && rng < 25) {
			blocks[1][6].setPlayer(player1);
			blocks[3][7].setPlayer(player2);
			blocks[2][3].setPlayer(player3);
			blocks[5][9].setPlayer(player4);
			blocks[4][5].setPlayer(player5);
		} else if (rng >= 25 && rng < 50) {
			blocks[1][6].setPlayer(player2);
			blocks[3][7].setPlayer(player3);
			blocks[2][3].setPlayer(player4);
			blocks[5][9].setPlayer(player5);
			blocks[4][5].setPlayer(player1);
		} else if (rng >= 50 && rng < 75) {
			blocks[1][6].setPlayer(player3);
			blocks[3][7].setPlayer(player4);
			blocks[2][3].setPlayer(player5);
			blocks[5][9].setPlayer(player1);
			blocks[4][5].setPlayer(player2);
		} else {
			blocks[1][6].setPlayer(player4);
			blocks[3][7].setPlayer(player5);
			blocks[2][3].setPlayer(player1);
			blocks[5][9].setPlayer(player2);
			blocks[4][5].setPlayer(player3);
		}
	}

	public void printGrid() {
		for (int j = 0; j < blocks[0].length; j++) {
			for (int i = 0; i < blocks.length; i++) {
				if (blocks[i][j].hasEnemy() == true) {
					System.out.printf("[%c] ", blocks[i][j].getEnemy());
				} else if (blocks[i][j].hasPlayer() == false && blocks[i][j].hasEnemy() == false) {
					System.out.print("[ ] ");
				} else {
					System.out.printf("[%o] ", blocks[i][j].getPlayer());
				}
			}
			System.out.println("");
		}
	}

	public boolean isMoveable(int x, int y) { // checks for mobility in OW Grid using the gridblock function
		return blocks[x][y].isMoveable();
	}

}
