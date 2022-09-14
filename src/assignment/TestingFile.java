package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

class TestingFile {

	@Test
	void checkSigDigs() {
		//Check validity of Sig Digs
		Vertex a = new Vertex(1.0, 2.0, 3.0);
		Vertex b = new Vertex(1.000000, 2.00000, 3.000000);
		assertEquals(a.hashCode(), b.hashCode());
		
	}
	@Test
	void checkPolygonHash() {
		//Check the hash code of Polygons
		Vertex a = new Vertex(1.0, 2.0, 3.0);
		Vertex b = new Vertex(2.0, 3.0, 4.0);
		LinkedHashSet<Vertex> x = new LinkedHashSet<Vertex>();
		x.add(a);
		x.add(b);
		
		LinkedHashSet<Vertex> y = new LinkedHashSet<Vertex>();
		y.add(b);
		y.add(a);

		Polygon i = new Polygon(x);
		Polygon j = new Polygon(y);

		assertEquals(true, i.equals(j));
	}
	
	@Test
	void checkPolygonEqual() {
		//Check the hash code of Polygons
		Vertex a = new Vertex(1.0, 2.0, 3.0);
		Vertex b = new Vertex(2.0, 3.0, 4.0);
		LinkedHashSet<Vertex> x = new LinkedHashSet<Vertex>();
		x.add(a);
		x.add(b);
		
		LinkedHashSet<Vertex> y = new LinkedHashSet<Vertex>();
		y.add(b);
		y.add(a);

		Polygon i = new Polygon(x);
		Polygon j = new Polygon(y);

		assertEquals(true, i.equals(j));
	}
	@Test
	void checkPolygonsEqual() {
		//Check the hash code of Polygons
		Vertex a = new Vertex(1.0, 2.0, 3.0);
		Vertex b = new Vertex(2.0, 3.0, 4.0);
		LinkedHashSet<Vertex> x = new LinkedHashSet<Vertex>();
		x.add(a);
		x.add(b);
		
		LinkedHashSet<Vertex> y = new LinkedHashSet<Vertex>();
		y.add(b);
		y.add(a);

		Polygon i = new Polygon(x);
		Polygon j = new Polygon(y);

		assertEquals(true, i.equals(j));
	}
	@Test
	void checkDifferentPolygons() {
		//Check the hash code of Polygons
		Vertex a = new Vertex(1.0, 2.0, 3.0);
		Vertex b = new Vertex(2.0, 3.0, 4.0);
		LinkedHashSet<Vertex> x = new LinkedHashSet<Vertex>();
		x.add(a);
		
		LinkedHashSet<Vertex> y = new LinkedHashSet<Vertex>();
		y.add(b);
		LinkedHashSet<Vertex> z = new LinkedHashSet<Vertex>();
		z.add(a);

		Polygon k = new Polygon(z);
		Polygon i = new Polygon(x);
		Polygon j = new Polygon(y);

		assertEquals(i.hashCode(), k.hashCode());
	}
	@Test
	void checkSamePolygons() {
		//Check the hash code of Polygons
		Vertex b = new Vertex(2.0, 3.0, 4.0);

		LinkedHashSet<Vertex> y = new LinkedHashSet<Vertex>();
		y.add(b);


		Polygon j = new Polygon(y);

		assertEquals(true, j.equals(j));
	}
	@Test
	void checkEqualsNullPolygons() {
		//Check the hash code of Polygons
		Vertex b = new Vertex(2.0, 3.0, 4.0);

		LinkedHashSet<Vertex> y = new LinkedHashSet<Vertex>();
		y.add(b);

		Polygon j = new Polygon(y);

		assertEquals(false, j.equals(null));
	}
	@Test
	void checkMeshEquals() throws WrongFileFormatException {
		//Check the hash code of Polygons
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");
		mesh.setWriter(new OBJMeshWriter()); 
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");
		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");
		mesh.equals(mesh2);
		mesh.equals(null);
		mesh.equals(mesh);
		
		Vertex v = new Vertex(1, 2, 3);
		mesh.equals(v);
		assertEquals(mesh.hashCode(), mesh2.hashCode());
		
	
	}
	
	

	
	@Test
	void checkOFFReading() throws WrongFileFormatException {
		//Check the hash code of Polygons

		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testingOFF2.txt");


		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OFFMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testingOFF1.txt");
		
		assertEquals(mesh.hashCode(), mesh2.hashCode());
	}
	@Test
	void checkRotationXPi() throws WrongFileFormatException {
		//Check the hash code of Polygons

		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");
		mesh.rotateXAxis(2*Math.PI);
		mesh.setWriter(new OBJMeshWriter()); 
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");

		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");
		
		assertEquals(mesh.hashCode(), mesh2.hashCode());
	}
	
	@Test
	void checkRotationZPi() throws WrongFileFormatException {
		//Check the hash code of Polygons

		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");
		mesh.rotateZAxis(2*Math.PI);
		mesh.setWriter(new OBJMeshWriter()); 
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");

		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");
		
		assertEquals(mesh.hashCode(), mesh2.hashCode());
	}
	
	@Test
	void checkRotationYPi() throws WrongFileFormatException {
		//Check the hash code of Polygons

		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");
		mesh.rotateYAxis(2*Math.PI);
		mesh.setWriter(new OBJMeshWriter()); 
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");

		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");
		
		assertEquals(mesh.hashCode(), mesh2.hashCode());
	}

	

	
	@Test
	void checkMeshReadingWriting() throws WrongFileFormatException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");
		mesh.setWriter(new OBJMeshWriter()); 
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotatedobj.obj");

		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotatedobj.obj");
		
		assertEquals(mesh.hashCode(), mesh2.hashCode());
	}
	@Test
	void checkMeshHash() throws WrongFileFormatException {
		
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");	
		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_new.ply");

		
		Mesh mesh2 = new Mesh();
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");
		mesh2.setWriter(new OFFMeshWriter());
		mesh2.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_new.off");
		
		Mesh mesha = new Mesh();
		mesha.setReader(new PLYMeshReader());
		mesha.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_new.ply");
		
		Mesh meshb = new Mesh();
		meshb.setReader(new OFFMeshReader());
		mesha.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_new.off");

		assertEquals(mesha.hashCode(), meshb.hashCode());

	}
	

	
	@Test
	void checkWritingOBJ() throws WrongFileFormatException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car2.obj");	
		mesh.setWriter(new OBJMeshWriter()); 
		mesh.writeToFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj"); 
		
		Mesh cmesh = new Mesh();
		cmesh.setReader(new OBJMeshReader());
		cmesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\car_rotated.obj");



		
		assertEquals(cmesh.hashCode(), mesh.hashCode());
	}
	
	


	
//	OBJ FILES ---------------------------------------------------------------------------------------------------------------------------
	@Test
	void testPreceedingF_OBJ() {
		// v 1.0 2.0 3.0 
		// v 1.0 2.0 3.0 
		// f 2 3 4
		// v 1.0 2.0 3.0 
		// . . .
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OBJMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testPreceedingF_OBJ.txt");	
		}
		catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Check your V's and F's"); 
		}
	}
	
	
	
	@Test
	void testIndexOutOfRangeOBJ() {
		// v 1.0 2.0 3.0 
		// v 1.0 2.0 3.0 
		// v 1.0 2.0 3.0 
		// f 1 2 4
		// . . .
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OBJMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIndexOutOfRangeOBJ.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Check indexes!!!");
		}
	}

	@Test
	void testRandomExtraCharacterOBJ() {
		// v 1.0 2.0 3.0 
		// v 1.0 2.0 3.0 
		// v 1.0 2.0 3.0 
		// f 1 2 4 @
		// . . .
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OBJMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testRandomExtraCharacterOBJ.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Incorrect format!!");
		} 
	}
//	PLY FILES -------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	void testIncorrectVertexPLY() {
//		ply 
//		format ascii 1.0 
//		element vertex 6          <----- Wrong Count 
//		property float32 x 
//		property float32 y 
//		property float32 z 
//		element face 2 
//		property list uint8 int32 vertex_indices 
//		end_header 
//		5.1 1.2 0.3 
//		4.9 1.5 0.3 
//		3.8 1.4 0.5 
//		4.1 1.6 0.6 
//		3 0 1 2 
//		3 1 2 3  
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new PLYMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIncorrectVertexPLY.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Entered the wrong number of Vertices or/and Faces");
		}
	}
	
	@Test
	void testIncorrectFacePLY() {
//		ply 
//		format ascii 1.0 
//		element vertex 4        
//		property float32 x 
//		property float32 y 
//		property float32 z 
//		element face 3 				<--------- Wrong Count
//		property list uint8 int32 vertex_indices 
//		end_header 
//		5.1 1.2 0.3 
//		4.9 1.5 0.3 
//		3.8 1.4 0.5 
//		4.1 1.6 0.6 
//		3 0 1 2 
//		3 1 2 3  
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new PLYMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIncorrectFacePLY.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Entered the wrong number of Vertices or/and Faces");
		}
	}
	
	@Test
	void testIncorrectLinePLY() {
//		ply 
//		format ascii 1.0 
//		element vertex 4        
//		property float32 x 
//		property float32 y 
//		property float31 z          <------- 32 not 31
//		element face 2 				
//		property list uint8 int32 vertex_indices 
//		end_header 
//		5.1 1.2 0.3 
//		4.9 1.5 0.3 
//		3.8 1.4 0.5 
//		4.1 1.6 0.6 
//		3 0 1 2 
//		3 1 2 3  
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new PLYMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIncorrectLinePLY.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Incorrect format!!");
		}
	}
	
	@Test
	void testIncorrectIndexPLY() {
//		ply 
//		format ascii 1.0 
//		element vertex 4        
//		property float32 x 
//		property float32 y 
//		property float32 z          
//		element face 2 				
//		property list uint8 int32 vertex_indices 
//		end_header 
//		5.1 1.2 0.3 
//		4.9 1.5 0.3 
//		3.8 1.4 0.5 
//		4.1 1.6 0.6 
//		3 0 1 6 			<------------- 6 not in range
//		3 1 2 3  
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new PLYMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIncorrectIndexPLY.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Check indexes!!!");
		}
	}
	
//	OFF Files --------------------------------------------------------------------------------------------------------------------------
	@Test
	void testIncorrectVertexOFF() {
//		OFF 
//		5  2  0 				<-------------- Incorrect Vertex
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 
//		4.1  1.6  0.6 
//		3  0  1  2  220  220  200 
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIncorrectVertexOFF.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Entered the wrong number of Vertices or/and Faces");
		}
	}
	
	@Test
	void testIncorrectFacesOFF() {
//		OFF 
//		4  4  0 				<-------------- Incorrect Faces
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 
//		4.1  1.6  0.6 
//		3  0  1  2  220  220  200 
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testIncorrectFacesOFF.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Entered the wrong number of Vertices or/and Faces");
		}
	}

	@Test
	void testPreceedingF_OFF() {
//		OFF 
//		4  4  0 				
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 
//		3  0  1  2  220  220  200 	<------------ Preceding Face
//		4.1  1.6  0.6 
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testPreceedingF_OFF.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Incorrect format!!");
		}
	}
	
	@Test
	void testFalseConstantOFF() {
//		OUF 				<------- Change of Constant
//		4  4  0 				
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 	
//		4.1  1.6  0.6 
//		3  0  1  2  220  220  200 
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testFalseConstantOFF.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Incorrect format!!");
		}
	}
	
	@Test
	void testFalseEdgeOFF() {
//		OFF 				
//		4  4  3 			<------- Change of Constant	
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 	
//		4.1  1.6  0.6 
//		3  0  1  2  220  220  200 
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testFalseEdgeOFF.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Incorrect format!!");
		}
	}
	@Test
	void testWrongRGB() {
//		OFF 				
//		4  4  3 				
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 	
//		4.1  1.6  0.6 
//		3  0  1  2  -1  200  200 		<------ Wrong RGB Val
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testWrongRGB.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Wrong RGB");
		}
	}
	
	@Test
	void testWrongIndexOFF() {
//		OFF 				
//		4  4  3 				
//		5.1  1.2  0.3 
//		4.9  1.5  0.3 
//		3.8  1.4  0.5 	
//		4.1  1.6  0.6 
//		3  0  1  6  -1  200  200 		<------ Wrong Index
//		3  1  2  3  220  220  200   
		try {
			Mesh mesh = new Mesh();
			mesh.setReader(new OFFMeshReader());
			mesh.readFromFile("C:\\Users\\vchan\\Downloads\\SampleFiles\\testWrongIndexOFF.txt");	
		} catch (WrongFileFormatException ek) {
			assertEquals(ek.error, "Check indexes!!!");
		}
	}



}
