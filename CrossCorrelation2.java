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

    public static void afficheTab(double[] tab){
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static void main(String[] args) {
        double[] sig1 = {0.4, 0.4, 0.2, 0.7, 0.8};
        double[] sig2 = {0.8, 0.9, 0.4, 0.4, 0.2};
        afficheTab(crosscorrelation(sig1, sig2));
    }
    
}
