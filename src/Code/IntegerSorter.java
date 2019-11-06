package Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntegerSorter{

    public static void main(String[] args) throws FileNotFoundException
    {
        //Unsorted array
        int[] a1 =  getArray();
        int[] b1 =  getArray();
        int[] c1 =  getArray();

        int[] a2 =  getArray();
        int[] b2 =  getArray();
        int[] c2 =  getArray();
        int[] a3 =  getArray();
        int[] b3 =  getArray();
        int[] c3 =  getArray();

        sort_method1(a1);
        sort_method2(b1);
        long startTime3a = System.nanoTime();
        sort_method3(c1);
        long endTime3a = System.nanoTime();
        long durationa = (endTime3a - startTime3a);  //divide by 1000000 to get milliseconds.
        System.out.println(durationa + " m3");

        sort_method1(a2);
        sort_method2(b2);
        long startTime3b = System.nanoTime();
        sort_method3(c2);
        long endTime3b = System.nanoTime();
        long durationb = (endTime3b - startTime3b);  //divide by 1000000 to get milliseconds.
        System.out.println(durationb + " m3");

        sort_method1(a3);
        sort_method2(b3);
        long startTime3c = System.nanoTime();
        sort_method3(c3);
        long endTime3c = System.nanoTime();
        long durationc = (endTime3c - startTime3c);  //divide by 1000000 to get milliseconds.
        System.out.println(durationc + " m3");


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

    public static int[] sort_method3(int[] array)
    {
        //If list is empty return list
        if (array.length <= 1) {
            return array;
        }
         
        //Split the array in half
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);
         
        //Create new instance of sort_method3 with the new arrays
        sort_method3(first);
        sort_method3(second);
         
        //merge the two arrays back together
        combineArrays(first, second, array);

        return array;
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

        File file = new File("src/Files/2power17.txt");
    	Scanner scanner = new Scanner(file);
    	char num = file.getName().charAt(6);
        int number = Integer.parseInt(String.valueOf(num));
        int [] array = new int [(int) Math.pow(2, 17)];
    	int i = 0;
    	while(scanner.hasNextInt())
    	{
    	     array[i++] = scanner.nextInt();
    	}
    	scanner.close();
		return array;		
    }		
}
