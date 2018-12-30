public class Planet{
	/* six instance variables */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/* static constant */
	public static double G = 6.67e-11;

	/* two constructor */
	public Planet(double xP, double yP, double xV, double yV,
	 double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/* non-static method calculating the distance */
	public double calcDistance(Planet p){
		return Math.sqrt(Math.pow(this.xxPos-p.xxPos,2)+Math.pow(this.yyPos-p.yyPos,2));
	}

	public double calcForceExertedBy(Planet p){
		return G*this.mass*p.mass / (this.calcDistance(p)*this.calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double sumX=0;
		for(int i=0; i<allPlanets.length; i++){
			if(allPlanets[i].equals(this)){
				continue;
			}
			sumX += this.calcForceExertedByX(allPlanets[i]);
		}
		return sumX;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double sumY=0;
		for(int i=0; i<allPlanets.length; i++){
			if(allPlanets[i].equals(this)){
				continue;
			}
			sumY += this.calcForceExertedByY(allPlanets[i]);
		}
		return sumY;
	}

	public void update(double dt, double fX, double fY){
		this.xxVel += dt*fX/this.mass;
		this.yyVel += dt*fY/this.mass;
		this.xxPos += dt*this.xxVel;
		this.yyPos += dt*this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}
}