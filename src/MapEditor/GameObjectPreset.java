package MapEditor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObjectPreset {

	public String name;
	public Image image;
	
	public GameObjectPreset(String name, String fileName) {
		this.name = name;
		try {
			this.image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
