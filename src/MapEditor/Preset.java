package MapEditor;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Preset {

	public String name;
	public Image image;
	
	public Preset(String name, String fileName) {
		this.name = name;
		try {
			this.image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
