public class CrossCorrelation2 {

    public static double[] crosscorrelation(double[] sig1, double[] sig2){
        int n = sig1.length;
        double[] cross = new double[n];
        double sum = 0.0;

        for(int i = 0; i<n; i++){
            sum =0.0;
            for(int j = i; j<n; j++){
                sum += sig1[j]*sig2[j-i];
                }

            cross[i] = sum;

        }
        return cross;

    }
}
