package MapEditor;

import java.util.ArrayList;

import UI.MapFrame;
import UI.PresetsManager;

public class MapEditor {

	public static MapFrame mapFrame;
	public static PresetsManager presetsManager;
	public static ArrayList<Preset> presets;
	public static ArrayList<GameObject> gameObjects;
	public static String selectedPresetName;
	
	public static void main(String[] args) {
		presets = new ArrayList<Preset>();
		gameObjects = new ArrayList<GameObject>();
		addPreset(new Preset("Wall", "images/wall.jpeg"));
		addPreset(new Preset("Tree", "images/wall.jpeg"));
		addPreset(new Preset("Door", "images/wall.jpeg"));
		addGameObject("Wall", 0f, 0f);
		addGameObject("Wall", 0f, 64f);
		addGameObject("Wall", 0f, 128f);
		selectedPresetName = "Wall";
		mapFrame = new MapFrame();
		presetsManager = new PresetsManager();
	}
	
	public static void addPreset(Preset g) {
		presets.add(g);
	}
	
	public static void removePreset(String name) {
		Preset p = null;
		for (Preset a : presets) {
			if (a.name.equals(name)) {
				p = a;
			}
		}
		presets.remove(p);
	}
	
	public static void addGameObject(String name, float x, float y) {
		gameObjects.add(new GameObject(name, x, y));
	}
	
	public static Preset getPreset(String name) {
		for (Preset preset : presets) {
			if (preset.name.equals(name)) {
				return preset;
			}
		}
		return null;
	}

}
