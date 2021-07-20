public class Fraction {
    private int numerator;             // Fraction numerator
    private int denominator;           // Fraction denominator

    /*-----------------------------------------------------------------
     * constructor
     * Takes no parameters, initializes the object to 0/1
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /*-----------------------------------------------------------------
     * constructor
     * Takes parameter, the numerator, initializes denominator to 1
     * so object is numerator/1
     */
    public Fraction(int num) {
        numerator = num;
        denominator = 1;
    }

    /*-----------------------------------------------------------------
     * constructor
     * If fraction is negative, put negative number in numerator
     */
    public Fraction(int num, int denom) {
        numerator = (denom < 0 ? -num : num);
        if (denom == 0) {
            denominator = 1;
        }
        denominator = (denom < 0 ? -denom : denom);
        //reduce();
    }
	
	/*-----------------------------------------------------------------
	 * constructor
	 * New constructor that reduces the fraction
	 */
    public Fraction(Fraction f) {
        numerator = (f.denominator < 0 ? -f.numerator : f.numerator);
        if (f.denominator == 0) {
            denominator = 1;
        }
        denominator = (f.denominator < 0 ? -f.denominator : f.denominator);
        reduce();
    }

    /*-----------------------------------------------------------------
     * setNumerator
     * numerator is set to be the given parameter
     */
    public void setNumerator(int num) {
        numerator = num;
    }

    /*-----------------------------------------------------------------
     * getNumerator
     * return numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /*-----------------------------------------------------------------
     * setDenominator
     * denominator is set to be the given parameter (zero is ignored),
     * if denominator is negative, numerator is adjusted
     */
    public void setDenominator(int denom) {
        if (denom > 0) {
            denominator = denom;
        }
        else if (denom < 0) {
            numerator = -numerator;
            denominator = -denom;
        }
    }

    /*-----------------------------------------------------------------
     * getDenominator
     * return denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /*-----------------------------------------------------------------
     * addTo
     * add the parameter Fraction to the current object Fraction 
     */
    public Fraction addTo(Fraction rhs) {
        Fraction sum = new Fraction();
        sum.denominator = denominator * rhs.denominator;
        sum.numerator = numerator * rhs.denominator 
                          + denominator * rhs.numerator;
        return sum;
    }

	
    /*-----------------------------------------------------------------
     * subTo
     * subtract the parameter Fraction to the current object Fraction 
     */
    public Fraction subTo(Fraction rhs) {
        Fraction sub = new Fraction();
        sub.denominator = denominator * rhs.denominator;
        sub.numerator = numerator * rhs.denominator 
                          + (denominator * (-rhs.numerator));
        return sub;
    }
	
    /*-----------------------------------------------------------------
     * mulTo
     * multiplicate the parameter Fraction to the current object Fraction 
     */
	public Fraction mulTo(Fraction rhs) {
		Fraction mul = new Fraction();
		mul.denominator = denominator * rhs.denominator;
		mul.numerator = numerator * rhs.numerator;
		
		return mul;
	}		
	
    /*-----------------------------------------------------------------
     * divTo
     * divide the parameter Fraction to the current object Fraction 
     */
	public Fraction divTo(Fraction rhs) {
		Fraction div  = new Fraction();
		div.denominator = denominator * rhs.numerator;
		div.numerator = numerator * rhs.denominator;
		
		return div;
	}	
	
    /*-----------------------------------------------------------------
     * toString
     * convert the Fraction to a String object, e.g., 2/3
     */
    public String toString() {
        if (denominator == 1 || denominator == -1)
			return "" + numerator;
		else
			return numerator + "/" + denominator;
    }

    /*-----------------------------------------------------------------
     * equals
     * compare the parameter Fraction to the current object Fraction
     */
    public boolean equals(Fraction rhs) {
        return (numerator == rhs.numerator) && (denominator == rhs.denominator);
    }

    /*-----------------------------------------------------------------
     * reduce
     * reduce Fraction to lowest terms by finding largest common denominator
     * and dividing it out
     */
    public void reduce() {
        // find the larger of the numerator and denominator
        int n = numerator, d = denominator, largest;
        if (numerator < 0) {
            n = -numerator;
        }
        if (n > d) {
            largest = n;
        }
        else {
            largest = d;
        }

        // find the largest number that divide the numerator and
        // denominator evenly
        int gcd = 0;
        for (int i = largest; i >= 2; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
                break;
            }
        }

        // divide the largest common denominator out of numerator, denominator
        if (gcd != 0) {
            numerator /= gcd;
            denominator /= gcd;
        }
    }
}
