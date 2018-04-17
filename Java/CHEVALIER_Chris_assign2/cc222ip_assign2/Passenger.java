package cc222ip_assign2;

/**
 * @author Chris_Chevalier
 *
 */
public class Passenger {
	public String name;
	public String surname;
	public int age;
	
	/**
	 * @param nname
	 * @param ssurname
	 * @param aage
	 */
	public Passenger(String nname, String ssurname, int aage) {
		name = nname;
		surname = ssurname;
		age = aage;
	}
	
	public String toString() {
		return surname + " " + name + ", " + age + " years old";
	}
}
