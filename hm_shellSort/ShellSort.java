import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {

    int[] sort(int[] array) {
        int n = array.length;
        int temp;
        int oper = 0;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int j = i; oper++;
                while (j >= gap && array[j] < array[j-gap]) {
                    temp = array[j-gap]; oper+=3;
                    array[j-gap] = array[j]; oper+=4;
                    array[j] = temp; oper+=2;
                    j-= gap; oper+=2;
                }
            }
        }
//        System.out.print(oper + " - oper; ");
        return array;
    }

    public static void main(String[] args) {
         ShellSort sortOb = new ShellSort();

         try {
             Scanner in = new Scanner(new File("data.txt"));
             int numGroups = Integer.parseInt(in.nextLine());
             System.out.println(numGroups);
             int[] arr;
             for (int i = 0; i < numGroups; i++) {
                 int numIntegers = Integer.parseInt(in.nextLine());
                 arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                 long st = System.nanoTime();
                 arr = sortOb.sort(arr);
                 long en = System.nanoTime();
                 System.out.println(numIntegers);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }



    }
}
