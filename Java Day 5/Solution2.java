import java.io.*;

import java.util.*;

import java.util.stream.*;



class Result {

    /*
     * Complete the 'secondLargest' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static int secondLargest(int n, List<Integer> arr) {
    // Write your code here
    int largest = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;

    for (int num : arr) {
        if (num > largest) {
            second = largest;
            largest = num;
        } else if (num < largest && num > second) {
            second = num;
        }
    }

    if (second == Integer.MIN_VALUE) {
        return -1;
    }

    return second;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Arrays.stream(bufferedReader.readLine().trim().split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Result.secondLargest(n, arr);


        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
