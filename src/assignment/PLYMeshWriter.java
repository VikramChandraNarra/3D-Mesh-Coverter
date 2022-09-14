package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class PLYMeshWriter implements MeshWriter{

	@Override
	public void write(String filename, HashSet<Polygon> polygons) {
		try {
			FileWriter output = new FileWriter(filename);
//			output.write("ply\n");
			ArrayList<String> all = new ArrayList<>();
			int index = 0;
//			BufferedWriter output = new BufferedWriter(new FileWriter(filename));
			ArrayList<Vertex> vertices = new ArrayList<>();
			for(Polygon p: polygons) {
				  for (Vertex v: p.vertices) {
				     if (!vertices.contains(v)) {
				       // write to file here
				    	 all.add(v.toString() + "\n");
//				    	 output.write(v.toString() + "\n");
				    	 vertices.add(v); 
				    	 index++;
				     }
				  }
				}

				int counter = 0;
				// For Polygon Lines
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
				output.write("ply\nformat ascii 1.0\nelement vertex " + Integer.toString(index));
				output.write("\nproperty float32 x\nproperty float32 y\nproperty float32 z\nelement face " + Integer.toString(counter));
				output.write("\nproperty list uint8 int32 vertex_indices\nend_header\n");
				for (int i= 0; i<all.size(); i++) {
					output.write(all.get(i));
				}
				
				output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
