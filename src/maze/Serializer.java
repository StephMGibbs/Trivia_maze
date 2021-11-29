package maze;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer implements Serializable {
	
	
	private static final long serialVersionUID = -7982846020544436819L;
	
	static String filename = "Maze.ser";
	
	public static void serialize(Maze object) {
		
        try {
        	FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			output.writeObject(object);
			
			output.close();
			file.close();
			
			
			System.out.println("\nYour progress has been saved!");
			
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("File could not be found.");
		}
		
	}
	
	public static Maze deserialize() {
		
		Maze restoration = null;
		
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream input = new ObjectInputStream(file);
			
			restoration = (Maze) input.readObject();
			
			input.close();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File could not be found.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return restoration;
		
	}
}
