package assignment;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Polygon extends GraphicalObject{

	LinkedHashSet<Vertex> vertices;
	
	public Polygon(LinkedHashSet<Vertex> vertices2) {
		vertices = vertices2;
	}

	@Override
	public void transform(double[][] matrix) {
		// TODO Auto-generated method stub
		for (Vertex vertex: vertices) {
			vertex.transform(matrix);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(vertices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		return Objects.equals(vertices, other.vertices);
	}
	
	// Overrides hashcode and equals
	
	
}

