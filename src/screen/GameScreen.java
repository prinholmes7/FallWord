package screen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import game.Main;
import game.Word;
import resource.Drawable;
import resource.DrawableList;
import resource.GameSetting;
import resource.HighScore;
import resource.Resource;

public class GameScreen extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int width = 0;
	public int height = 0;
	
	public GameScreen() {
		setPreferredSize(new Dimension(GameSetting.screenWidth, GameSetting.screenHeight));
		setDoubleBuffered(true);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Main.gameManager.gameLogic.getPlayerStatus().setPause(!Main.gameManager.gameLogic.getPlayerStatus().isPause());
					return;
				}
				
				if (!Main.gameManager.gameLogic.getPlayerStatus().isPause() && !Main.gameManager.gameLogic.getPlayerStatus().isGameOver()) {
					for (Word word : Main.gameManager.gameLogic.getWords()) {
						word.checkWord(e);
					}
					
					if (e.getKeyCode() == KeyEvent.VK_SPACE)
						Main.gameManager.gameLogic.getPlayerStatus().useSkill();
				}
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				synchronized (this) {
					Word.setClicked(true);
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.gameScreenBackGround, 0, 0, GameSetting.screenWidth, GameSetting.screenHeight, null);
		
		for (Drawable drawable : DrawableList.getInstance().getDrawableList()) {
			if (drawable instanceof Word) {
				if (((Word) drawable).isVisible())
					drawable.draw(g2d);
				else {
					DrawableList.getInstance().getDrawableList().remove(drawable);
					Main.gameManager.gameLogic.getWords().remove(drawable);
				}
			}
		}
		
		DrawableList.getInstance().getDrawableList().get(0).draw(g2d);
		
		if (Main.gameManager.gameLogic.getPlayerStatus().isGameOver()) {
			if (width == 0 && height == 0)
				g2d.drawImage(Resource.gameOverImage, 0, 0, GameSetting.screenWidth, GameSetting.screenHeight - 50, null);

			if (HighScore.isHighScore(Main.gameManager.gameLogic.getPlayerStatus().getScore())) {
				g2d.drawImage(Resource.fireworkImage, GameSetting.screenWidth / 2 - width, GameSetting.screenHeight / 2 - height, width * 2, height * 2, null);
				
				if (Word.isClicked()) {
					if (width < GameSetting.screenWidth / 3)
						width += (GameSetting.screenWidth / 3) / 100;
					if (height < GameSetting.screenHeight / 2)
						height += (GameSetting.screenHeight / 2) / 100;
				}
			}
		}
		else
			if (Main.gameManager.gameLogic.getPlayerStatus().isPause())
				g2d.drawImage(Resource.pauseImage, 0, 0, GameSetting.screenWidth, GameSetting.screenHeight, null);
	}
	
	public void applySetting() {
		setPreferredSize(new Dimension(GameSetting.screenWidth, GameSetting.screenHeight));
		revalidate();
	}
	
}
