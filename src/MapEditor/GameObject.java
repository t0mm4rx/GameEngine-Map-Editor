package MapEditor;

public class GameObject {

	public String name;
	public String filename;
	public float x, y;
	public boolean selected;
	
	public GameObject(String name, float x, float y) {
		this.name = name;
		this.x = x;
		this.y = y;
		selected = false;
	}

	
}
