//Anna Konstantynowicz, gr. 3
//Marcin Szczepaniak, gr. 3

import static java.lang.Math.*;

import java.util.Random;

public class MojaMacierz {
    static int N = 10;

    static void G(float[][] A, float[] B) {
        int p;
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
            for (int k = i + 1; k < N; k++) {
                wspolczynnik = A[k][j] / A[i][j];
                for (int l = j; l < N; l++) {
                    double tmp = A[k][l];
                    A[k][l] = tmp - (wspolczynnik * A[i][l]);
                }
                B[k] = B[k] - (wspolczynnik * B[i]);
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

    public static void main(String[] args) {

        Macierze m = new Macierze();

        System.out.println("FLOAT");

        drukujMacierz(m.macierzF, m.wektorF);

        PG(m.macierzF, m.wektorF);

        drukujMacierz(m.macierzF, m.wektorF);

        System.out.println();
        System.out.println("DOUBLE");

        drukujMacierz(m.macierzD, m.wektorD);

        PG(m.macierzD, m.wektorD);

        drukujMacierz(m.macierzD, m.wektorD);

    }
}
