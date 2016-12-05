package MapEditor;

import java.util.ArrayList;

import UI.Frame;

public class MapEditor {

	public static Frame frame;
	public static ArrayList<GameObjectPreset> gameObjectsPresets;
	public static ArrayList<GameObject> gameObjects;
	
	public static void main(String[] args) {
		gameObjectsPresets = new ArrayList<GameObjectPreset>();
		gameObjects = new ArrayList<GameObject>();
		addGameObjectPreset(new GameObjectPreset("Wall", "images/wall.jpeg"));
		addGameObjectPreset(new GameObjectPreset("Tree", "images/wall.jpeg"));
		addGameObjectPreset(new GameObjectPreset("Door", "images/wall.jpeg"));
		addGameObject("Wall", 0f, 0f);
		addGameObject("Wall", 0f, 64f);
		addGameObject("Wall", 0f, 128f);
		frame = new Frame();
	}
	
	public static void addGameObjectPreset(GameObjectPreset g) {
		gameObjectsPresets.add(g);
	}
	
	public static void removeGameObjectPreset(GameObjectPreset g) {
		gameObjectsPresets.remove(g);
	}
	
	public static void addGameObject(String name, float x, float y) {
		gameObjects.add(new GameObject(name, x, y));
	}
	
	public static GameObjectPreset getPreset(String name) {
		for (GameObjectPreset preset : gameObjectsPresets) {
			if (preset.name.equals(name)) {
				return preset;
			}
		}
		return null;
	}

}
