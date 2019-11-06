//Marcin Szczepaniak, gr. 3

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ulamek {

    private BigInteger licznik;
    private BigInteger mianownik;

    public Ulamek() { }

    public Ulamek(float x) {
        this(Double.valueOf(x));
    }

    //https://algorithms.tutorialhorizon.com/convert-decimal-into-irreducible-fraction/
    public Ulamek(double x) {
        String a = "" + x;
        String spilts[] = a.split("\\."); // split using decimal
        int b = spilts[1].length(); // find the decimal length
        mianownik = BigDecimal.valueOf(Math.pow(10, b)).toBigInteger();
        licznik =  BigDecimal.valueOf(x * Math.pow(10, b)).toBigInteger();
        skroc();
    }

    public Ulamek(BigInteger licznik, BigInteger mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
        skroc();
    }

    public void skroc() {
        BigInteger gcd = mianownik.gcd(licznik);
        licznik = licznik.divide(gcd);
        mianownik = mianownik.divide(gcd);
    }

    @Override
    public String toString() {
        return licznik + "/" + mianownik;
    }
}
