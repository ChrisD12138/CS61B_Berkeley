public class Body{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Body(double xP, double yP,double xV, double yV, double m ,String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
		}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName =b.imgFileName;
	}

	public double calcDistance(Body a){
		double distance;
		distance = (a.xxPos-this.xxPos)*(a.xxPos-this.xxPos)+(a.yyPos-this.yyPos)*(a.yyPos-this.yyPos);
		return Math.sqrt(distance);
	}

	public double calcForceExertedBy(Body a){
		double G = 6.67e-11;
		double dis = this.calcDistance(a);
		return G*this.mass*a.mass/((dis)*(dis));
	}

	public double calcForceExertedByX(Body a){
		double r = this.calcDistance(a);
		double f_total =this.calcForceExertedBy(a);
		return f_total*(a.xxPos-this.xxPos)/r;
	}

	public double calcForceExertedByY(Body a){
		double r = this.calcDistance(a);
		double f_total =this.calcForceExertedBy(a);
		return f_total*(a.yyPos-this.yyPos)/r;
	}

	public double calcNetForceExertedByX(Body [] allBodys){
		double res = 0;
		for(Body a : allBodys){
			if (!this.equals(a)) res += this.calcForceExertedByX(a);
		}
		return res;
	}

	public double calcNetForceExertedByY(Body [] allBodys){
		double res = 0;
		for(Body a : allBodys){
			if (!this.equals(a)) res += this.calcForceExertedByY(a);
		}
		return res;
	}

	public void update(double t, double x_force, double y_force){
		double a_x = x_force/this.mass;
		double a_y = y_force/this.mass;
		this.xxVel += a_x*t;
		this.yyVel += a_y*t;
		this.xxPos += this.xxVel*t;
		this.yyPos += this.yyVel*t;
	}
}