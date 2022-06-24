//Реализовать алгоритм пирамидальной сортировки (HeapSort), массив задается чтением из файла
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class heapSorting {

    public static int [] reader() throws FileNotFoundException {
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String [] numbersString = line.split(" ");
        int [] numbers = new int[numbersString.length];
        int counter = 0;
        for (String number : numbersString){
            numbers[counter] = Integer.parseInt(number);
            counter ++;
        }
        scanner.close();
        return numbers;
        
    }

    public static void printArray(int [] array) {
        for (int i = 0; i < array.length; i++ ){
            System.out.printf("%d ", array[i]);
        }
    }
    
    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n /2 - 1; i >= 0; i-- ) {
            heapify(array, i, n);
        }
        for (int i = n - 1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i);
        }
        }
        
    public static void heapify(int[] array, int i, int n) {
        int left = i*2 + 1;
        int right = i*2 + 2;
        int largest = i;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest  = right;
        }
        if (i != largest){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            
            heapify(array, largest, n);
        }
    }
    public static void main(String [] args) throws FileNotFoundException {
        int [] arr = reader();
        printArray(arr);
        System.out.println();
        heapSort(arr);
        printArray(arr);
        
    }
}
