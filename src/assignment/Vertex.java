package assignment;

import java.util.Objects;
import java.lang.Math;
import java.math.BigDecimal;

public class Vertex extends GraphicalObject {
	public double coordinate1;
	public double coordinate2;
	public double coordinate3;
	
	public Vertex(double a, double b, double c) {
		coordinate1 = a;
		coordinate2 = b;
		coordinate3 = c;
	}
	
	
	//Overrides Hashcode and equals
	//Overrides toString by returning a string containing the three cordinates seperated by spaces

	@Override
	public int hashCode() {
		return Objects.hash(coordinate1, coordinate2, coordinate3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return Double.doubleToLongBits(coordinate1) == Double.doubleToLongBits(other.coordinate1)
				&& Double.doubleToLongBits(coordinate2) == Double.doubleToLongBits(other.coordinate2)
				&& Double.doubleToLongBits(coordinate3) == Double.doubleToLongBits(other.coordinate3);
	}
	
	


	@Override
	public String toString() {
//		return  coordinate1 + " " + coordinate2 + " " + coordinate3;

		return  BigDecimal.valueOf(coordinate1).toString() + " " + BigDecimal.valueOf(coordinate2).toString() + " " + BigDecimal.valueOf(coordinate3).toString();
//		return  Double.toString(coordinate1) + " " + Double.toString(coordinate1)  + " " + Double.toString(coordinate1);

	}


	@Override
	public void transform(double[][] matrix) {
		// TODO Auto-generated method stub
		double x, y, z;


		x = (matrix[0][0]*coordinate1) + (matrix[0][1]*coordinate2) + (matrix[0][2]*coordinate3);
		y = (matrix[1][0]*coordinate1) + (matrix[1][1]*coordinate2) + (matrix[1][2]*coordinate3);
		z = (matrix[2][0]*coordinate1) + (matrix[2][1]*coordinate2) + (matrix[2][2]*coordinate3);
		coordinate1 = x;
		coordinate2 = y;
		coordinate3 = z;



	}
	

	

}
