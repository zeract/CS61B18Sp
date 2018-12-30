public class NBody {
	
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);
		double t_var = 0;
		int N = planets.length;
		System.out.println(N);

		// set the scale and draw background 
		StdDraw.setScale(-1.6*radius,1.6*radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		// draw all planets
		for(int i=0; i<planets.length; i++){
			planets[i].draw();
		}
		
		StdDraw.enableDoubleBuffering(); // enable double buffering

		while(t_var<T){
			double[] xForces = new double[N];
			double[] yForces = new double[N];
			for(int j=0; j<N; j++){
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
			}
			for(int i=0; i<N; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0; i<planets.length; i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

			//update t_var
			t_var += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}

	/* read radius form data file */
	public static double readRadius(String fileName){
		In planetData = new In(fileName);

		int N = planetData.readInt();
		double R = planetData.readDouble();
		return R;
	}

	/* read the array of planets */
	public static Planet[] readPlanets(String fileName){
		In planetData = new In(fileName);

		int N = planetData.readInt();
		double R = planetData.readDouble();
		Planet[] planets = new Planet[N];
		for(int i=0; i<N; i++){
			double xP = planetData.readDouble();
			double yP = planetData.readDouble();
			double xV = planetData.readDouble();
			double yV = planetData.readDouble();
			double m = planetData.readDouble();
			String img = planetData.readString();
			planets[i] = new Planet(xP, yP, xV, yV, m, img);
		}
		return planets;

	}
}