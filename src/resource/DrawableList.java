package resource;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DrawableList {
	
	private static final DrawableList instance = new DrawableList();
	private List<Drawable> entities = new CopyOnWriteArrayList<Drawable>();
	
	public DrawableList() {
		
	}
	
	public static DrawableList getInstance() {
		return instance;
	}
	
	public List<Drawable> getDrawableList() {
		return entities;
	}
	
	public void addDrawableList(Drawable object) {
		entities.add(object);
	}
	
}
