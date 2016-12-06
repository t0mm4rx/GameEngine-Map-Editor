package MapEditor;

public class Component {

	public static final int SPRITE_RENDERER = 1;
	public static final int BOX_RENDERER = 2;
	public static final int BOX_BODY = 3;
	public static final int CIRCLE_BODY = 4;
	public static final int TEXT = 5;
	
	public int type;
	
	//Sprite Renderer
	public String src;
	//General
	public int width, height;
	public String name;
	//Color
	public float r, g, b, a;
	//Text
	public String text, font;
	public int size;
	//CircleBody
	public int radius;
	//Bodies
	public int bodyType;
	
	public Component (String name, String src) {
		this.name = name;
		this.type = SPRITE_RENDERER;
		this.src = src;
	}
	
	public Component(String name, int width, int height, float r, float g, float b, float a) {
		this.name = name;
		this.type = BOX_RENDERER;
		this.width = width;
		this.height = height;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public Component (String name, int width, int height, int bodyType) {
		this.name = name;
		this.type = BOX_BODY;
		this.width = width;
		this.height = height;
	}
	
	public Component(String name, int radius, int bodyType) {
		this.name = name;
		this.type = CIRCLE_BODY;
		this.radius = radius;
		this.bodyType = bodyType;
	}
	
	public Component (String name, String text, String font, int size) {
		this.name = name;
		this.text = text;
		this.font = font;
		this.size = size;
	}
}
