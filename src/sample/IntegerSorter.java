package Efficiency;

public class IntegerSorter{
    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8};
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i]);
        }
        System.out.print("\n");
        array1 = combineArrays(array1, array2);
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i]);
        }
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
    	int smaller[], larger[];
    	if(a.length < b.length) {
    		smaller = a;
    		larger = b;    		
    	}else {
    		smaller = b;
    		larger = a;    		
    	}
    	while(smallerIndex <= smaller.length-1 && largerIndex <= larger.length-1) {
    		if(smaller[smallerIndex] < larger[largerIndex]) {
    			c[smallerIndex] = smaller[smallerIndex];    
    			smallerIndex++;
    		}else {
    			c[largerIndex] = larger[largerIndex];
    			largerIndex++;
    		}
    	}
    	for(int i = smallerIndex; i <= larger.length-1; i++) {
    		c[smallerIndex] = larger[i];
    	}
    	return c;
    }
}



















