package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.*;

public class OBJMeshReader implements MeshReader {

	@Override
	public HashSet<Polygon> read(String filename) throws WrongFileFormatException{
		
		try {
			
			Scanner input = new Scanner(new File(filename));
			
			HashSet<Polygon> p = new HashSet<Polygon>();
			ArrayList data = new ArrayList();
			int lastv = 0;
			int firstf = 0;
			int it = 0;
			int noV = 0;
			int noF = 0;
//			Pattern pattern = Pattern.compile("(^\\s*f\\s+\\d\\s+\\d\\s+\\d\\s*$|^\\s*v\\s+\\d.\\d\\s+\\d.\\d\\s+\\d.\\d\\s*$)");
//			Pattern face = Pattern.compile("^\\s*f\\s+\\d\\s+\\d\\s+\\d\\s*$");
//			Pattern vertex = Pattern.compile("^\\s*v\\s+\\d.\\d\\s+\\d.\\d\\s+\\d.\\d\\s*$");
			Matcher mv;
			Matcher mf;
			// f 1 2 3
			// [f , 1 , 2, 3]
			while (input.hasNextLine()) {
				String s = input.nextLine();
				String [] subarray = s.trim().split("\\s+");
				Pattern face = Pattern.compile("^\\s*f(\\s+\\d+){"+(subarray.length - 1)+"}\\s*$");
				Pattern vertex = Pattern.compile("^\\s*v(\\s+-{0,1}\\d+[.]\\d+|\\s+0){"+(subarray.length - 1)+"}\\s*$");
				mv = vertex.matcher(s);
				mf = face.matcher(s);	
				if (mv.matches()) {
					data.add(subarray);
					noV++;
					lastv = it;
				}
				else if (mf.matches()) {
					data.add(subarray);
					noF++;
					if (firstf == 0) {
						firstf = it;
					}
				}
				else {
//					System.out.println("OBJ " + s + Integer.toString(it));
//					System.out.println("OBJ " + s);

					throw new WrongFileFormatException("Incorrect format!!");
				}
				it++;
			}
			
			if (lastv > firstf) {
				throw new WrongFileFormatException("Check your V's and F's");
			}

			for (int i = noV; i < data.size(); i++) {
				LinkedHashSet<Vertex> vertices = new LinkedHashSet<Vertex>();
				String [] arr = (String [])data.get(i);
				for (int j = 1; j < arr.length; j++) {
					int index = Integer.parseInt(arr[j]) - 1;
					if (index >= noV) {
						throw new WrongFileFormatException("Check indexes!!!");

					}
					String [] points = (String [])data.get(index);
					Vertex v = new Vertex(Double.parseDouble(points[1]), Double.parseDouble(points[2]), Double.parseDouble(points[3]));
//					System.out.println(v.toString());
					vertices.add(v);
				}
				Polygon fr = new Polygon(vertices);
				
				p.add(fr);
//				System.out.println("lf");

			}
			input.close();
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
