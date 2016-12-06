package MapEditor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MapExporter {

	public static void export() {
		String name = JOptionPane.showInputDialog(MapEditor.mapFrame, "Enter the name of your map : ");
		if (name == "") {
			return;
		}
		name = name.toLowerCase();
		name = name.replaceAll(" ", "-");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.showOpenDialog(MapEditor.mapFrame);
		
		//Create the map folder
		String location = fileChooser.getSelectedFile().getAbsolutePath() + "/";
		new File(location + name + "/images").mkdirs();
		
		//Copying all the images in the subfolder 'images'
		for (GameObject g : MapEditor.gameObjects) {
			if (MapEditor.getPreset(g.name).hasImage) {
				Util.copyFile(MapEditor.getPreset(g.name).imgSrc, location + name + "/images/" + g.name + "." + MapEditor.getPreset(g.name).imgExt);
			}
		}
		
		//Creating the .map file
		try{
		    PrintWriter writer = new PrintWriter(location + name + "/" + name + ".map", "UTF-8");
		    for (GameObject go : MapEditor.gameObjects) {
		    	writer.println(gameObjectToString(go, name));
		    }
		    writer.close();
		} catch (IOException e) {}
		
		JOptionPane.showMessageDialog(MapEditor.mapFrame, "Map files generated successfully !");
	}
	
	private static String gameObjectToString(GameObject go, String name) {
		String line = "";
		line += "tag:" + go.name + ",x:" + go.x + ",y:" + go.y + ",components:";
		
		if (MapEditor.getPreset(go.name).hasImage) {
			line += "type=SpriteRenderer-image=" + name + "/images/" + go.name + "." + MapEditor.getPreset(go.name).imgExt;
		}
		
		return line;
	}
	
}
