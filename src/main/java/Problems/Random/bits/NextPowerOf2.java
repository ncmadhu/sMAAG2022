package Problems.Random.bits;

import Problems.Problem;

public class NextPowerOf2 extends Problem {

    @Override
    public void run() {
        System.out.println("Running Next Power of 2");
        int[] input = new int[]{4,5,6,7,8,9};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output (Log): " + this.nextPowerOf2ByLog(input[i]));
            System.out.println("Output (Bit): " + this.nextPowerOf2ByBit(input[i]));
        }
    }

    private int nextPowerOf2ByBit(int n) {
        // If n is power of 2, bitwise and results in 0
        if (n > 0 && (n & (n-1)) == 0) return n;
        int count = 0;
        while (n != 0) {
            n = n >> 1;
            count += 1;
        }
        // This sets the bit at next power of 2
        return 1 << count;
    }

    private int nextPowerOf2ByLog(int n) {
        // log in Math calculates to the base e
        // log n to the base 2 == log n to the base e / log 2 to the base e
        return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
    }
}
