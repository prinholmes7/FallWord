package resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class HighScore {
	
	private static int score = 0;
	
	private static String file = "highscore.txt";
	
	public HighScore() throws gameException {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(Resource.class.getClassLoader().getResourceAsStream(file)));
			score = Integer.parseInt(in.readLine());
			in.close();
		} catch (Exception e) {
			score = 0;
			throw new gameException(0);
		}
	}

	public static boolean isHighScore(int score) {
		return (HighScore.score < score) ? true : false;
	}
	
	public static int getHighScore() {
		return score;
	}
	
	public static void setHighScore(int score) {
		HighScore.score = score;
		
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Resource.class.getClassLoader().getResourceAsStream(file)));
			String record = Integer.toString(score);
			out.write(record);
			out.close();
		} catch (IOException e) {
			String message = "Error!\nCan't record highscore.";
			JOptionPane.showMessageDialog(null, message, "Erorr", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
