package screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.Main;
import resource.GameSetting;
import resource.HighScore;
import resource.Resource;

public class GameTitle extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel startPanel;
	private JPanel optionPanel;
	private JButton startButton;
	private JButton settingButton;
	private JButton highScoreButton;
	
	private ActionListener voldemortListener;
	private ActionListener hermioneListener;
	private ActionListener harryListener;
	private ActionListener ronListener;
	private ActionListener dumbledoreListener;
	
	private ActionListener startListener;
	private ActionListener settingListener;
	private ActionListener highScoreListener;
	
	private MouseListener ml;
	
	public boolean showingHighScore = false;
	public int widthHighScore = 0;
	public int heightHighScore = 0;
	
	public GameTitle() {
		setPreferredSize(new Dimension(GameSetting.screenWidth, GameSetting.screenHeight));
		setLayout(new BorderLayout());
		setDoubleBuffered(true);
				
		startPanel = new JPanel();
		startPanel.setLayout(new BorderLayout());
		
		startButton = new JButton();
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startPanel.add(startButton);
		
		optionPanel = new JPanel();
		optionPanel.setLayout(new BorderLayout());
		optionPanel.setPreferredSize(new Dimension(GameSetting.screenWidth, 220));
		
		settingButton = new JButton(new ImageIcon(Resource.settingImage));
		highScoreButton = new JButton(new ImageIcon(Resource.highScoreImage));
		
		settingButton.setBackground(new Color(255, 255, 255, 0));
		highScoreButton.setBackground(new Color(255, 255, 255, 0));
		
		settingButton.setOpaque(false);
		highScoreButton.setOpaque(false);
		settingButton.setContentAreaFilled(false);
		highScoreButton.setContentAreaFilled(false);
		settingButton.setBorderPainted(false);
		highScoreButton.setBorderPainted(false);
		
		JPanel optionPanelWest = new JPanel();
		JPanel optionPanelCenter = new JPanel();
		JPanel optionPanelEast = new JPanel();
		
		optionPanelWest.setLayout(new BorderLayout());
		optionPanelCenter.setLayout(new GridLayout(1, 5));
		optionPanelEast.setLayout(new BorderLayout());
		
		optionPanelWest.add(settingButton, BorderLayout.SOUTH);
		optionPanelEast.add(highScoreButton, BorderLayout.SOUTH);
		
		optionPanel.add(optionPanelWest, BorderLayout.WEST);
		optionPanel.add(optionPanelCenter, BorderLayout.CENTER);
		optionPanel.add(optionPanelEast, BorderLayout.EAST);
		
		
		JButton voldemortButton = new JButton();
		JButton hermioneButton = new JButton();
		JButton harryButton = new JButton();
		JButton ronButton = new JButton();
		JButton dumbledoreButton = new JButton();
		
		voldemortButton.setOpaque(false);
		voldemortButton.setContentAreaFilled(false);
		voldemortButton.setBorderPainted(false);
		optionPanelCenter.add(voldemortButton);
		
		hermioneButton.setOpaque(false);
		hermioneButton.setContentAreaFilled(false);
		hermioneButton.setBorderPainted(false);
		optionPanelCenter.add(hermioneButton);
		
		harryButton.setOpaque(false);
		harryButton.setContentAreaFilled(false);
		harryButton.setBorderPainted(false);
		optionPanelCenter.add(harryButton);
		
		ronButton.setOpaque(false);
		ronButton.setContentAreaFilled(false);
		ronButton.setBorderPainted(false);
		optionPanelCenter.add(ronButton);
		
		dumbledoreButton.setOpaque(false);
		dumbledoreButton.setContentAreaFilled(false);
		dumbledoreButton.setBorderPainted(false);
		optionPanelCenter.add(dumbledoreButton);
		
		voldemortListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gameManager.gameLogic.newPlayerStatus("voldemort");
			}
		};
		voldemortButton.addActionListener(voldemortListener);
		
		hermioneListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gameManager.gameLogic.newPlayerStatus("hermione");
			}
		};
		hermioneButton.addActionListener(hermioneListener);
		
		harryListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gameManager.gameLogic.newPlayerStatus("harry");
			}
		};
		harryButton.addActionListener(harryListener);
		
		ronListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gameManager.gameLogic.newPlayerStatus("ron");
			}
		};
		ronButton.addActionListener(ronListener);
		
		dumbledoreListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gameManager.gameLogic.newPlayerStatus("dumbledore");
			}
		};
		dumbledoreButton.addActionListener(dumbledoreListener);
		
		startPanel.setBackground(new Color(255, 255, 255, 0));
		optionPanel.setBackground(new Color(255, 255, 255, 0));
		optionPanelWest.setBackground(new Color(255, 255, 255, 0));
		optionPanelCenter.setBackground(new Color(255, 255, 255, 0));
		optionPanelEast.setBackground(new Color(255, 255, 255, 0));
		
		startButton.setBackground(new Color(255, 255, 255, 0));
		settingButton.setBackground(new Color(255, 255, 255, 0));
		highScoreButton.setBackground(new Color(255, 255, 255, 0));
		voldemortButton.setBackground(new Color(255, 255, 255, 0));
		hermioneButton.setBackground(new Color(255, 255, 255, 0));
		harryButton.setBackground(new Color(255, 255, 255, 0));
		ronButton.setBackground(new Color(255, 255, 255, 0));
		dumbledoreButton.setBackground(new Color(255, 255, 255, 0));
		
		add(startPanel, BorderLayout.CENTER);
		add(optionPanel, BorderLayout.SOUTH);
		
		startListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gameManager.switchScene();
			}
		};
		startButton.addActionListener(startListener);
		
		settingListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame settingFrame = new JFrame("Setting");
				settingFrame.setResizable(false);
				
				JPanel settingPanel = new JPanel();
				settingPanel.setLayout(new FlowLayout());
				settingPanel.setBackground(new Color(28, 72, 99));
				
				((FlowLayout) settingPanel.getLayout()).setHgap(20);
				((FlowLayout) settingPanel.getLayout()).setVgap(10);
				
				JTextField widthTextField = new JTextField("WIDTH", SwingConstants.CENTER);
				JTextField heightTextField = new JTextField("HEIGHT", SwingConstants.CENTER);
				widthTextField.setPreferredSize(new Dimension(100, 30));
				heightTextField.setPreferredSize(new Dimension(100, 30));
				
				settingPanel.add(widthTextField);
				settingPanel.add(heightTextField);
				
				JButton applyButton = new JButton("Apply");
				applyButton.setOpaque(false);
				applyButton.setContentAreaFilled(false);
				applyButton.setBorderPainted(false);
				applyButton.setForeground(new Color(248, 205, 15));
				applyButton.setFont(Resource.standardFont);
				
				applyButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int width;
						int height;
						try {
							width = Integer.parseInt(widthTextField.getText());
							height = Integer.parseInt(heightTextField.getText());
						} catch (Exception e2) {
							String message = "Wrong format!\nEnter width & height again. (Integer)";
							JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						if (width < 800 || height < 600) {
							String message = "Size's too small\nEnter width & height again. (Minimum: 800 * 600)";
							JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						GameSetting.setScreenWidth(width);
						GameSetting.setScreenHeight(height);
						
						applySetting();
						
						String message = "Setting success!";
						JOptionPane.showMessageDialog(null, message, null, JOptionPane.INFORMATION_MESSAGE);						
						
						settingFrame.dispose();
					}
				});
				
				settingPanel.add(applyButton);
				
				settingFrame.add(settingPanel);
				settingFrame.pack();
				settingFrame.setVisible(true);
			}
		};
		settingButton.addActionListener(settingListener);
		
		highScoreListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showingHighScore = true;
				
				startButton.removeActionListener(startListener);
				settingButton.removeActionListener(settingListener);
				highScoreButton.removeActionListener(highScoreListener);
				
				voldemortButton.removeActionListener(voldemortListener);
				hermioneButton.removeActionListener(hermioneListener);
				harryButton.removeActionListener(harryListener);
				ronButton.removeActionListener(ronListener);
				dumbledoreButton.removeActionListener(dumbledoreListener);
				
				addMouseListener(ml);
				
				startButton.addMouseListener(ml);
				settingButton.addMouseListener(ml);
				highScoreButton.addMouseListener(ml);
				
				voldemortButton.addMouseListener(ml);
				hermioneButton.addMouseListener(ml);
				harryButton.addMouseListener(ml);
				ronButton.addMouseListener(ml);
				dumbledoreButton.addMouseListener(ml);
			}
		};
		highScoreButton.addActionListener(highScoreListener);
		
		ml = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				removeMouseListener(ml);
				
				startButton.removeMouseListener(ml);
				settingButton.removeMouseListener(ml);
				highScoreButton.removeMouseListener(ml);
				
				voldemortButton.removeMouseListener(ml);
				hermioneButton.removeMouseListener(ml);
				harryButton.removeMouseListener(ml);
				ronButton.removeMouseListener(ml);
				dumbledoreButton.removeMouseListener(ml);
				
				startButton.addActionListener(startListener);
				settingButton.addActionListener(settingListener);
				highScoreButton.addActionListener(highScoreListener);
				
				voldemortButton.addActionListener(voldemortListener);
				hermioneButton.addActionListener(hermioneListener);
				harryButton.addActionListener(harryListener);
				ronButton.addActionListener(ronListener);
				dumbledoreButton.addActionListener(dumbledoreListener);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				showingHighScore = false;
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
				
			}
		};
	}
	
	public void applySetting() {
		setPreferredSize(new Dimension(GameSetting.screenWidth, GameSetting.screenHeight));
		revalidate();
		
		Main.gameManager.gameScreen.applySetting();
		Main.gameManager.backGroundRunnable.applySetting();
		Main.gameManager.gameFrame.applySetting();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.gameTitleBackGround, - widthHighScore * 3, - heightHighScore * 3, GameSetting.screenWidth + widthHighScore * 6, GameSetting.screenHeight + heightHighScore * 6, null);

		
		g2d.drawImage(Resource.highScoreRecordImage, GameSetting.screenWidth / 2 - widthHighScore + widthHighScore / 10, GameSetting.screenHeight / 2 - heightHighScore, widthHighScore * 2, heightHighScore * 2, null);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font(Resource.harryFont.getFontName(), Font.BOLD, heightHighScore / 5));
		g2d.drawString(Integer.toString(HighScore.getHighScore()), GameSetting.screenWidth / 2 - getFontMetrics(Resource.harryFont).stringWidth(Integer.toString(HighScore.getHighScore())) / 2, GameSetting.screenHeight / 2);
		
		if (!showingHighScore) {
			if (widthHighScore != 0)
				widthHighScore -= (GameSetting.screenWidth / 2) / 100;
			if (heightHighScore != 0)
				heightHighScore -= (GameSetting.screenHeight / 2) / 100;
			if (widthHighScore == 0 && heightHighScore == 0) {
				g2d.setColor(new Color(255, 215, 0));
				g2d.setFont(new Font(Resource.harryFont.getFontName(), Font.BOLD + Font.ITALIC, 100));
				g2d.drawString("Click to Start", GameSetting.screenWidth / 2 - getFontMetrics(Resource.harryFont).stringWidth("Click to Start") * 2, GameSetting.screenHeight / 2 - getFontMetrics(Resource.harryFont).getHeight() / 2);
			}
		}
		else {
			if (widthHighScore < GameSetting.screenWidth / 2)
				widthHighScore += (GameSetting.screenWidth / 2) /100;
			if (heightHighScore < GameSetting.screenHeight / 2)
				heightHighScore += (GameSetting.screenHeight / 2) / 100;
		}
	}
	
}
