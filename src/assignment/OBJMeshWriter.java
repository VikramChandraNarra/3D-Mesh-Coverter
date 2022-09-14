package assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class OBJMeshWriter implements MeshWriter{


	@Override
	public void write(String filename, HashSet<Polygon> polygons) {
		try {
			FileWriter output = new FileWriter(filename);
			
//			BufferedWriter output = new BufferedWriter(new FileWriter(filename));
			ArrayList<Vertex> vertices = new ArrayList<>();
			for(Polygon p: polygons) {
				  for (Vertex v: p.vertices) {
				     if (!vertices.contains(v)) {
				       // write to file here
//				    	 System.out.println("v " + v.toString() + "\n");
				    	 output.write("v " + v.toString() + "\n");
				    	 vertices.add(v); 
				     }
				  }
				}

				// For Polygon Lines
				for(Polygon p: polygons) {
				  // Start writing the face line here
					output.write("f");
				    for (Vertex v: p.vertices) {
				    	output.write(" "+ Integer.toString(vertices.indexOf(v) + 1) );
				    	
				    
				    // append index to the face line 
			    	}
				    output.write("\n");
				}
				output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}
}
