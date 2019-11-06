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
        if (licznik.equals(BigInteger.ZERO)) {
            mianownik = BigInteger.ZERO;
        }
        if (gcd.equals(BigInteger.ZERO) == false) {
            licznik = licznik.divide(gcd);
            mianownik = mianownik.divide(gcd);
        }

    }

    public Ulamek subtract(Ulamek u) {
        Ulamek uu = new Ulamek();
        BigInteger m = this.mianownik;

        this.licznik = this.licznik.multiply(u.mianownik);
        this.mianownik = this.licznik.multiply(u.mianownik);
        u.licznik = u.licznik.multiply(m);
        u.mianownik = u.mianownik.multiply(m);

        uu.licznik = this.licznik.subtract(u.licznik);
        uu.mianownik = this.mianownik;

        this.skroc();
        u.skroc();
        uu.skroc();

        return uu;
    }

    public Ulamek multiply(Ulamek u) {
        Ulamek uu = new Ulamek();
        uu.licznik = this.licznik.multiply(u.licznik);
        uu.mianownik = this.mianownik.multiply(u.mianownik);
        uu.skroc();

        return uu;
    }

    public Ulamek divide(Ulamek u) {
        Ulamek uu = new Ulamek();
        uu.licznik = this.licznik.multiply(u.mianownik);
        uu.mianownik = this.mianownik.multiply(u.licznik);
        uu.skroc();

        return uu;
    }

    public Ulamek abs() {
        return new Ulamek(licznik.abs(), mianownik);
    }

    public boolean isGreaterThan(Ulamek u) {
        BigInteger y = this.licznik.multiply(u.mianownik).subtract(this.mianownik.multiply(u.licznik));

        return (y.compareTo(BigInteger.ZERO) == 1) ? true : false;
    }

    public boolean equals(Ulamek u) {
        this.skroc();
        u.skroc();

        if (this.licznik.equals(u.licznik) && this.mianownik.equals(u.mianownik)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return licznik + "/" + mianownik;
    }
}
