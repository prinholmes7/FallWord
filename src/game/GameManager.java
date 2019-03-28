package game;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import resource.DrawableList;
import resource.HighScore;
import resource.Resource;
import resource.gameException;
import screen.BackGroundRunnable;
import screen.GameFrame;
import screen.GameScreen;
import screen.GameTitle;


public class GameManager {
	
	public GameFrame gameFrame;
	public GameTitle gameTitle;
	public GameScreen gameScreen;
	public GameLogic gameLogic;
	public BackGroundRunnable backGroundRunnable;
	
	public static HighScore highScore;
	
	public String name;
	
	public static JPanel currentScene;
	
	public Thread thread;
	
	static {
		try {
			highScore = new HighScore();
		} catch (gameException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public GameManager() {
		name = "harry";
		
		gameTitle = new GameTitle();
		gameScreen = new GameScreen();
		gameFrame = new GameFrame();
		backGroundRunnable = new BackGroundRunnable();
		
		gameFrame.setVisible(true);
	}
	
	public void runGame() {
		gameFrame.add(backGroundRunnable);
		gameFrame.applySetting();
		startThread();
		Resource.titleThemeSong.loop();
		while (thread.isAlive()) {
			;
		}
		gameFrame.remove(backGroundRunnable);
		gameTitle = new GameTitle();
		gameScreen = new GameScreen();
		gameLogic = new GameLogic(name);
		gameFrame.add(gameTitle);
		currentScene = gameTitle;
		gameFrame.applySetting();
	}
	
	public void switchScene() {
		if (currentScene ==  gameTitle) {
			Resource.titleThemeSong.stop();
			gameFrame.remove(gameTitle);
			gameFrame.add(gameScreen);
			
			DrawableList.getInstance().getDrawableList().clear();
			gameLogic = new GameLogic(name);
			gameScreen.requestFocus();
			
			gameFrame.applySetting();
			currentScene = gameScreen;
			Resource.gameScreenThemeSong.loop();
		}
		else {
			gameFrame.remove(gameScreen);
			runGame();
			currentScene = gameTitle;
		}
	}
	
	public JPanel getCurrentScene() {
		return currentScene;
	}
	
	public void startThread() {
		thread = new Thread(backGroundRunnable);
		thread.start();
	}
	
}
