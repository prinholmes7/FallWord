package game;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import resource.Drawable;
import resource.GameSetting;
import resource.HighScore;
import resource.Resource;


public class Word extends JComponent implements Drawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int x;
	protected int y;
	protected String word;
	protected int width;
	protected int height;
	protected int speed;
	protected boolean destroyed;
	protected int count;
	
	protected static boolean clicked = false;
	
	public Word(String word) {
		this.word = word;
		FontMetrics fontMetrics = getFontMetrics(Resource.wordFont);
		width = fontMetrics.stringWidth(word) / 2;
		height = 70;
		x = (int) (Math.random() * (GameSetting.screenWidth - width * 3 - 150 + 1) + 150);
		y = - height * 2;
		
		if (word.length() > 7)
			speed = (int) (Math.random() * 1 + 1);
		else if (word.length() > 5)
			speed = (int) (Math.random() * 2 + 1);
		else
			speed = (int) (Math.random() * 4 + 1);
		
		destroyed = false;
		count = 0;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.wordImage, x, y, width * 3, height * 2, null);
		
		g2d.setFont(Resource.wordFont);
		g2d.setColor(Color.BLACK);
		g2d.drawString(word, x + width / 2, y + height - 7);
		g2d.setColor(Color.ORANGE);
		g2d.drawString(word.substring(0, count), x + width / 2, y + height - 7);
	}

	public boolean isDestroyed() {
		return destroyed;
	}
	
	public void setDestroyed(boolean isDestroyed) {
		destroyed = isDestroyed;
		if (destroyed) {
			count = word.length();
			Main.gameManager.gameLogic.getPlayerStatus().addScore(1);
			Main.gameManager.gameLogic.setSpawnDelay(Main.gameManager.gameLogic.getSpawnDelay() - 3);
			speed = -5;
		}
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public static boolean isClicked() {
		return clicked;
	}
	
	public static void setClicked(boolean isClicked) {
		clicked = isClicked;
	}
	
	public void update() {
		y += speed;
		if (y >= GameSetting.screenHeight || y < - height * 2)
			setVisible(false);
		if (!isVisible() && !isDestroyed()) {
			Main.gameManager.gameLogic.getPlayerStatus().setGameOver(true);
			
			setClicked(false);
			while (!isClicked())
				Main.gameManager.gameFrame.repaint();
			
			if (HighScore.isHighScore(Main.gameManager.gameLogic.getPlayerStatus().getScore())) {
				while (Main.gameManager.gameScreen.width != 400 && Main.gameManager.gameScreen.height != 300) {
					Main.gameManager.gameFrame.repaint();
				}

				setClicked(false);
				while (!isClicked())
					Main.gameManager.gameFrame.repaint();
				
				HighScore.setHighScore(Main.gameManager.gameLogic.getPlayerStatus().getScore());
			}
			
			Resource.gameScreenThemeSong.stop();
			Main.gameManager.switchScene();
		}
	}
	
	public void checkWord(KeyEvent e) {
		if (!isDestroyed()) {
			if (e.getKeyChar() == word.charAt(count)) {
				count++;
				Main.gameManager.gameLogic.getPlayerStatus().setDestination(x);
			}
			else
				count = 0;
			if (count >= word.length()) {
				setDestroyed(true);
				Resource.killSound.play();
				Main.gameManager.gameLogic.getPlayerStatus().updateCanSkill();
			}
		}
	}
	
}
