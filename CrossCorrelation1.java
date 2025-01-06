public class CrossCorrelation1 {

    public static double[] crosscorrelation(double[] sig1, double[] sig2){
        int n = sig2.length;
        double[] cross = new double[n];
        double [] sig3 = new double[n];
        double sum = 0.0;
        int gap =0;

        for (int t=0; t<n; t++) {

            for (int k=0; k<n; k++){
                while (k<gap){
                    sig3[k]=0.0;
                    k++;
                }

                sig3[k]=sig2[k-gap];

            }
            gap= gap +1;

            for (int j=0; j<n; j++) {
                sum += sig1[j]*sig3[j];
            }

            cross[t] = sum;
            sum = 0.0;

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
