import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.*;

public class Testy {
    public static void H1() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiH1_2.txt"));
        int N;

        for (int i = 5; i <= 100; i = i + 5) {

            MojaMacierz.N = i;
            N = MojaMacierz.N;

            Macierze m1 = new Macierze(N);
            Macierze m2 = new Macierze(N);
            Macierze m3 = new Macierze(N);

            m2.kopiujMacierz(m1);
            m3.kopiujMacierz(m1);

            System.out.println("N = " + N);
            String dataLine = N + " / ";

            long start = System.nanoTime();
            MojaMacierz.G(m1.macierzU, m1.wektorU);
            MojaMacierz.dajWynik(m1.macierzU, m1.wektorU);
            long elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            start = System.nanoTime();
            MojaMacierz.PG(m2.macierzU, m2.wektorU);
            MojaMacierz.dajWynik(m2.macierzU, m2.wektorU);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
            System.out.println((double) elapsedTime / 1000000000);

            start = System.nanoTime();
            MojaMacierz.FG(m3.macierzU, m3.wektorU);
            elapsedTime = System.nanoTime() - start;
            dataLine = dataLine + (double) elapsedTime / 1000000000;
            System.out.println((double) elapsedTime / 1000000000);

            writer.write(dataLine);
            writer.write("\n");
        }
        writer.close();
    }

    public static void E1() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiE1.txt"));

        MojaMacierz.N = 500;
        int N = MojaMacierz.N;

        Macierze m1 = new Macierze(N);
        Macierze m2 = new Macierze(N);
        Macierze m3 = new Macierze(N);

        m2.kopiujMacierz(m1);
        m3.kopiujMacierz(m1);

        System.out.println("N = " + N);
        String dataLine = N + " / ";

        //G F
        long start = System.nanoTime();
        MojaMacierz.G(m1.macierzF, m1.wektorF);
        MojaMacierz.dajWynik(m1.macierzF, m1.wektorF);
        long elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //G D
        start = System.nanoTime();
        MojaMacierz.G(m1.macierzD, m1.wektorD);
        MojaMacierz.dajWynik(m1.macierzD, m1.wektorD);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //G U
        start = System.nanoTime();
        MojaMacierz.G(m1.macierzU, m1.wektorU);
        MojaMacierz.dajWynik(m1.macierzU, m1.wektorU);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //PG F
        start = System.nanoTime();
        MojaMacierz.PG(m2.macierzF, m2.wektorF);
        MojaMacierz.dajWynik(m2.macierzF, m2.wektorF);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //PG D
        start = System.nanoTime();
        MojaMacierz.PG(m2.macierzD, m2.wektorD);
        MojaMacierz.dajWynik(m2.macierzD, m2.wektorD);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //PG U
        start = System.nanoTime();
        MojaMacierz.PG(m2.macierzU, m2.wektorU);
        MojaMacierz.dajWynik(m2.macierzU, m2.wektorU);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //FG F
        start = System.nanoTime();
        MojaMacierz.FG(m3.macierzF, m3.wektorF);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //FG D
        start = System.nanoTime();
        MojaMacierz.FG(m3.macierzD, m3.wektorD);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000 + " / ";
        System.out.println((double) elapsedTime / 1000000000);

        //FG U
        start = System.nanoTime();
        MojaMacierz.FG(m3.macierzU, m3.wektorU);
        elapsedTime = System.nanoTime() - start;
        dataLine = dataLine + (double) elapsedTime / 1000000000;
        System.out.println((double) elapsedTime / 1000000000);

        writer.write(dataLine);
        writer.write("\n");
        writer.close();
    }
    public static void H2() throws IOException {

      BufferedWriter writer = new BufferedWriter(new FileWriter("gaussWynikiH2G.txt"));
      BufferedWriter writer1 = new BufferedWriter(new FileWriter("gaussWynikiH2PG.txt"));
      BufferedWriter writer2 = new BufferedWriter(new FileWriter("gaussWynikiH2FG.txt"));

      MojaMacierz.N = 20;
      int N = MojaMacierz.N;
      double dataLine;
      Macierze m1 = new Macierze(N);
      Macierze m2 = new Macierze(N);
      Macierze m3 = new Macierze(N);

      m2.kopiujMacierz(m1);
      m3.kopiujMacierz(m1);

      for (int i=0;i<100000;i++){
        MojaMacierz.G(m1.macierzD,m1.wektorD);
        MojaMacierz.PG(m2.macierzD,m2.wektorD);
        dataLine = abs(MojaMacierz.obliczNorme(m1.wektorXD)-MojaMacierz.obliczNorme(MojaMacierz.dajWynik(m1.macierzD,m1.wektorD)))/MojaMacierz.obliczNorme(m1.wektorXD);
        writer.write(String.valueOf(dataLine));
        writer.write("\n");
        dataLine = abs(MojaMacierz.obliczNorme(m2.wektorXD)-MojaMacierz.obliczNorme(MojaMacierz.dajWynik(m2.macierzD,m2.wektorD)))/MojaMacierz.obliczNorme(m2.wektorXD);
        writer1.write(String.valueOf(dataLine));
        writer1.write("\n");
        dataLine = abs(MojaMacierz.obliczNorme(m3.wektorXD)-MojaMacierz.obliczNorme(MojaMacierz.FG(m3.macierzD,m3.wektorD)))/MojaMacierz.obliczNorme(m3.wektorXD);
        writer2.write(String.valueOf(dataLine));
        writer2.write("\n");

        m1.losujMacierz();
        m1.losujWektorX();
        m1.obliczWektor();
        m2.kopiujMacierz(m1);
        m3.kopiujMacierz(m1);
      }
      writer.close();
      writer1.close();
      writer2.close();
    }
}
