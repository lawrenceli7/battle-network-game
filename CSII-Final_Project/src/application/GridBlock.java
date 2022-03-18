package application;

public class GridBlock {
	private int side = 10; // 10 being placeholders simply for the hasXYZ methods to work
	private char enemyType = '1';
	private int playerType = 10;
	private int obstacleType = 10;
	private int enemyLevel = 10;
	private boolean battleBlock;

	public GridBlock() {

	}

	public void setSide(int side) { // sets data
		this.side = side;
	}

	public void setEnemy(char enemy) {
		this.enemyType = enemy;
	}

	public void setPlayer(int player) {
		this.playerType = player;
	}

	public void setObstacle(int obstacle) {
		this.obstacleType = obstacle;
	}

	public void setLevel(int level) {
		this.enemyLevel = level;
	}

	public int getSide() { // retrieves data
		return side;
	}

	public int getEnemy() {
		return enemyType;
	}

	public int getPlayer() {
		return playerType;
	}

	public int getObstacle() {
		return obstacleType;
	}

	public int getLevel() {
		return enemyLevel;
	}

	public boolean hasPlayer() {
		if (playerType != 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasEnemy() {
		if (enemyType != '1') {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasObstacle() {
		if (obstacleType != 10) {
			return true;
		} else {
			return false;
		}
	}

	public void setBlock(boolean bType) {
		this.battleBlock = bType;
	}

	public boolean isBattleBlock() {
		if (side == 10) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isMoveable() {
		if (this.hasEnemy() == true || this.hasPlayer() == true || this.hasObstacle() == true) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		String bType = side == 1 ? (playerType != 10 ? Integer.toString(playerType) : "B")
				: (enemyType != '1' ? Character.toString(enemyType) : "B");

		if (obstacleType != 10)
			bType = "6";

		String level = enemyLevel != 10 ? Integer.toString(enemyLevel) : "";

		return String.format("%d%s%s", side, bType, level);
	}
}
