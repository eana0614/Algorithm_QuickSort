package quick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuickSort {
	
	private static int arrayLength = 1000;
	
	public static void main(String[] args) {
		
		String filePath = "random.txt";
		String fileName = "java quick sort.txt";
		
		int[] readArray;
		
		try {
			
			readArray = readInputFile(filePath);
			int[] sortedArray = quicksort(readArray, 0, readArray.length-1);
			writeSortedFile(fileName, sortedArray);
			
			System.out.println("DONE");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private static int[] quicksort(int[] inputArray, int pivot, int r) {
		int q;
		
		if(pivot < r){
			q = partition(inputArray, pivot, r);
			inputArray = quicksort(inputArray, pivot, q-1);
			inputArray = quicksort(inputArray, q+1, r);
		}
		return inputArray;
	}


	private static int partition(int[] inputArray, int pivot, int r) {
		int temp = inputArray[r];
		int i = pivot-1;
		int t = 0;
		
		for(int j=pivot; j<r; j++){
			if(inputArray[j] <= temp){
				i++;
				t = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = t;
			}
		}
		i++;
		t = inputArray[i];
		inputArray[i] = inputArray[r];
		inputArray[r] = t;
		
		return i;
	}


	private static void writeSortedFile(String fn, int[] array) throws IOException{
		File ouputFile = new File(fn);
		FileOutputStream fos = new FileOutputStream(ouputFile);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		for(int i=0; i<array.length; i++){
			bw.write(String.valueOf(array[i]));
			bw.newLine();
		}
		
		bw.close();
		osw.close();
		fos.close();
	}

	private static int[] readInputFile(String filePath) throws IOException   {
		File inputFile = new File(filePath);
		FileInputStream fis = new FileInputStream(inputFile);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		int[] tempArray = new int[arrayLength];
		
		String s;
		int i=0;
		
		while((s = br.readLine())!=null){
			tempArray[i]= Integer.parseInt(s);
			i++;
		}
		
		br.close();
		isr.close();
		fis.close();
		
		return tempArray;
	}

}
