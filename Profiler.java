public class Profiler {

    static long globalTime;
    static int totalCallCount;

    @FunctionalInterface
    interface tabDouble2Consumer {
        double[] apply(double[] sig1, double[] sig2);
    }

    public static double[] analyse(tabDouble2Consumer oneMethod, double[] sig1, double[] sig2) {
        // start chrono
        long startTime = System.nanoTime();
        // appel à la méthode
        double[] cross = oneMethod.apply(sig1, sig2);
        // stop chrono
        globalTime += timestamp() - startTime;
        totalCallCount++;
        return cross;
    }

    public static void init(){
        globalTime = 0;
        totalCallCount = 0;
    }

    public static void printResult(){
        double elapsed = 0;
        String unit = "s";
        if (globalTime > 0) {
            elapsed = globalTime / 1e9;
            if (elapsed < 1.0) {
                elapsed *= 1000.0;
                unit = "ms";
            }
            String result = String.format("%.4g%s elapsed", elapsed, unit);
            System.out.println(result);
        }
        System.out.println("Total call count: " + totalCallCount);
        System.out.println("Average runtime: " + elapsed/totalCallCount + unit);
    }

    /**
     * retourne l'heure courante en ns.
     * @return
     */
    public static long timestamp() {
        return System.nanoTime();
    }

}
