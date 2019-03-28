package resource;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

public class Resource {
	
	public static final Font standardFont = new Font("Tahoma", Font.PLAIN, 20);
	public static final Font wordFont = new Font("Tahoma", Font.BOLD, 20);
	public static Font harryFont;
	
	//GameTitle
	public static BufferedImage gameTitleBackGround;
	public static BufferedImage settingImage;
	public static BufferedImage highScoreImage;
	public static BufferedImage highScoreRecordImage;
	public static AudioClip titleThemeSong;
	
	//GameScreen
	public static BufferedImage gameScreenBackGround;
	public static BufferedImage characterImage;
	public static BufferedImage wordImage;
	public static BufferedImage scoreFrameImage;
	public static BufferedImage wandImage;
	public static BufferedImage specialWandImage;
	public static BufferedImage auraImage;
	public static BufferedImage gameOverImage;
	public static BufferedImage fireworkImage;
	public static BufferedImage pauseImage;
	public static AudioClip gameScreenThemeSong;
	public static AudioClip killSound;
	public static AudioClip skillSound;
	
	//Word
	public static List<String> words;
	
	static {
		try {
			InputStream file = Resource.class.getClassLoader().getResourceAsStream("res/harryFont.TTF");
			harryFont = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(Font.PLAIN, 30);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(harryFont);
			
			gameTitleBackGround = ImageIO.read(Resource.class.getClassLoader().getResource("res/title/Openning_0.png"));
			settingImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/setting.png"));
			highScoreImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/highScore.png"));
			highScoreRecordImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/highScoreRecord.png"));
			titleThemeSong = Applet.newAudioClip(Resource.class.getClassLoader().getResource("res/titleThemeSong.wav"));
			
			gameScreenBackGround = ImageIO.read(Resource.class.getClassLoader().getResource("res/backGround.png"));
			wordImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/word.png"));
			scoreFrameImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/scoreFrame.png"));
			wandImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/wand.png"));
			auraImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/aura.png"));
			gameOverImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/gameOver.png"));
			fireworkImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/fireWork.png"));
			pauseImage = ImageIO.read(Resource.class.getClassLoader().getResource("res/pause.png"));
			gameScreenThemeSong = Applet.newAudioClip(Resource.class.getClassLoader().getResource("res/gameScreenThemeSong.wav"));
			killSound = Applet.newAudioClip(Resource.class.getClassLoader().getResource("res/spell.wav"));
			skillSound = Applet.newAudioClip(Resource.class.getClassLoader().getResource("res/expectro.wav"));
			
			words = new CopyOnWriteArrayList<String>();
			BufferedReader in = new BufferedReader(new InputStreamReader(Resource.class.getClassLoader().getResourceAsStream("res/words.txt")));
			String word = "";
			while ((word = in.readLine().trim()) != null) {
				words.add(word);
			}
			in.close();
		} catch (Exception e) {
			
		}
	}
	
	public static void getNextGameTitleBackGround(int i, int j) {
		String content = "res/title/Openning_" + i + "-" + j + ".png";
		try {
			gameTitleBackGround = ImageIO.read(Resource.class.getClassLoader().getResource(content));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static String getRandomWord() {
		return words.get((int)(Math.random() * words.size()));
	}
	
	public static void getCharacterImage(String name) {
		try {
			String content = "res/character/" + name + ".png";
			characterImage = ImageIO.read(Resource.class.getClassLoader().getResource(content));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void getSpecialWandImage(String name) {
		try {
			String content = "res/" + name + "Wand.png";
			specialWandImage = ImageIO.read(Resource.class.getClassLoader().getResource(content));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void getSelectedImage(String name) {
		try {
			String content = "res/selected/" + name + "Selected.png";
			gameTitleBackGround = ImageIO.read(Resource.class.getClassLoader().getResource(content));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
