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
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Write your code here
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> part = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        part = arr.subList(0,d);
        temp = arr.subList(d,arr.size());
        result.addAll(temp);
        result.addAll(part);
        return result;
        /*for(int i=0; i<d; i++){
            temp.add(arr.get(i));
        }
        System.out.println("temp = " +temp);
        int j=0;
        for(int i=d; i<arr.size(); i++){
            arr.set(j, arr.get(i));
            j++;
        }
        j=0;
        for(int i=arr.size()-d; i<temp.size(); i++){
            arr.set(i, temp.get(j));
            j++;
        }
        return arr;*/
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotateLeft(d, arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
