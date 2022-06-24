//Реализовать алгоритм сортировки слиянием
import java.util.Scanner;
public class mergeSorting {

    public static int reader() {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.printf("Введите число элементов массива n: ");
        while (!sc.hasNextInt()) {
            System.out.println("Неправильный ввод! Попробуйте еще раз!");
            sc.next(); 
        }
        number = sc.nextInt();
        if (number == 0){
            System.out.println("Массив будет пустым, сортировать нечего");
        }
        } while (number <= 0);
        sc.close();
        return number;
    }

    public static int [] createArray(int n) {
        int borderForRandom = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++ ){
            arr[i] = (int) (Math.random()*borderForRandom);       
        }
        return arr;
    }
    
    public static void mergeSort(int [] arr) {
        int n = arr.length;
        if (n == 1) return;
        int mid = n / 2;
        int [] left = new int[mid];
        int [] right = new int[n-mid];

        for (int i = 0; i < n; i++) {
            if (i < mid) {
                left[i] = arr[i];
            } else {
                right[i-mid] = arr[i];
            }
            }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
        }

        public static void merge(int [] arr, int[] left, int[] right) {
            int l = left.length;
            int r = right.length;
            int i = 0;
            int j = 0;
            int index = 0;
            while (i < l && j < r) {
                if (left[i] < right[j]){
                    arr[index] = left[i];
                    i++;           
                } else {
                    arr[index] = right[j];
                    j++;    
                }
                index ++;
                }
            for (int ll = i; ll< l; ll++) {
                arr[index++] = left[ll];
            }
            for (int rr = j; rr< r; rr++) {
                arr[index++] = right[rr];
            }
            }

        public static void printArray(int [] array) {
            for (int i = 0; i < array.length; i++ ){
                System.out.printf("%d ", array[i]);
            }
        }
        public static void main(String [] args) {
            int n = reader();
            int[] arr = createArray(n);
            System.out.println("Исходный массив:");
            printArray(arr);
            System.out.println();
            System.out.println("Отсортированный массив:");
            mergeSort(arr);
            printArray(arr);
        }
        } 
        
    

