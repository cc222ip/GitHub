package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class Fraction {
	private int N, D;
	private float res;
	
	/**
	 * @param NN
	 * @param DD
	 */
	public Fraction(int NN, int DD) {
		if(DD == 0)
			System.out.println("The denominator mustn't be zero.");
		else {
			N = NN;
			D = DD;
			res = N / D;
		}
	}
	
	/**
	 * @return
	 */
	public int getNumerator() {
		return this.N;
	}
	
	/**
	 * @return
	 */
	public int getDenominator() {
		return this.D;
	}

	/**
	 * @return
	 */
	public boolean isNegative() {
		if(this.N < 0 || this.D < 0 || this.res < 0)
			return true;
		return false;
	}
	
	/**
	 * @param f
	 * @return
	 */
	public Fraction add(Fraction f) {
		Fraction r = new Fraction(this.N * f.D + f.N * this.D, this.D * f.D);
		if(r.D == 0) {
			System.out.println("Error. The denominator is equal to zero.");
			return null;
		}
		return r;
	}
	
	/**
	 * @param f
	 * @return
	 */
	public Fraction substract(Fraction f) {
		Fraction r = new Fraction(this.N * f.D - f.N * this.D, this.D * f.D);
		if(r.D == 0) {
			System.out.println("Error. The denominator is equal to zero.");
			return null;
		}
		return r;
	}
	
	/**
	 * @param f
	 * @return
	 */
	public Fraction multiply(Fraction f) {
		Fraction r = new Fraction(this.N * f.N, this.D * f.D);
		if(r.D == 0) {
			System.out.println("Error. The denominator is equal to zero.");
			return null;
		}
		return r;
	}
	
	/**
	 * @param f
	 * @return
	 */
	public Fraction divide(Fraction f) {
		Fraction r = new Fraction(this.N * f.D, this.D * f.N);
		if(r.D == 0) {
			System.out.println("Error. The denominator is equal to zero.");
			return null;
		}
		return r;
	}
	
	/**
	 * @param f
	 * @return
	 */
	public boolean isEqualTo(Fraction f) {
		if(this.res == f.res)
			return true;
		return false;
	}
	
	public String toString() {
		return this.N + "/" + this.D;
	}
}


