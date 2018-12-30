public class TestDraw{
	public static void main(String[] args){
		/* System.out.println("pass!"); */
		/* StdDraw.point(0.5,0.5); */
		StdDraw.setXscale(-2,2);
		StdDraw.setYscale(-2,2);
		StdDraw.line(0,0,1,1); /*draw a line */

		/** draw a triangle with a point inside */
		double t = Math.sqrt(3)/2;
		StdDraw.line(0,0,1,0);
		StdDraw.line(1,0,0.5,t);
		StdDraw.line(0.5,t,0,0);
		StdDraw.point(0.5,t/3);
	}
}