//Marcin Szczepaniak, gr. 3
//Anna Konstantynowicz gr. 3

import java.util.Random;

public class Macierze {

    public int N;

    public float[][] macierzF;
    public double[][] macierzD;
    public Ulamek[][] macierzU;

    public float[] wektorXF;
    public double[] wektorXD;
    public Ulamek[] wektorXU;

    public float[] wektorF;
    public double[] wektorD;
    public Ulamek[] wektorU;

    public Macierze(int N) {
        this.N = N;
        macierzF = new float[N][N];
        macierzD = new double[N][N];
        macierzU = new Ulamek[N][N];

        wektorXF = new float[N];
        wektorXD = new double[N];
        wektorXU = new Ulamek[N];

        wektorF = new float[N];
        wektorD = new double[N];
        wektorU = new Ulamek[N];

        losujMacierz();
        losujWektorX();
        obliczWektor();
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

    public void losujWektorX() {
        int r;
        for (int i=0;i<N;i++){
            r = losujR();
            wektorXF[i]= (float) r/65536;
            wektorXD[i]= (double) r/65536;
            wektorXU[i]= new Ulamek((double) r/65536);
        }
    }

    public void obliczWektor(){
      for (int i=0;i<N;i++) {
          for (int j=0;j<N;j++){
            wektorF[i] = wektorF[i] + macierzF[i][j]*wektorXF[j];
            wektorD[i] = wektorD[i] + macierzD[i][j]*wektorXD[j];
            //wektorU[i] = wektorU[i] + macierzU[i][j]*wektorXU[i];
          }
      }
    }

    public void kopiujMacierz(Macierze m) {
        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                this.macierzF[i][j] = m.macierzF[i][j];
                this.macierzD[i][j] = m.macierzD[i][j];
                this.macierzU[i][j] = m.macierzU[i][j];

                this.wektorF[i] = m.wektorF[i];
                this.wektorD[i] = m.wektorD[i];
                this.wektorU[i] = m.wektorU[i];
            }
        }
    }
}
