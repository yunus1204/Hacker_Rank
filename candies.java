import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
// ------------------------------------------------------main code----------------------
    public static long candies(int n, List<Integer> arr) {
    int[] amt=new int[n];
    Arrays.fill(amt,1);
    for(int i=1;i<n;i++)
    {
        if(arr.get(i-1)<arr.get(i))
        {
            amt[i]=amt[i-1]+1;
        } 
        // else if(arr.get(i-1)>=arr.get(i))
        // {
        //     continue;
        // }
    }
    for(int i=n-2;i>=0;i--)
    {
        if(arr.get(i+1)<arr.get(i) && amt[i]<=amt[i+1])
        {
            amt[i]=amt[i+1]+1;
        }
    }
    int sum=0;
    for(int i=0;i<n;i++)
    {
        sum+=amt[i];
    }
    return sum;
    
    }

}
// ---------------------------- end of main code------------------------------------
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
