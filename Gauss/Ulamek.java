//Marcin Szczepaniak, gr. 3
//Anna Konstantynowicz, gr. 3

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

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

    public Ulamek(Ulamek u) {
        this.licznik = u.licznik;
        this.mianownik = u.mianownik;
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
            mianownik = BigInteger.ONE;
        }
        if (gcd.equals(BigInteger.ZERO) == false) {
            licznik = licznik.divide(gcd);
            mianownik = mianownik.divide(gcd);
        }
        if (mianownik.compareTo(BigInteger.ZERO) == -1) {
            licznik = licznik.negate();
            mianownik = mianownik.negate();
        }
    }

    public Ulamek subtract(Ulamek u) {
        Ulamek uu = new Ulamek();
        BigInteger m = this.mianownik;

        this.licznik = this.licznik.multiply(u.mianownik);
        this.mianownik = this.mianownik.multiply(u.mianownik);
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

    public double toDouble() {
        if (licznik == BigInteger.ZERO) {
            return 0;
        }
        else {
            return licznik.doubleValue() / mianownik.doubleValue();
        }
    }

    public String toStringUlamek() {
        return licznik + "/" + mianownik;
    }

    @Override
    public String toString() {
        return "" + this.toDouble();
    }
}
