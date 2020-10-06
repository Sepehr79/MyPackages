package MyPackages;

import java.util.ArrayList;
import java.util.HashMap;

public class Algorithms {

    private Algorithms() {}

    public static int[] bubbleSort(int[] array){
        int len = array.length;
        for (int i = 0; i < len - 1; i++){
            for (int j = 0; j < len - i - 1; j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] countingSort(int[] array){
        int len = array.length;
        int max = getMax(array);
        int min = getMin(array);

        int[] counter = new int[max - min +1];
        for (int number: array)
            counter[number - min] += 1;

        int[] returnArr = new int[array.length];
        for (int i = 0; i < max - min + 1; i++)
            returnArr[i + min] = (i + min) * counter[i];

        return returnArr;
    }

    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int tmp = array[i];
            int idx = i;

            while (idx > 0 && tmp < array[idx - 1]){
                array[idx] = array[idx - 1];
                idx -= 1;
            }
            array[idx] = tmp;
        }
        return array;

    }

    // gets arraylist of prime numbers less and equals than input
    public static ArrayList<Integer> getPrimeNumbers(int num){
        int counter = 0;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for(int i = 2; i <= num; i++){
            for (int j = 1; j < i+1; j++){
                if (i % j == 0)
                    counter++;
            }
            if (counter == 2)
                primeNumbers.add(i);
            counter = 0;
        }

        return primeNumbers;
    }

    // get primes of input with their powers and push them into the hashmap
    public static HashMap<Integer, Integer> getPrimeStructure(int num){
        int primeNumber = 2, counter = 0, i = 0;
        HashMap<Integer, Integer> primeStructure = new HashMap<>();

        while (num != 1){
            while (num % primeNumber == 0){
                num = num / primeNumber;
                counter++;
                primeStructure.put(primeNumber, counter);
            }
            counter = 0;
            i++;
            do {
                primeNumber++;
            } while (!isPrime(primeNumber));
        }
        return primeStructure;
    }

    // identify that input is prime or not
    public static boolean isPrime(int num){
        int counter = 0;
        for (int i = 1; i <= num; i++){
            if (num % i == 0)
                counter++;
        }
        return counter == 2;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeNumbers(100));
    }

    private static int getMax(int... arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    private static int getMin(int ...arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}
