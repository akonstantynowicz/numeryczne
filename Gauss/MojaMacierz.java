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

    //TODO
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
                    Ulamek tmp = A[i][l];
                    A[i][l] = A[p][l];
                    A[p][l] = tmp;
                }
                Ulamek tmp = B[i];
                B[i] = B[p];
                B[p] = tmp;
            }
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j].divide(A[i][j]);
                for (int l = j; l < N; l++) {
                    Ulamek tmp = A[k][l];
                    A[k][l] = tmp.subtract(wspolczynnik.multiply(A[i][l]));
                }
                B[k] = B[k].subtract(wspolczynnik.multiply(B[i]));
            }
        }
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
                System.out.print(A[i][j]);
                System.out.print(" ");
            }
            System.out.print("| " + B[i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Macierze m = new Macierze();
        
        //test poprawnosci
        float[][] testA = new float[N][N];
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
		}
		
		 /*System.out.println("FLOAT");

        drukujMacierz(m.macierzF, m.wektorF);

        PG(m.macierzF, m.wektorF);

        drukujMacierz(m.macierzF, m.wektorF);*/

       /* System.out.println();
        System.out.println("DOUBLE");

        drukujMacierz(m.macierzD, m.wektorD);

        PG(m.macierzD, m.wektorD);

        drukujMacierz(m.macierzD, m.wektorD);

        System.out.println();
        System.out.println("ULAMEK");*/

        //drukujMacierz(m.macierzU, m.wektorU);

        //PG(m.macierzU, m.wektorU);

        //drukujMacierz(m.macierzU, m.wektorU);

    }
}
