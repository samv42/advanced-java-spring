package platform.codingnomads.co.javaLogicPuzzles;

    /**
     * N-th Fibonacci number problem
     * Please implement the nthFibonacciNumber function that will return
     * an N-th element of Fibonacci sequence. The main challenge is to
     * solve the problem within time constraint.
     * <p>
     * Fibonacci sequence may be defined by the recurrence relation:
     * fib(0)=0
     * fib(1)=1
     * for n > 1: fib(n) = fib(n-1) + fib(n-2)
     * Sequence start: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
     * <p>
     * You can assume that:
     * - n is zero or a positive integer
     * <p>
     * Runtime is a highly volatile metric, so some of your tests may
     * fail sometimes but pass on subsequent run - it is OK.
     * It also depends on your computer, so if your solution fails
     * but relatively close, you can increase the timeouts.
     * However, the adjustment should be < timeout * 10
     */

    public class Fibonacci {

        private static double fib(int n) {
            // Implement your solution here
            if(n == 0 || n == 1){
                return n;
            }

            double last = 1;
            double nextLast = 0;
            double num = 0;

            for(int count = 1; count != n; count++){
                num = last + nextLast;
                nextLast = last;
                last = num;
            }
            return num;
            // Don't forget to remove the Exception
            //throw new RuntimeException("Not implemented");
        }

        public static void main(String[] args) {

            // Warmup JMV to measure true runtime of the app rather than JVM.
            warmup();

            test(0, 0, 1000);
            test(1, 1, 1000);
            test(2, 1, 1000);
            test(3, 2, 1000);
            test(4, 3, 1000);
            test(5, 5, 1000);
            test(6, 8, 1000);
            test(7, 13, 1000);
            test(8, 21, 1000);
            test(9, 34, 1000);
            test(10, 55, 1000);
            test(20, 6765, 1000);
            test(30, 832040, 1500);
            test(50, 12586269025d, 1500);
            test(60, 1548008755920d, 2000);
            test(70, 190392490709135d, 2500);
            test(80, 23416728348467685d, 3000);

        }


        // Add colors to the tests output
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        private static void test(int n, double expected, int timeout) {
            try {
                long startTime = System.nanoTime();
                double actual = fib(n);
                long stopTime = System.nanoTime();

                System.out.printf("Test: '%s' expected: %.0f actual: %.0f", n, expected, actual);
                if (actual == expected) {
                    System.out.print(ANSI_GREEN + " - pass" + ANSI_RESET);
                } else {
                    System.out.print(ANSI_RED + " - fail" + ANSI_RESET);
                }

                System.out.printf(".  Runtime expected: %,d actual: %,d ", timeout, stopTime - startTime);
                if (stopTime - startTime < timeout) {
                    System.out.println(ANSI_GREEN + " - pass" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED + " - fail" + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.printf("Test: '%s' " + ANSI_RED + "- fail with exception: " + ANSI_RESET + "\n", n);
                System.out.println(e);
            }
        }

        private static void warmup() {
            System.out.println("Warmup JVM (should improve timings of the first run)");
            for (int i = 0; i < 3; i++) {
                try {
                    long startTime = System.nanoTime();
                    double result = fib(i);
                    long stopTime = System.nanoTime();
                    System.out.printf("Fibonacci Number: %d, result: %.0f, runtime: %,d \n", i, result, stopTime - startTime);
                } catch (Exception e) {
                }
            }
            System.out.println();
        }
    }
