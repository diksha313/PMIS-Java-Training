import java.io.*;




class Result {

    /*
     * Complete the 'isSpecialNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int isSpecialNumber(int n) {
    // Write your code here
 int original = n;
    int sum = 0;

    while (n > 0) {
        int digit = n % 10;
        int fact = 1;

        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }

        sum += fact;
        n /= 10;
    }

    return (sum == original) ? 1 : 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.isSpecialNumber(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
