package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class OFFMeshWriter implements MeshWriter{

	@Override
	public void write(String filename, HashSet<Polygon> polygons) {
		try {
			FileWriter output = new FileWriter(filename);
			ArrayList<String> all = new ArrayList<>();
			int index = 0;
			ArrayList<Vertex> vertices = new ArrayList<>();
			for(Polygon p: polygons) {
				  for (Vertex v: p.vertices) {
				     if (!vertices.contains(v)) {
				    	 all.add(v.toString() + "\n");
				    	 vertices.add(v); 
				    	 index++;
				     }
				  }
				}

			int counter = 0;
			// For Polygon Lines
			output.write("OFF\n");
			String store;
			ArrayList<String> lst = new ArrayList<>();
			for(Polygon p: polygons) {
			  // Start writing the face line here

			    for (Vertex v: p.vertices) {
			    	lst.add(Integer.toString(vertices.indexOf(v)));
			    
			    // append index to the face line 
		    	}
		    	counter++;
		    	all.add(Integer.toString(lst.size()));
		    	
		    	for (int k = 0; k<lst.size();k++) {
		    		all.add(" "+lst.get(k));
		    	}
			    all.add("\n");
			    lst.clear();
			}
			output.write(Integer.toString(index) + " " + Integer.toString(counter) + " 0\n");
			for (int i= 0; i<all.size(); i++) {
				output.write(all.get(i));
			}
			
			output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
