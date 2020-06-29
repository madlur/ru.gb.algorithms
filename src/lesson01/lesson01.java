package lesson01;

import java.util.Arrays;
import java.util.Random;

public class lesson01 {

    public static void main(String[] args) {

        System.out.println(power(5, 125));
        System.out.println(" minimum is: " + min());
        System.out.println(" average is: " + average());

    }

    // сложность алгоритма в power() = O(1)+O(log n +1) + O(log n)+O(1) = O(2log n + 1) + O(2) = O(2log n +3) = O(log n)
    static int power(int a, int n) {
        if (n == 0)
            return 1; //O(1)
        if (n % 2 == 1)
            return power(a, n - 1) * a; //O(log n + 1)
        else {
            int b = power(a, n / 2); //O(log n)
            return b * b; //O(1)
        }
    }

    // сложность алгоритма в min() = //O(1) + O(1) + O(n) + O(n) + O(1) + O(n) + O(1) = O(3n)+O(4)=O(3n+4) = O(n)
    static int min() {
        Random random = new Random(); //O(1)
        int length = random.nextInt(10) + 2; //O(1)
        int[] arr = new int[length]; //O(n)
        for (int i = 0; i < length; i++) { //O(n)
            arr[i] = random.nextInt(10) + 1;
        }
        int min = arr[0]; //O(1)
        for (int i = 1; i < arr.length; i++) { //O(n)
            if (arr[i] < min) min = arr[i];
        }
        System.out.println(Arrays.toString(arr));
        return min; //O(1)
    }

    // сложность алгоритма в average() = O(1)+O(1)+O(n)+O(n + 1)+O(1) = O(2n+4) = O(n)
    static float average() {
        Random random = new Random(); //O(1)
        int length = random.nextInt(10) + 2; //O(1)
        int[] arr = new int[length];  //O(n)
        float average = 0; //O(1)
        for (int i = 0; i < length; i++) {  //O(n + 1)
            arr[i] = random.nextInt(10) + 1;
            average += (float) arr[i];
        }
        System.out.println(Arrays.toString(arr));
        return average / (float) length; //O(1)
    }

}
