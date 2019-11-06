package Efficiency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class IntegerSorter{
	public static void main(String[] args) throws FileNotFoundException 
    {
        //Unsorted array
        int[] a =  getArray();
        	 sort_method2(a);
         
        //Call merge sort
        
         
        //Check the output which is sorted array
        
    }

    public static int[] sort_method1(int[] array) {
    	long startTime = System.nanoTime();
        int temp;
        for(int index = array.length-2; index >= 0; index--) {
            for(int i = 0; i <= index; i++) {
                if(array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(duration + " m1");
        return array;
    }

    public static int[] sort_method2(int[] array) {
    	long startTime = System.nanoTime();
        int temp;
        for(int index = 0; index <= array.length-1; index++) {
            for(int i = index + 1; i <= array.length-1; i++) {
                if(array[index] > array[i]) {
                    temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(duration + " m2");
        return array;
    }   
    

    static long startTime3 = System.nanoTime();
    public static int[] sort_method3(int[] first2) 
    {
    	

        //If list is empty return list
        if (first2.length <= 1) {
            return first2;
        }
         
        //Split the array in half
        int[] first = new int[first2.length / 2];
        int[] second = new int[first2.length - first.length];
        System.arraycopy(first2, 0, first, 0, first.length);
        System.arraycopy(first2, first.length, second, 0, second.length);
         
        //Create new instance of sort_method3 with the new arrays
        sort_method3(first);
        sort_method3(second);
         
        //merge the two arrays back together
        combineArrays(first, second, first2);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime3);  //divide by 1000000 to get milliseconds.
        System.out.println(duration + " m1");
        return first2;
    }
     
    private static void combineArrays(int[] first, int[] second, int[] result) 
    {
        //Index Position in first, second and final arrays starting with 0th element
        int i = 0, j = 0, k = 0;       
         
        //Compare elements at i and j, and move smaller element at k
        while (i < first.length && j < second.length) 
        {
            if (first[i] < second[j]) {
                result[k] = first[i];
                i++;
            }else {
                result[k] = second[j];
                j++;
            }
            k++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, i, result, k, first.length - i);
        System.arraycopy(second, j, result, k, second.length - j);
    }    
    
    
	public static int[] getArray() throws FileNotFoundException {		
    	
    	Scanner scanner = new Scanner(new File("src/Efficiency/2power13.txt"));
    	int [] array = new int [(int) Math.pow(2, 13)];
    	int i = 0;
    	while(scanner.hasNextInt())
    	{
    	     array[i++] = scanner.nextInt();
    	}
    	scanner.close();
		
		
		return array;		
    }		
}
