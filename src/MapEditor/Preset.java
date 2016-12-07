package MapEditor;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Preset {

	public String name;
	public Image image;
	public String imgSrc, imgExt;
	public boolean hasImage;
	public ArrayList<Component> comps;
	
	public Preset(String name, String fileName) {
		this.name = name;
		imgSrc = fileName;
		imgExt = imgSrc.split("\\.")[imgSrc.split("\\.").length - 1];
		if (fileName != "images/none.png") {
			try {
				this.image = ImageIO.read(new File(fileName));
				hasImage = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			hasImage = false;
		}
		comps = new ArrayList<Component>();
	}
	
	public void addComponent(Component comp) {
		comps.add(comp);
	}

	public void removeComponent(String name) {
		Component compToDelete = null;
		for (Component comp : comps) {
			if (comp.name.equals(name)) {
				compToDelete = comp;
			}
		}
		comps.remove(compToDelete);
	}
	
	public Component getComponent(int type) {
		
		for (Component comp : comps) {
			if (comp.type == type) {
				return comp;
			}
		}
		
		return null;
	}
	
}
