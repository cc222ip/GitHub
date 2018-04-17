package cc222ip_assign1;

/**
 * @author Chris_Chevalier
 *
 */
public class Point {
	private int x;
	private int y;
	
	/**
	 * @param xx
	 * @param yy
	 */
	public Point(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public Point() {
		x = y = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(3,4);
		System.out.println(p1.toString());   // ==> (0,0)
		System.out.println(p2.toString());   // ==> (3,4)
				
		if (p1.isEqualTo(p2))              // False!
			System.out.println("The two points are equal");
		
		double dist = p1.distanceTo(p2);
		System.out.println("Point Distance: " + dist);
		
		p2.move(5,-2);         // ==> (8,2)
		p1.moveToXY(8,2);	   // ==> (8,2)
		
		if (p1.isEqualTo(p2))              // True!
			System.out.println("The two points are equal");
	}
	
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	/**
	 * @param p
	 * @return
	 */
	public boolean isEqualTo(Point p) {
		if((this.x == p.x) &&(this.y == p.y))
			return true;
		return false;
	}
	
	/**
	 * @param p
	 * @return
	 */
	public double distanceTo(Point p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	
	/**
	 * @param a
	 * @param b
	 */
	public void move(int a, int b) {
		x += a;
		y += b;
	}
	
	/**
	 * @param a
	 * @param b
	 */
	public void moveToXY(int  a, int b) {
		x = a;
		y = b;
	}
}