package com.ewhoxford.android.bloodpressure.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * class to read a csv pressure file and test the application
 * 
 * @author mauro
 * 
 */
public class ReadCSV {

	public int[][] readCSV(InputStream file) {

		// int[] x= new int[20000];
		// int[] y=new int[20000];

		int[][] numbers = new int[10000][2];

		InputStream is = file;
		BufferedReader bufRdr;

		try {
			bufRdr = new BufferedReader(new InputStreamReader(is));

			String line = null;
			int row = 0;
			int col = 0;

			// read each line of text file
			while ((line = bufRdr.readLine()) != null && row < 10000) {
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					// get next token and store it in the array
					numbers[row][col] = new Integer(st.nextToken());
					col++;
				}
				col = 0;
				row++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Structure s1=new Structure(x, y);

		return numbers;
	}

	public static float[][] readCSV(String directory, String fileName) {

		// int[] x= new int[20000];
		// int[] y=new int[20000];

		float[][] numbers = new float[15000][2];

		File file = new File(directory + "/" + fileName);

		BufferedReader bufRdr;
		try {
			bufRdr = new BufferedReader(new FileReader(file));

			String line = null;
			int row = 0;
			int col = 0;

			// read each line of text file
			while ((line = bufRdr.readLine()) != null && row < 15000) {
				StringTokenizer st = new StringTokenizer(line, ",");
				if (row > 1) {
					while (st.hasMoreTokens()) {

						numbers[row - 2][col] = new Integer(st.nextToken());
						col++;
					}
					col = 0;
					row++;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Structure s1=new Structure(x, y);

		return numbers;
	}
	
	public float[][] readCSV2(InputStream file) {

		// int[] x= new int[20000];
		// int[] y=new int[20000];

		float[][] numbers = new float[5000][2];

		InputStream is = file;
		BufferedReader bufRdr;

		try {
			bufRdr = new BufferedReader(new InputStreamReader(is));

			String line = null;
			int row = 0;
			// read each line of text file
			while ((line = bufRdr.readLine()) != null && row < 5000) {
				StringTokenizer st = new StringTokenizer(line, ",");
				int aux=0;	
				int col = 0;
				while (st.hasMoreTokens()) {
					// get next token and store it in the array
					if(aux>0){
						numbers[row][col] = new Float(st.nextToken());
						col++;
					}else{
						st.nextToken();
					}
					aux=aux+1;
				}
				col = 0;
				row++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Structure s1=new Structure(x, y);

		return numbers;
	}


}
