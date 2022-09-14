package assignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Mesh extends GraphicalObject{
	HashSet<Polygon> polygons;
	MeshReader reader;
	MeshWriter writer;
	
	public void setReader(MeshReader a) {
		reader = a;
	}
	
	public void setWriter(MeshWriter a) {
		writer = a;
	}
	public void readFromFile(String filename) throws WrongFileFormatException {

		polygons = reader.read(filename);

		

				
		//Implement Later 
	}
	public void writeToFile(String filename) {
		writer.write(filename, polygons);

		//Use Writer
	}

	@Override
	public void transform(double[][] matrix) {
		for (Polygon poly : polygons) {
			poly.transform(matrix);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(polygons);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesh other = (Mesh) obj;
		return Objects.equals(polygons, other.polygons);
	}


}