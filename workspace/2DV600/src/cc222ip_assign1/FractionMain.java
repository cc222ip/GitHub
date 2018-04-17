package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class FractionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fraction F1 = new Fraction(16, 8);
		Fraction F2 = new Fraction(3, 3);
		
		System.out.println("- Numerator: " + F1.getNumerator());
		System.out.println("- Denominator: " + F1.getDenominator());
		System.out.println();
		
		Fraction t1 = F1.add(F2);
		Fraction t2 = F1.substract(F2);
		Fraction t3 = F1.multiply(F2);
		Fraction t4 = F1.divide(F2);
		
		System.out.println("- Add: " + t1.toString());
		System.out.println("- Substract: " + t2.toString());
		System.out.println("- Multiply: " + t3.toString());
		System.out.println("- Divide: " + t4.toString());
		System.out.println();
		
		if(t2.isNegative())
			System.out.println("The fractional number is negative.");
		
		if(F1.isEqualTo(F2))
			System.out.println("F1 & F2 are equals.");
	}

}
