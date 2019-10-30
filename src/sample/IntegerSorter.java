package sample;
import java.util.ArrayList;

public class IntegerSorter{
    public static void main(String[] args) {

        int[] array = {2, 5, 7, 2, 3};
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
        System.out.print("\n");
        array = sort_method1(array);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
    }

    public static int[] sort_method1(int[] array) {
        int temp;
        for(int index = array.length-1; index >= 0; index--) {
            for(int i = 0; i < index; i++) {
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
}