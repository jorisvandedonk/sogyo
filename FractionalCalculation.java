public class FractionalCalculation {
    public static void main(String[] args) {
        Fraction fractionOneThird = new Fraction(1, 3);
        Fraction fractionOneSixth = new Fraction(1, 6);
        Fraction fractionFourThird = new Fraction(4, 3);
        Fraction fractionOneSecond = new Fraction(1, 2);
        Fraction fractionThreeFourth = new Fraction(3, 4);
        Fraction fractionTwoFifth = new Fraction(2, 5);
        Fraction fractionThreeSecond = new Fraction(3, 2);
        Fraction fractionThreeTenth = new Fraction(3, 10);

        double decimalValue = fractionOneThird.toDecimalNotation();
        System.out.println(decimalValue);

        String fractionString = fractionOneThird.toString();
        System.out.println(fractionString);

        Fraction fractionPlusNumber = fractionOneThird.add(1).simplify();
        System.out.println(fractionPlusNumber);

        Fraction fractionPlusFraction = fractionOneThird.add(fractionOneSixth).simplify();
        System.out.println(fractionPlusFraction);

        Fraction fractionMinusNumber = fractionFourThird.subtract(1).simplify();
        System.out.println(fractionMinusNumber);

        Fraction fractionMinusFraction = fractionOneSecond.subtract(fractionOneSixth).simplify();
        System.out.println(fractionMinusFraction);

        Fraction fractionTimesNumber = fractionThreeFourth.multiply(2).simplify();
        System.out.println(fractionTimesNumber);

        Fraction fractionTimesFraction = fractionThreeFourth.multiply(fractionTwoFifth).simplify();
        System.out.println(fractionTimesFraction);

        Fraction fractionDividedByNumber = fractionThreeSecond.divide(2).simplify();
        System.out.println(fractionDividedByNumber);

        Fraction fractionDividedByFraction = fractionThreeTenth.divide(fractionTwoFifth).simplify();
        System.out.println(fractionDividedByFraction);
    }
}

final class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int n, int d) {
        numerator = n;
        denominator = d;
    }

    public double toDecimalNotation() {
        return (double) numerator / (double) denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction add(int number) {
        int newNumerator = numerator + (number * denominator);
        return new Fraction(newNumerator, denominator);
    }

    public Fraction add(Fraction fraction) {
        int newNumerator = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(int number) {
        int newNumerator = numerator - (number * denominator);
        return new Fraction(newNumerator, denominator);
    }

    public Fraction subtract(Fraction fraction) {
        int newNumerator = (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator);
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(int number) {
        int newNumerator = numerator * number;
        return new Fraction(newNumerator, denominator);
    }

    public Fraction multiply(Fraction fraction) {
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(int number) {
        int newDenominator = denominator * number;
        return new Fraction(numerator, newDenominator);
    }

    public Fraction divide(Fraction fraction) {
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = this.denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction simplify() {
        int gcd = findGCD(numerator, denominator);
        int simplifiedNumerator = numerator / gcd;
        int simplifiedDenominator = denominator / gcd;
        return new Fraction(simplifiedNumerator, simplifiedDenominator);
    }

    private static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
