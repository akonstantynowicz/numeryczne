//Marcin Szczepaniak, gr. 3
//Anna Konstantynowicz gr. 3

import java.util.Random;

public class Macierze {

    public static int N=4;

    public float[][] macierzF;
    public double[][] macierzD;
    public Ulamek[][] macierzU;

    public float[] wektorF;
    public double[] wektorD;
    public Ulamek[] wektorU;

    public Macierze() {
        macierzF = new float[N][N];
        macierzD = new double[N][N];
        macierzU = new Ulamek[N][N];

        wektorF = new float[N];
        wektorD = new double[N];
        wektorU = new Ulamek[N];

        losujMacierz();
        losujWektor();
    }

    static int losujR(){
        Random ran = new Random();
        int r = ran.nextInt(131071)-65536;
        return r;
    }

    public void losujMacierz() {
        int r;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                r = losujR();
                macierzF[i][j] = (float) r/65536;
                macierzD[i][j] = (double) r/65536;
                macierzU[i][j] = new Ulamek((double) r/65536);
            }
        }
    }

    public void losujWektor() {
        int r;
        for (int i=0;i<N;i++){
            r = losujR();
            wektorF[i]= (float) r/65536;
            wektorD[i]= (double) r/65536;
            wektorU[i]= new Ulamek((double) r/65536);
        }
    }
}
