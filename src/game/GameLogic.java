package game;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import resource.DrawableList;
import resource.Resource;

public class GameLogic {
	
	private PlayerStatus playerStatus;
	private List<Word> words;
	
	private int spawnDelay;
	private int spawnDelayCounter;
	
	public GameLogic(String name) {
		playerStatus = new PlayerStatus(name);
		words = new CopyOnWriteArrayList<Word>();
		spawnDelay = 150;
		spawnDelayCounter = 0;
		
		DrawableList.getInstance().addDrawableList(playerStatus);
	}
	
	public void update() {
		if (!playerStatus.isGameOver()) {
			for (Word word : words) {
				word.update();
			}
			
			if (spawnDelayCounter < spawnDelay) {
				spawnDelayCounter++;
			}
			else {
				spawnDelayCounter = 0;
				if (DrawableList.getInstance().getDrawableList().size() < 16) {
					Word word = new Word(Resource.getRandomWord());
					DrawableList.getInstance().addDrawableList(word);
					words.add(word);
				}
			}
			
			playerStatus.update();
		}
		
		if (spawnDelay < 20)
			setSpawnDelay(20);
	}
	
	public PlayerStatus getPlayerStatus() {
		return playerStatus;
	}
	
	public void newPlayerStatus(String name) {
		DrawableList.getInstance().getDrawableList().remove(playerStatus);
		playerStatus = new PlayerStatus(name);
		Main.gameManager.name = name;
		DrawableList.getInstance().addDrawableList(playerStatus);
	}
	
	public List<Word> getWords() {
		return words;
	}
	
	public int getSpawnDelay() {
		return spawnDelay;
	}
	
	public void setSpawnDelay(int spawnDelay) {
		this.spawnDelay = spawnDelay;
	}
	
	public int getSpawnDelayCounter() {
		return spawnDelayCounter;
	}
	
	public void setSpawnDelayCounter(int spawnDelayCounter) {
		this.spawnDelayCounter = spawnDelayCounter;
	}
	
}
