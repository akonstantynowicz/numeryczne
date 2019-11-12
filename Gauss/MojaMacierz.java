//Anna Konstantynowicz, gr. 3
//Marcin Szczepaniak, gr. 3

import static java.lang.Math.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class MojaMacierz {
    static int N = 4;

    static void G(float[][] A, float[] B) {
        int j;
        float wspolczynnik;
        System.out.println("G dla F, N = " + N);
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
        System.out.println("G dla D, N = " + N);
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

    static void G(Ulamek[][] A, Ulamek[] B) {
        int j;
        Ulamek wspolczynnik;
        System.out.println("G dla U,  N = " + N);
        for (int i = 0; i < N; i++) {

            j = i;
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

    static void PG(float[][] A, float[] B) {
        float max;
        int p;
        int j;
        float wspolczynnik;
        System.out.println("PG dla F, N = " + N);
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
        System.out.println("PG dla D, N = " + N);
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
        System.out.println("PG dla U, N = " + N);
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
        System.out.println("FG dla F, N = " + N);
        int[] Q = new int[N];
        for (int i = 0; i < N; i++) {
            Q[i] = i;
        }
        float max;
        int maxI, maxJ;
        int j;
        float wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = abs(A[i][j]);
            maxI = i;
            maxJ = j;
            for (int k = i + 1; k < N; k++) {
                for (int l = j; l < N; l++) {
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
        float[] wynik = dajWynikFG(A, B, Q);
        return wynik;
    }

    static double[] FG(double[][] A, double[] B) {
        System.out.println("FG dla D, N = " + N);
        int[] Q = new int[N];
        for (int i = 0; i < N; i++) {
            Q[i] = i;
        }
        double max;
        int maxI, maxJ;
        int j;
        double wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = abs(A[i][j]);
            maxI = i;
            maxJ = j;
            for (int k = i + 1; k < N; k++) {
                for (int l = j; l < N; l++) {
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
        double[] wynik = dajWynikFG(A, B, Q);
        return wynik;
    }

    static Ulamek[] FG(Ulamek[][] A, Ulamek[] B) {
        System.out.println("FG dla U, N = " + N);
        int[] Q = new int[N];
        for (int i = 0; i < N; i++) {
            Q[i] = i;
        }
        Ulamek max;
        int maxI, maxJ;
        int j;
        Ulamek wspolczynnik;
        for (int i = 0; i < N; i++) {
            j = i;
            max = A[i][j].abs();
            maxI = i;
            maxJ = j;
            for (int k = i + 1; k < N; k++) {
                for (int l = j; l < N; l++) {
                    if (A[k][l].abs().isGreaterThan(max)) {
                        max = A[k][l].abs();
                        maxI = k;
                        maxJ = l;
                    }
                }
            }
            if (i != maxI) {
                for (int l = 0; l < N; l++) {
                    Ulamek tmp = new Ulamek(A[i][l]);
                    A[i][l] = new Ulamek(A[maxI][l]);
                    A[maxI][l] = new Ulamek(tmp);
                }
                Ulamek tmp = new Ulamek(B[i]);
                B[i] = new Ulamek(B[maxI]);
                B[maxI] = new Ulamek(tmp);
            }
            if (j != maxJ) {
                int tmp = Q[j];
                Q[j] = Q[maxJ];
                Q[maxJ] = tmp;
                for (int l = 0; l < N; l++) {
                    Ulamek tmpr = new Ulamek(A[l][j]);
                    A[l][j] = new Ulamek(A[l][maxJ]);
                    A[l][maxJ] = new Ulamek(tmpr);
                }
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
        Ulamek[] wynik = dajWynikFG(A, B, Q);
        return wynik;
    }

    static float[] dajWynikFG(float[][] A, float[] B, int[] Q) {
        float[] wyniktmp = new float[N];
        float[] wynik = new float[N];
        float[] tmp = new float[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = A[i][j] * wyniktmp[j];
                B[i] = B[i] - tmp[j - 1];
            }
            wyniktmp[i] = B[i] / A[i][i];
        }
        for (int i = 0; i < N; i++) {
            wynik[Q[i]] = wyniktmp[i];
        }
        return wynik;
    }

    static double[] dajWynikFG(double[][] A, double[] B, int[] Q) {
        double[] wyniktmp = new double[N];
        double[] wynik = new double[N];
        double[] tmp = new double[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = A[i][j] * wyniktmp[j];
                B[i] = B[i] - tmp[j - 1];
            }
            wyniktmp[i] = B[i] / A[i][i];
        }
        for (int i = 0; i < N; i++) {
            wynik[Q[i]] = wyniktmp[i];
        }
        return wynik;
    }

    static Ulamek[] dajWynikFG(Ulamek[][] A, Ulamek[] B, int[] Q) {
        Ulamek[] wyniktmp = new Ulamek[N];
        Ulamek[] wynik = new Ulamek[N];
        Ulamek[] tmp = new Ulamek[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = A[i][j].multiply(wyniktmp[j]);
                B[i] = B[i].subtract(tmp[j - 1]);
            }
            wyniktmp[i] = B[i].divide(A[i][i]);
        }
        for (int i = 0; i < N; i++) {
            wynik[Q[i]] = new Ulamek(wyniktmp[i]);
        }
        return wynik;
    }

    static float[] dajWynik(float[][] A, float[] B) {
        float[] wynik = new float[N];
        float[] tmp = new float[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = A[i][j] * wynik[j];
                B[i] = B[i] - tmp[j - 1];
            }
            wynik[i] = B[i] / A[i][i];
        }
        return wynik;
    }

    static double[] dajWynik(double[][] A, double[] B) {
        double[] wynik = new double[N];
        double[] tmp = new double[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = A[i][j] * wynik[j];
                B[i] = B[i] - tmp[j - 1];
            }
            wynik[i] = B[i] / A[i][i];
        }
        return wynik;
    }

    static Ulamek[] dajWynik(Ulamek[][] A, Ulamek[] B) {
        Ulamek[] wynik = new Ulamek[N];
        Ulamek[] tmp = new Ulamek[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                tmp[j - 1] = A[i][j].multiply(wynik[j]);
                B[i] = B[i].subtract(tmp[j - 1]);
            }
            wynik[i] = B[i].divide(A[i][i]);
        }
        return wynik;
    }

    static public float obliczNormę(float[] wektor){
        float norma,suma=0;
        for (int i=0;i<N;i++){
          suma=suma+(float)pow(wektor[i],2);
        }
        norma=(float)sqrt(suma);
        return norma;
    }

    static public double obliczNormę(double[] wektor){
        double norma,suma=0;
        for (int i=0;i<N;i++){
          suma=suma+pow(wektor[i],2);
        }
        norma=sqrt(suma);
        return norma;
    }


    static public Ulamek obliczNormę(Ulamek[] wektor){
        Ulamek suma = new Ulamek(BigInteger.ZERO, BigInteger.ONE);
        for (int i=0;i<N;i++){
            suma = suma.add(wektor[i].multiply(wektor[i]));
        }
        Ulamek norma = suma.sqrt();
        return norma;
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

    public static void main(String[] args) throws IOException {

        //Testy.H1();
        //Testy.E1();

        //E1
//        N = 500;
//        Macierze m1 = new Macierze(N);
//        Macierze m2 = new Macierze(N);
//        Macierze m3 = new Macierze(N);
//
//        m2.kopiujMacierz(m1);
//        m3.kopiujMacierz(m1);
//        System.out.println("==============================");
//
//        long start = System.nanoTime();
//        G(m1.macierzD, m1.wektorD);
//        long elapsedTime = System.nanoTime() - start;
//        System.out.println((double) elapsedTime / 1000000000 );
//
//        long start = System.nanoTime();
//        G(m2.macierzU, m2.wektorU);
//        long elapsedTime = System.nanoTime() - start;
//        System.out.println(elapsedTime);

//        //test poprawnosci
//        Macierze m1 = new Macierze(N);
//        Macierze m2 = new Macierze(N);
//        m2.kopiujMacierz(m1);
//
//        drukujMacierz(m1.macierzF, m1.wektorF);
//        drukujMacierz(m2.macierzF, m2.wektorF);
//
//        G(m1.macierzU, m1.wektorU);
//        Ulamek[] wynik1 = dajWynik(m1.macierzU, m1.wektorU);
//        Ulamek[] wynik2 = FG(m2.macierzU, m2.wektorU);
//
//
//        for (int i=0;i<N;i++){
//			System.out.println("x" + i + "=" + wynik1[i]);
//            System.out.println("x" + i + "=" + wynik2[i]);
//		}


    }
}
