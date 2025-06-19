public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double currentValue, double rate, int years) {
        if (years == 0) return currentValue;
        return futureValue(currentValue * (1 + rate), rate, years - 1);
    }

    // Optimized with memoization (if needed for larger inputs)
    public static double memoizedFutureValue(double currentValue, double rate, int years, double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = memoizedFutureValue(currentValue * (1 + rate), rate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double present = 1000.0;
        double rate = 0.10; // 10% growth rate
        int years = 5;

        double result = futureValue(present, rate, years);
        System.out.printf("Predicted Value after %d years: Rs.%.2f\n", years, result);

        // Optional: Memoized version (for large `years`)
        double[] memo = new double[years + 1];
        double optimizedResult = memoizedFutureValue(present, rate, years, memo);
        System.out.printf("Memoized Value: Rs.%.2f\n", optimizedResult);
    }
}
