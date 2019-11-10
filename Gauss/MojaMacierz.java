//Anna Konstantynowicz, gr. 3
//Marcin Szczepaniak, gr. 3

import static java.lang.Math.*;

import java.util.Random;

public class MojaMacierz {
    static int N = 4;

    static void G(float[][] A, float[] B) {
        int j;
        float wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    float tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
            }
        }
    }

    static void G(double[][] A, double[] B) {
        int j;
        double wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    double tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
            }
        }
    }

    static void PG(float[][] A, float[] B) {
        float max;
        int p;
        int j;
        float wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = abs(A[i][j]);
            p = i;
            for (int k = i + 1; k < N; k++) {
                if (abs(A[k][j]) > max) {
                    max = abs(A[k][j]);
                    p = k;
                }
            }
            if (A[i][j] != max) {
                for (int l = 0; l < N; l++) {
                    float tmp = A[i][l];
                    A[i][l] = A[p][l];
                    A[p][l] = tmp;
                }
                float tmp = B[i];
                B[i] = B[p];
                B[p] = tmp;
            }
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    float tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
            }
        }
    }

    static void PG(double[][] A, double[] B) {
        double max;
        int p;
        int j;
        double wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = abs(A[i][j]);
            p = i;
            for (int k = i + 1; k < N; k++) {
                if (abs(A[k][j]) > max) {
                    max = abs(A[k][j]);
                    p = k;
                }
            }
            if (A[i][j] != max) {
                for (int l = 0; l < N; l++) {
                    double tmp = A[i][l];
                    A[i][l] = A[p][l];
                    A[p][l] = tmp;
                }
                double tmp = B[i];
                B[i] = B[p];
                B[p] = tmp;
            }
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    double tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
            }
        }
    }

    static void PG(Ulamek[][] A, Ulamek[] B) {
        Ulamek max;
        int p;
        int j;
        Ulamek wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = A[i][j].abs();
            p = i;
            for (int k = i + 1; k < N; k++) {
                if (A[k][j].abs().isGreaterThan(max)) {
                    max = A[k][j].abs();
                    p = k;
                }
            }
            if (A[i][j].equals(max) == false) {
                for (int l = 0; l < N; l++) {
                    Ulamek tmp = new Ulamek(A[i][l]);
                    A[i][l] = new Ulamek(A[p][l]);
                    A[p][l] = new Ulamek(tmp);
                }
                Ulamek tmp = new Ulamek(B[i]);
                B[i] = new Ulamek(B[p]);
                B[p] = new Ulamek(tmp);
            }
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j].divide(A[i][j]);
                for (int l = j; l < N; l++) {
                    Ulamek tmp = new Ulamek(A[k][l]);
                    A[k][l] = tmp.subtract(wspolczynnik.multiply(A[i][l]));
                }
                B[k] = B[k].subtract(wspolczynnik.multiply(B[i]));
            }
        }
    }

    static float[] FG(float[][] A, float[] B) {
        int[] Q = new int[N];
        for(int i=0;i<N;i++){
          Q[i]=i;
        }
        float max;
        int maxI,maxJ;
        int j;
        float wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = abs(A[i][j]);
            maxI = i;
            maxJ = j;
            for (int k = i + 1; k < N; k++) {
              for (int l= j; l<N;l++){
                if (abs(A[k][l]) > max) {
                  max = abs(A[k][l]);
                  maxI = k;
                  maxJ = l;
                }
              }
            }
            if (i != maxI) {
                for (int l = 0; l < N; l++) {
                    float tmp = A[i][l];
                    A[i][l] = A[maxI][l];
                    A[maxI][l] = tmp;
                }
                float tmp = B[i];
                B[i] = B[maxI];
                B[maxI] = tmp;
            }
            if (j != maxJ) {
              int tmp = Q[j];
              Q[j] = Q[maxJ];
              Q[maxJ] = tmp;
                for (int l = 0; l < N; l++) {
                    float tmpr = A[l][j];
                    A[l][j] = A[l][maxJ];
                    A[l][maxJ] = tmpr;
                }
            }
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    float tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
            }
        }
        float[] wynik = dajWynikFG(A,B,Q);
        return wynik;
    }

    static double[] FG(double[][] A, double[] B) {
        int[] Q = new int[N];
        for(int i=0;i<N;i++){
          Q[i]=i;
        }
        double max;
        int maxI,maxJ;
        int j;
        double wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = abs(A[i][j]);
            maxI = i;
            maxJ = j;
            for (int k = i + 1; k < N; k++) {
              for (int l= j; l<N;l++){
                if (abs(A[k][l]) > max) {
                  max = abs(A[k][l]);
                  maxI = k;
                  maxJ = l;
                }
              }
            }
            if (i != maxI) {
                for (int l = 0; l < N; l++) {
                    double tmp = A[i][l];
                    A[i][l] = A[maxI][l];
                    A[maxI][l] = tmp;
                }
                double tmp = B[i];
                B[i] = B[maxI];
                B[maxI] = tmp;
            }
            if (j != maxJ) {
              int tmp = Q[j];
              Q[j] = Q[maxJ];
              Q[maxJ] = tmp;
                for (int l = 0; l < N; l++) {
                    double tmpr = A[l][j];
                    A[l][j] = A[l][maxJ];
                    A[l][maxJ] = tmpr;
                }
            }
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    double tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
            }
        }
        double[] wynik = dajWynikFG(A,B,Q);
        return wynik;
    }

    static float[] dajWynik(float[][] A, float[] B) {
		float[] wynik = new float[N];
		float[] tmp = new float[N-1];
		for (int i=N-1;i>=0;i--){
			for (int j=N-1;j>i;j--){
				tmp[j-1] = A[i][j]*wynik[j];
				B[i]=B[i]-tmp[j-1];
			}
			wynik[i]=B[i]/A[i][i];
		}
		return wynik;
	}

  static float[] dajWynikFG(float[][] A, float[] B,int[] Q) {
  float[] wyniktmp = new float[N];
  float[] wynik = new float[N];
  float[] tmp = new float[N-1];
  for (int i=N-1;i>=0;i--){
    for (int j=N-1;j>i;j--){
      tmp[j-1] = A[i][j]*wyniktmp[j];
      B[i]=B[i]-tmp[j-1];
    }
    wyniktmp[i]=B[i]/A[i][i];
  }
  for (int i=0;i<N;i++){
      wynik[Q[i]]=wyniktmp[i];
  }
  return wynik;
  }

  static double[] dajWynikFG(double[][] A, double[] B,int[] Q) {
  double[] wyniktmp = new double[N];
  double[] wynik = new double[N];
  double[] tmp = new double[N-1];
  for (int i=N-1;i>=0;i--){
    for (int j=N-1;j>i;j--){
      tmp[j-1] = A[i][j]*wyniktmp[j];
      B[i]=B[i]-tmp[j-1];
    }
    wyniktmp[i]=B[i]/A[i][i];
  }
  for (int i=0;i<N;i++){
      wynik[Q[i]]=wyniktmp[i];
  }
  return wynik;
  }

	 static double[] dajWynik(double[][] A, double[] B) {
		double[] wynik = new double[N];
		double[] tmp = new double[N-1];
		for (int i=N-1;i>=0;i--){
			for (int j=N-1;j>i;j--){
				tmp[j-1] = A[i][j]*wynik[j];
				B[i]=B[i]-tmp[j-1];
			}
			wynik[i]=B[i]/A[i][i];
		}
		return wynik;
	}

    static void drukujMacierz(float[][] A, float[] B) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.format("%14.10f", A[i][j]);
                System.out.print(" ");
            }
            System.out.print("| " + B[i]);
            System.out.println();
        }
        System.out.println();
    }

    static void drukujMacierz(double[][] A, double[] B) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.format("%20.16f", A[i][j]);
                System.out.print(" ");
            }
            System.out.print("| " + B[i]);
            System.out.println();
        }
        System.out.println();
    }

    static void drukujMacierz(Ulamek[][] A, Ulamek[] B) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.format("%20.16f", A[i][j].toDouble());
                System.out.print(" ");
            }
            System.out.print("| " + B[i].toDouble());
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Macierze m = new Macierze();

        PG(m.macierzD, m.wektorD);
        double[] wynik1 = dajWynik(m.macierzD,m.wektorD);
        drukujMacierz(m.macierzF, m.wektorF);
        float[] wynik = FG(m.macierzF,m.wektorF);
        for (int i=0;i<N;i++){
			       System.out.println("x" + i + "=" + wynik[i]);
		    }
        System.out.println();
        for (int i=0;i<N;i++){
			       System.out.println("x" + i + "=" + wynik1[i]);
		    }

        //test poprawnosci
      /*  float[][] testA = new float[N][N];
        for (int i=0;i<N;i++){
			for (int j=0;j<N;j++){
				testA[i][j] = 1;
			}
		}
		testA[1][1]=-1;
		testA[2][1]=-1;
		testA[2][2]=-1;
		testA[3][0]=2;
		testA[3][3]=-1;

		float[] testB= new float[N];
		testB[0]=2;
		testB[1]=-2;
		testB[2]=-2;
		testB[3]=5;

		System.out.println("TEST POPRAWNOSCI");
		drukujMacierz(testA, testB);
		PG(testA,testB);
		drukujMacierz(testA,testB);
        float[] wynik = dajWynik(testA, testB);

        for (int i=0;i<N;i++){
			System.out.println("x" + i + "=" + wynik[i]);
		}*/

		 /*System.out.println("FLOAT");

        drukujMacierz(m.macierzF, m.wektorF);

        PG(m.macierzF, m.wektorF);

        drukujMacierz(m.macierzF, m.wektorF);*/

        /*System.out.println();
        System.out.println("DOUBLE");

        drukujMacierz(m.macierzD, m.wektorD);

        PG(m.macierzD, m.wektorD);

        drukujMacierz(m.macierzD, m.wektorD);

        System.out.println();
        System.out.println("ULAMEK");

        drukujMacierz(m.macierzU, m.wektorU);

        PG(m.macierzU, m.wektorU);

        drukujMacierz(m.macierzU, m.wektorU);

        Ulamek u = new Ulamek(0.5);
        System.out.println(u);
        Ulamek uu = new Ulamek(-0.6);
        System.out.println(uu);
        System.out.println(u.subtract(uu));
        System.out.println(u.divide(uu));
        System.out.println(u);
        System.out.println(uu);
        System.out.println(u.multiply(uu));*/

    }
}
