import java.util.LinkedList;

public class Fraction {
    private int num;
    private int den;

    public Fraction(int a, int b) {
        num = a;
        den = b;
    }

    public Fraction(int a) {
        num = a;
        den = 1;
    }

    public Fraction addTo(Fraction f) {
        return new Fraction(this.num*f.den + f.num*this.den, this.den*f.den);
    }

    public Fraction subTo(Fraction f) {
        return new Fraction(this.num*f.den - f.num*this.den, this.den*f.den);
    }

    public Fraction multTo(Fraction f) {
        return new Fraction(this.num*f.num, this.den*f.den);
    }

    public Fraction divTo(Fraction f) {
        return new Fraction(this.num*f.den, this.den*f.num);
    }

    public Fraction negFrac() {
        return new Fraction(-this.num, this.den);
    }

    public Fraction reduce() {
        int n = mdc(this.num, this.den);
        return new Fraction(this.num/n, this.den/n);
    }

    public int mdc(int a, int b) {
        if (b == 0) return a;
        return mdc(b, a%b);
    }

    public int getNumerator() {
        return this.num;
    }

    @Override public String toString() {
        if (this.den != 1) {
            if (this.num < 0 && this.den < 0)
                if (-this.den != 1)
                    return "" + -this.num + "/" + -this.den;
                else
                    return "" + this.num;
            else
                return "" + this.num + "/" + this.den;
        }

        return "" + this.num;
    }
}
