
public class RationalNumber {
    public static void main(String[] args) {
        RationalNumber rationalNumber = new RationalNumber(2, 1);

        RationalNumber rationalNumber2 = new RationalNumber(2, 1);

        System.out.println(rationalNumber+" + "+rationalNumber2+"的结果为:"+rationalNumber.add(rationalNumber2));
        System.out.println(rationalNumber+" - "+rationalNumber2+"的结果为:"+rationalNumber.subtract(rationalNumber2));
        System.out.println(rationalNumber+" * "+rationalNumber2+"的结果为:"+rationalNumber.multiply(rationalNumber2));
        System.out.println(rationalNumber+" / "+rationalNumber2+"的结果为:"+rationalNumber.divide(rationalNumber2));
    }

    private long numerator;
    private long denominator;

    public RationalNumber(long numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public RationalNumber(long denominator, long numerator) {
        if (denominator == 0) throw new ArithmeticException("分母不能为0。");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public RationalNumber(RationalNumber i) {
        numerator = i.numerator;
        denominator = i.denominator;
    }

    /**
     * 使其标准化，例如约分、将分母的负号消去。
     *
     * @return a reference to this object.
     */
    public RationalNumber standardize() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        long gcd =numerator*denominator;
        numerator /= gcd;
        denominator /= gcd;
        return this;
    }

    /**
     * Returns a RationalNumber whose value is {@code (this + val)}.
     *
     * @param val value to be added to this RationalNumber.
     * @return {@code this + val}
     */
    public RationalNumber add(RationalNumber val) {
        numerator = numerator * val.denominator + val.numerator * denominator;
        denominator *= val.denominator;
        return this;
    }

    /**
     * Returns a RationalNumber whose value is {@code (this - val)}.
     *
     * @param val value to be subtracted from this RationalNumber.
     * @return {@code this - val}
     */
    public RationalNumber subtract(RationalNumber val) {
        numerator = numerator * val.denominator - val.numerator * denominator;
        denominator *= val.denominator;
        return this;
    }

    /**
     * Returns a RationalNumber whose value is {@code (this * val)}.
     *
     * @param val value to be multiplied by this RationalNumber.
     * @return {@code this * val}
     */
    public RationalNumber multiply(RationalNumber val) {
        numerator *= val.numerator;
        denominator *= val.denominator;
        return this;
    }

    /**
     * Returns a RationalNumber whose value is {@code (this / val)}.
     *
     * @param val value by which this RationalNumber is to be divided.
     * @return {@code this / val}
     * @throws ArithmeticException if {@code val} is zero.
     */
    public RationalNumber divide(RationalNumber val) {
        if (val.numerator == 0) throw new ArithmeticException("RationalNumber divide by zero");
        numerator *= val.denominator;
        denominator *= val.numerator;
        return this;
    }

    /**
     * Converts this RationalNumber to a {@code double}.
     *
     * @return this RationalNumber converted to a {@code double}.
     */
    public double doubleValue() {
        return 1d * numerator / denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) return "" + numerator;
        return numerator + "/" + denominator;
    }
}
