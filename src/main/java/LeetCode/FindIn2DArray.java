package LeetCode;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    //主要思想就是二叉搜索树 BinarySearch
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] < target)
            {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }
}

public class FindIn2DArray {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JSONArray jsonArray = new JSONArray(input);
        if (jsonArray.length() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.length()][];
        for (int i = 0; i < arr.length; i++) {
            JSONArray cols = jsonArray.getJSONArray(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            boolean ret = new Solution().findNumberIn2DArray(matrix, target);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
