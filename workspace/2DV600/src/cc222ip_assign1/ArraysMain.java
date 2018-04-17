package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class ArraysMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception { // Tests :
		try {
			int[] n = {3,4,5,6,7};
		    String str = Arrays.toString(n);
		    System.out.println("n = " + str);
		    
		    int[] m = Arrays.addN(n, 2);
		    System.out.print("m = ");
		    Arrays.display(m);
		    
		    int[] t = Arrays.reverse(m);
		    System.out.print("t = ");
		    Arrays.display(t);
		    
		    int[] p = {8, 5, 6, 5, 2, 7};
		    System.out.print("p v1 = ");
		    Arrays.display(p);
		    Arrays.replaceAll(p, 5, 3);
		    System.out.print("p v2 = ");
		    Arrays.display(p);
		    
		    int[] l = Arrays.sort(t);
		    System.out.print("l = ");
		    Arrays.display(l);
		   
		    int[] t1 = {1,2,3,4,5};
		    int[] t2 = {1,1,1,1,1};
		    int[] t3 = {2,3,4};
		    
		    Arrays.display(Arrays.absDif(t1, t2));
		    if(Arrays.hasSubsequence(t1, t3))
		    	System.out.println("t1 contains the t3 subsequence.");
		}
				
		catch (Exception e) {
	        System.out.println("Exception: " + e.getMessage());
	    }
	}
}
