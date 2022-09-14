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

public class OFFMeshReader implements MeshReader{

	@Override
	public HashSet<Polygon> read(String filename) throws WrongFileFormatException{
		
		try {
			
			Scanner input = new Scanner(new File(filename));
			
			
			
			HashSet<Polygon> p = new HashSet<Polygon>();

			ArrayList data = new ArrayList();

			Pattern pattern = Pattern.compile("(^\\s*OFF\\s*$)");

			Matcher m1;
			Matcher m2;
			Matcher m3;
			Matcher m4;
			Matcher m5;
			Matcher matcher;

			int noOfVertices = 0;
			int noOfFaces = 0;
			Pattern checkNums2 = Pattern.compile("(^\\s*\\d+\\s+\\d+\\s+\\d+\\s*$)"); //Int
			int counterV = 0;
			int counterF = 0;
			int it = 0;
			String firstLine = input.nextLine();
			String secondLine = input.nextLine();

			m1 = pattern.matcher(firstLine);
			m2 = checkNums2.matcher(secondLine);
			String[] f = secondLine.trim().split("\\s+");
			if (m1.matches() && m2.matches()) {
				noOfVertices = Integer.parseInt(f[0]);
				noOfFaces = Integer.parseInt(f[1]);
			}else {

				throw new WrongFileFormatException("Incorrect format!!");
			}
			while (input.hasNextLine()) {
				
				String s = input.nextLine();
				String [] subarray = s.trim().split("\\s+");
				
				if (it < noOfVertices) {
					Pattern vertex = Pattern.compile("^\\s*(\\s*-{0,1}\\d+[.]\\d+|\\s*0){"+(subarray.length)+"}\\s*$"); // Float
					m3 = vertex.matcher(s);
					if (m3.matches()) {
						data.add(subarray);
						counterV++;
						
					}
					else {
						throw new WrongFileFormatException("Incorrect format!!");

					}
				}else {

					Pattern face = Pattern.compile("(^\\s*\\d*(\\s+\\d){"+(Integer.parseInt(subarray[0]))+"}$)");// Checks with the colors	
					Pattern face2 = Pattern.compile("^\\s*\\d*(\\s+\\d+){"+(Integer.parseInt(subarray[0]))+"}\\s+\\d+\\s+\\d+\\s+\\d+\\s*$");
					m4 = face.matcher(s);
					m5 = face2.matcher(s);
					if (m4.matches()) {
						data.add(subarray);
						counterF++;
	
					}
					else if (m5.matches()) {
		
						int x = subarray.length;
						if (Integer.parseInt(subarray[x - 1]) < 0 || Integer.parseInt(subarray[x-1]) > 255) {
							throw new WrongFileFormatException("Wrong RGB");

						}
						else if (Integer.parseInt(subarray[x-2]) < 0 || Integer.parseInt(subarray[x-2]) > 255) {
							throw new WrongFileFormatException("Wrong RGB");

						}
						else if (Integer.parseInt(subarray[x-2]) < 0 || Integer.parseInt(subarray[x-2]) > 255) {
							throw new WrongFileFormatException("Wrong RGB");

						}
						data.add(subarray);
						counterF++;
					}
					else {
						throw new WrongFileFormatException("Incorrect format!!");
					}
					
				}
				it++;
			}
			if (noOfVertices != counterV || noOfFaces != counterF) {
				throw new WrongFileFormatException("Entered the wrong number of Vertices or/and Faces");
			}
			
			for (int i = counterV; i < data.size(); i++) {
				LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
				String [] arr = (String [])data.get(i);
				for (int j = 1; j <= Integer.parseInt(arr[0]); j++) {
					int index = Integer.parseInt(arr[j]);
					if (index >= counterV) {
						throw new WrongFileFormatException("Check indexes!!!");

					}					
					String [] points = (String [])data.get(index);
					Vertex v = new Vertex(Double.parseDouble(points[0]), Double.parseDouble(points[1]), Double.parseDouble(points[2]));
					vertices.add(v);
				}
				Polygon fr = new Polygon(vertices);
				
				p.add(fr);

			}
			input.close();
			return p;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException g) {
			g.printStackTrace();
		}catch (WrongFileFormatException k) {
			k.printStackTrace();
		}
		return null;
		

	}
}
