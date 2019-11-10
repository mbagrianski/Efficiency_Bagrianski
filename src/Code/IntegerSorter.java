/*
Misha Bagrianski, ICS4U1, Efficiency of algorithms assignment
Instructor: Mr. Radulovic
Sorts an array of 2^n | n ∈ N elements, provided by a text file with 3 different methods
Also provides 3 samples of 3 methods for one array size. This facilitates the creation of the graph aas per requirements.
November 10th, 2019
 */

package Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntegerSorter implements Sorter {

    private int[] list;

    public static void main(String[] args) throws FileNotFoundException
    {
        IntegerSorter X = new IntegerSorter(); //creeate new instance of IntegerSorter
        for(int i = 0; i < 3; i++){
            X.setList(getArray()); //set array used to the file input
            X.sort(i+1); //sort the list using the specified method (once of each)
        }
    }

    public static int[] sort_method1(int[] array) { //first method
    	long startTime = System.nanoTime();
        int temp;
        for(int index = array.length-2; index >= 0; index--) {//start at index of greatest element, go backwards
            for(int i = 0; i <= index; i++) { //start at index 0 and go up to 'index'
                if(array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration + " Method 1");
        return array;
    }

    public static int[] sort_method2(int[] array) {
    	long startTime = System.nanoTime();
        int temp;
        for(int index = 0; index <= array.length-1; index++) { //start at index of 0
            for(int i = index + 1; i <= array.length-1; i++) { //start from index + 1 and go up
                if(array[index] > array[i]) {
                    temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration + " Method 2");
        return array;
    }   

    public static void sort_method3(int[] array){ //calls 3rd sort method. Another method is needed because
        // sort_method3 is recursive, and timing in a recursive method wouldn't work, so we do that here.
        long startTime = System.nanoTime();
        sortWithMerge(array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration + " Method 3");

    }
    public static int[] sortWithMerge(int[] array) //sorts with 3rd method
    {
        //If list is empty return list (nothing to sort)
        if (array.length <= 1) {
            return array;
        }

        //Split the array in half
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];
        //create copy of arrays
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        //Create new instance of sortWithMerge with the new arrays
        sortWithMerge(first);
        sortWithMerge(second);

        //merge the two arrays back together
        combineArrays(first, second, array);

        return array;
    }

    public static void combineArrays(int[] first, int[] second, int[] result)
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

        File file = new File("src/Files/2power9.txt");
    	Scanner scanner = new Scanner(file);
        int [] array = new int [(int) Math.pow(2, 9)]; //specifies size of array. The power must equal the power in the filename.
    	int i = 0;
    	while(scanner.hasNextInt())
    	{
    	     array[i++] = scanner.nextInt();
    	}
    	scanner.close();
    	return array;
    }

    @Override
    public void setList(int[] list) {
        this.list = list;
    }

    @Override
    public int[] getList() {
        return list;
    }

    @Override
    public void sort(int type) {
        switch (type){
            case 1:
                sort_method1(getList());
                return;
            case 2:
                sort_method2(getList());
                return;
            case 3:
                sort_method3(getList());
                return;
        }
    }

    @Override
    public String toString() {
        String str = null;
        for(int i = 0; i < getList().length; i++){
            str += getList()[i];
        }
        return str;
    }
}
