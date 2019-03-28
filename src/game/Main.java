package game;

import java.io.IOException;


public class Main {
	
	public static GameManager gameManager;
	
	public static void main(String[] args) throws IOException {
		gameManager = new GameManager();
		gameManager.runGame();
		
		while (true) {
			gameManager.gameFrame.repaint();
			
			if (gameManager.getCurrentScene() == gameManager.gameScreen) {
				if (!gameManager.gameLogic.getPlayerStatus().isPause()) {
					gameManager.gameLogic.update();
				}
				
				try {
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

}
