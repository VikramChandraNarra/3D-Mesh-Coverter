package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PLYMeshReader implements MeshReader{
	@Override
	public HashSet<Polygon> read(String filename) throws WrongFileFormatException{
		
		try {
			
			Scanner input = new Scanner(new File(filename));
			
			
			
			HashSet<Polygon> p = new HashSet<Polygon>();

			ArrayList data = new ArrayList();

			Pattern pattern = Pattern.compile("(^\\s*ply\\s*$|^\\s*format ascii\\s*\\d.\\d\\s*$|^\\s*property float32\\s+[xyz]\\s*$|^\\s*property list uint8 int32 vertex_indices\\s*$|^\\s*end_header\\s*$)");

			Pattern p2 = Pattern.compile("(^\\s*element vertex\\s+\\d+\\s*$)");
			Pattern p3 = Pattern.compile("(^\\s*element face\\s+\\d+\\s*$)");
			Matcher m1;
			Matcher m2;
			Matcher m3;
			Matcher m4;
			
			int noOfVertices = 0;
			int noOfFaces = 0;
			int brother = 0;
			
			int counterV = 0;
			int counterF = 0;
			Matcher matcher;
			while (input.hasNextLine()) {
				String s = input.nextLine();
				String [] subarray = s.trim().split("\\s+");

				matcher = pattern.matcher(s);
//				Pattern checkNums = Pattern.compile("^\\s*(-{0,1}\\d+.\\d+\\s*|\\s+0){"+(subarray.length)+"}\\s*$"); // Float
				Pattern checkNums = Pattern.compile("^\\s*(\\s*-{0,1}\\d+[.]\\d+|\\s*0){"+(subarray.length)+"}\\s*$");//Float
				Pattern checkNums2 = Pattern.compile("^\\s*\\d+(\\s+\\d+){"+(subarray.length - 1)+"}\\s*$"); //Int
				m1 = p2.matcher(s);
				m2 = p3.matcher(s);
				m3 = checkNums.matcher(s);
				m4 = checkNums2.matcher(s);

				if (m1.matches()) {
					//No vertices
//					System.out.println(s+" m1");
					noOfVertices = Integer.parseInt(subarray[subarray.length - 1]);

				}else if (m2.matches()) {
					//No faces
//					System.out.println(s+" m2");

					noOfFaces = Integer.parseInt(subarray[subarray.length - 1]);
					
					
				}else if (matcher.matches()) {
//					System.out.println("h");
					//No code here
				}else if (m3.matches()) {
//					System.out.println(Integer.toString(counterV)+" "+s);
					
					data.add(subarray);
					counterV++;

				}else if (m4.matches()) {
//					System.out.println(Integer.toString(counterF)+" "+s);

					data.add(subarray);
					counterF++;

				}else {
//					System.out.println("PLY" + s);
					throw new WrongFileFormatException("Incorrect format!!");

				}
				


			}
			if (noOfVertices != counterV || noOfFaces != counterF) {
//				System.out.println(noOfVertices);
//				System.out.println(counterV);
//
//				System.out.println(noOfFaces);
//
//				System.out.println(counterF);
//				System.out.println(brother);


				throw new WrongFileFormatException("Entered the wrong number of Vertices or/and Faces");

			}

			for (int i = counterV; i < data.size(); i++) {
				LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
				String [] arr = (String [])data.get(i);
				for (int j = 1; j < arr.length; j++) {
					int index = Integer.parseInt(arr[j]);
					if (index >= counterV) {
						throw new WrongFileFormatException("Check indexes!!!");

					}
					String [] points = (String [])data.get(index);
					Vertex v = new Vertex(Double.parseDouble(points[0]), Double.parseDouble(points[1]), Double.parseDouble(points[2]));
//					System.out.println(v.toString());
					vertices.add(v);
				}
				Polygon fr = new Polygon(vertices);
				
				p.add(fr);
//				System.out.println("lf");

			}
			return p;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (WrongFileFormatException k) {
//			throw new WrongFileFormatException("")
			k.printStackTrace();
		}
		return null;
		
		// TODO Auto-generated method stub

	}
	
	
}
