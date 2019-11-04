package Efficiency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IntegerSorter{
    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 9, 14};
        int[] array2 = {2, 4, 6, 8, 10, 11};
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i]);
        }
        System.out.print("\n");
        //array1 = combineArrays(array1, array2);
        //for(int i = 0; i < array1.length; i++){
        //    System.out.print(array1[i]);
        //}
        getArray();

    }

    public static int[] sort_method1(int[] array) {
        int temp;
        for(int index = array.length-1; index >= 0; index--) {
            for(int i = 0; i <= index; i++) {
                if(array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] sort_method2(int[] array) {
        int temp;
        for(int index = 0; index <= array.length-1; index++) {
            for(int i = index + 1; i <= array.length-1; i++) {
                if(array[index] > array[i]) {
                    temp = array[i];
                    array[i] = array[index];
                    array[i] = temp;
                }
            }
        }
        return array;
    }   
    
    public static int[] combineArrays(int[] a, int[] b) {
    	int[] c = new int[a.length + b.length];
    	int smallerIndex = 0;
    	int largerIndex = 0;
    	int cIndex = 0;
    	int smaller[], larger[];
    	
    	if(a.length < b.length) {
    		smaller = a;
    		larger = b;    		
    	}else {
    		smaller = b;
    		larger = a;     		
    	}
    	while(smallerIndex <= smaller.length-1) {
    		if(smaller[smallerIndex] < larger[largerIndex]) {
    			c[cIndex] = smaller[smallerIndex];    
    			smallerIndex++;
    		}else {
    			c[cIndex] = larger[largerIndex];
    			largerIndex++;
    		}
    		cIndex++;
    	}
    	
    	if(a.length < b.length || b.length < a.length) {
    		for(int i = smallerIndex+1; i <= larger.length; i++) {
        		System.out.println("y"+ larger[i-1]);
        		c[cIndex] = larger[i-1];
        		if(cIndex < c.length-1) {
            		cIndex++;
            		}
        		} 
    		}else {
    			c[cIndex] = larger[larger.length-1];
    		}
    	
    	
    	return c;
    }
    
    public static int[] sort_method3(int[] array) { 	
			
    	return array;
    }
    
    public static int[] getArray() {		
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("src/Efficiency/2power5.txt");
			bufferedReader = new BufferedReader(fileReader);			
			int val = 0;
			while ((val = bufferedReader.read()) != -1) {
				if (val != ' ') {
					char c = (char) val;
					System.out.print(c);
					list.add((int) c);
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int[] array = new int[list.size()];		
		for(int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		
		return array;		
    }		
}

