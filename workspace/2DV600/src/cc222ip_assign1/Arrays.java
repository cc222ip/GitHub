package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class Arrays {

	/**
	 * @param arr
	 * @throws NullPointerException
	 */
	public static void display(int[] arr) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	/**
	 * @param arr
	 * @return
	 * @throws NullPointerException
	 */
	public static int sum(int[] arr) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	/**
	 * @param arr
	 * @return
	 * @throws NullPointerException
	 */
	public static String toString(int[] arr) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i];
		}
		return str;
	}

	/**
	 * @param arr
	 * @param n
	 * @return
	 * @throws NullPointerException
	 */
	public static int[] addN(int[] arr, int n) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] += n;
		}
		return arr;
	}

	/**
	 * @param arr
	 * @return
	 * @throws NullPointerException
	 */
	public static int[] reverse(int[] arr) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		int[] rev = new int[arr.length];
		int c = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			rev[i] = arr[c];
			c--;
		}
		return rev;
	}

	/**
	 * @param arr
	 * @param old
	 * @param nw
	 * @throws NullPointerException
	 */
	public static void replaceAll(int[] arr, int old, int nw) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == old) {
				arr[i] = nw;
			}
		}
	}

	/**
	 * @param arr
	 * @return
	 * @throws NullPointerException
	 */
	public static int[] sort(int[] arr) throws NullPointerException {
		if(arr == null)
			throw new NullPointerException("Error. Null array.");
		
		int[] s = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			s[i] = arr[i];
		}
		for (int i = 0; i < s.length; i++) {
			for (int j = i + 1; j < s.length; j++) {
				int tmp = 0;
				if (s[i] > s[j]) {
					tmp = s[i];
					s[i] = s[j];
					s[j] = tmp;
				}
			}
		}
		return s;
	}

	/**
	 * @param arr
	 * @param sub
	 * @return
	 * @throws NullPointerException
	 */
	public static boolean hasSubsequence(int[] arr, int[] sub) throws NullPointerException {
		if(arr == null || sub == null)
			throw new NullPointerException("Error. Null array.");
		
		int max = 0;

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == sub[max])
				max++;
			else
				max = 0;
			if(max == sub.length)
				return true;
		}
		return false;

	}

	/**
	 * @param arr1
	 * @param arr2
	 * @return
	 * @throws NullPointerException
	 */
	public static int[] absDif(int[] arr1, int[] arr2) throws NullPointerException {
		if(arr1 == null || arr2 == null)
			throw new NullPointerException("Error. Null array.");
		
		int[] arr3 = new int[arr1.length];
		if (arr1.length != arr2.length) {
			throw new ArithmeticException("The sizes of both arrays should be the same!");
		}
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = Math.abs(arr1[i]) - Math.abs(arr2[i]);
		}
		return arr3;
	}
}
