package screen;

import game.Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import resource.GameSetting;
import resource.Resource;

public class BackGroundRunnable extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int i;
	private int j;
	
	public BackGroundRunnable() {
		setPreferredSize(new Dimension(GameSetting.screenWidth, GameSetting.screenHeight));
		i = 0;
		j = 0;
	}
	
	public void applySetting() {
		setPreferredSize(new Dimension(GameSetting.screenWidth, GameSetting.screenHeight));
		revalidate();
	}
	
	public void run() {
		try {
			while (i < 7) {
				game.Main.gameManager.gameFrame.repaint();
				Thread.sleep(70);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Thread.interrupted();
		}
	}
	
	public void paintComponent(Graphics g) {
		if (Main.gameManager.thread.isAlive()) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(Resource.gameTitleBackGround, 0, 0, GameSetting.screenWidth, GameSetting.screenHeight, null);
			Resource.getNextGameTitleBackGround(i, j);
			j++;
			if (j > 6) {
				i++;
				j = 0;
			}
		}
	}
	
}
