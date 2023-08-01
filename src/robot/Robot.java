package robot;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {
	private int[][] matrix;
	private int score;
	private List<Integer> path = new ArrayList<Integer>(); 
	
	public void readFile(String filePath) {
		BufferedReader reader = null;
		try {
			FileReader fr = new FileReader(filePath);
			reader = new BufferedReader(fr);
			
			int row = Integer.parseInt(reader.readLine());
			int col = Integer.parseInt(reader.readLine());
			
			int[][] matrix = new int[row][col];
			
			String line;	
			for(int i=0; i < row; i++) {
				 line = reader.readLine();
				 String[] arrOfStr = line.split(" ");
				 int[] arrOfInt = Arrays.stream(arrOfStr).mapToInt(Integer::parseInt).toArray();
				 for(int j=0; j < col; j++) {
					 matrix[i][j] = arrOfInt[j];
				 }
			}
			
			this.matrix = matrix;
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) {
					reader.close();									
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run(int x , int y) {
		int row = this.matrix.length;
		int col = this.matrix[0].length;
		
		if(x>=0 && y>=0 && x<col && y<row) {
		
			int i = 0;
			int j = 0;
			int max, xOfMax, yOfMax;
	   		do {
				this.path.add(this.matrix[y][x]);
				this.score = this.score + this.matrix[y][x];
				
				max = 0;
				xOfMax = -1;
				yOfMax = -1;
	
				//Up
				i = x;
				j = y-1;
				if(i>=0 && i<col && j>=0 && j<row && !this.path.contains(this.matrix[j][i])) {
					if(this.matrix[j][i] > max) {
						xOfMax = i;
						yOfMax = j;
						max = this.matrix[j][i];
					}
				};
				
				//Left
				i = x+1;
				j = y;
				if(i>=0 && i<col && j>=0 && j<row && !this.path.contains(this.matrix[j][i])) {
					if(this.matrix[j][i] > max) {
						xOfMax = i;
						yOfMax = j;
						max = this.matrix[j][i];
					}
				};
				
				//Down
				i = x;
				j = y+1;
				if(i>=0 && i<col && j>=0 && j<row && !this.path.contains(this.matrix[j][i])) {
					if(this.matrix[j][i] > max) {
						xOfMax = i;
						yOfMax = j;
						max = this.matrix[j][i];
					}
				};
				
				//Right
				i = x-1;
				j = y;
				if(i>=0 && i<col && j>=0 && j<row && !this.path.contains(this.matrix[j][i])) {
					if(this.matrix[j][i] > max) {
						xOfMax = i;
						yOfMax = j;
						max = this.matrix[j][i];
					}
				};
				
				x = xOfMax;
				y = yOfMax;
				
			} while(max != 0);
	   		
		} else {
			System.out.println("Invalid coordinate");
		}
		
	}
	
	public void printResult() {
		System.out.println("Score " + this.score);
		System.out.println("Path: " + path.toString());
	}

	public void writeFile(String filePath) {
		BufferedWriter writer = null;
		try {
			FileWriter fw = new FileWriter(filePath);
			writer = new BufferedWriter(fw);
			
			writer.append("Score: "+ this.score);
			writer.newLine();
			writer.append("Path: " + path.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null) {
					writer.close();									
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
