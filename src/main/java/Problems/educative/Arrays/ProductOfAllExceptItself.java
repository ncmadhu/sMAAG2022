package Problems.educative.Arrays;

import Problems.Problem;

import java.util.Arrays;

public class ProductOfAllExceptItself extends Problem {
    @Override
    public void run() {
        System.out.println("Running Product of All Except Itself");
        int[][] input = new int[][]{{0, 1, 2}, {0, 1, 2, 0}, {1, 2, 3, 4}, {2, 5, 9, 3, 6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + Arrays.toString(this.findProduct(input[i])));
        }
    }

    private int[] findProduct(int[] arr) {
        if (arr.length <= 1) return arr;
        int[] product = new int[arr.length];
        int prod = 1;
        for (int i = 0; i < arr.length; i++) {
            product[i] = prod;
            prod *= arr[i];
        }
        prod = 1;
        for (int i =  arr.length-1; i >= 0; i--) {
            product[i] *= prod;
            prod *= arr[i];
        }
        return product;
    }
}
