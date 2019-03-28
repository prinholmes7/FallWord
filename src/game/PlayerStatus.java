package game;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import resource.Drawable;
import resource.DrawableList;
import resource.GameSetting;
import resource.Resource;


public class PlayerStatus extends JComponent implements Drawable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int score;
	private static boolean gameOver;
	
	private int skill;
	private boolean canSkill;
	
	private int widthSkill;
	private int heightSkill;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private int destination;
	
	public boolean pause;
	
	public PlayerStatus(String name) {
		score = 0;
		gameOver = false;
		skill = 0;
		canSkill = false;
		widthSkill = GameSetting.screenWidth;
		heightSkill = GameSetting.screenHeight;
		width = GameSetting.screenWidth / 10;
		height = GameSetting.screenHeight / 4;
		x = GameSetting.screenWidth / 2 - width;
		y = GameSetting.screenHeight - height;
		destination = x + width / 2;
		pause = false;
		
		Resource.getCharacterImage(name);
		Resource.getSpecialWandImage(name);
		Resource.getSelectedImage(name);
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		PlayerStatus.score += score;
	}
	
	public boolean canUseSkill() {
		return canSkill;
	}
	
	public void setCanSkill(boolean canUseSkill) {
		canSkill = canUseSkill;
	}
	
	public void updateCanSkill() {
		skill += 1;
		if (skill >= 15) {
			setCanSkill(true);
		}
	}
	
	public void useSkill() {
		if (canUseSkill()) {
			Resource.skillSound.play();
				
			skill = 0;
			setCanSkill(false);
			
			for (Drawable drawable : DrawableList.getInstance().getDrawableList()) {
				if (drawable instanceof Word) {
					((Word) drawable).setDestroyed(true);
				}
			}
			
			widthSkill = 0;
			heightSkill = 0;
		}
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean isGameOver) {
		gameOver = isGameOver;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.scoreFrameImage, -20, GameSetting.screenHeight - 130, 150, 150, null);
		
		g2d.setFont(Resource.harryFont);
		g2d.setColor(Color.CYAN);
		g2d.drawString(Integer.toString(score), 57 - getFontMetrics(Resource.harryFont).stringWidth(Integer.toString(score)) / 2, GameSetting.screenHeight - 70);
		
		g2d.drawImage(Resource.characterImage, x, y, width, height, null);
		
		if (canUseSkill()) {
			g2d.drawImage(Resource.specialWandImage, GameSetting.screenWidth - 100, GameSetting.screenHeight - 150, 100, 150, null);
		}
		else {
			g2d.drawImage(Resource.wandImage, GameSetting.screenWidth - 100, GameSetting.screenHeight - 150, 100, 150, null);
		}
		
		if (widthSkill < GameSetting.screenWidth || heightSkill < GameSetting.screenHeight) {
			g2d.drawImage(Resource.auraImage, GameSetting.screenWidth / 2 - widthSkill, GameSetting.screenHeight / 2 - widthSkill, widthSkill * 2, heightSkill * 2, null);
			widthSkill += 10;
			heightSkill += 10;
			Main.gameManager.gameLogic.setSpawnDelayCounter(0);
			Main.gameManager.gameLogic.setSpawnDelay(100);
		}
	}
	
	public int getDestination() {
		return destination;
	}
	
	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	public void update() {
			x += (destination - x - width / 2) / 30;
	}
	
	public boolean isPause() {
		return pause;
	}
	
	public void setPause(boolean isPause) {
		pause = isPause;
	}
	
}
