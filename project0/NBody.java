public class NBody{
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body [] bodies = readBodies(filename);
		int N = bodies.length;
		StdDraw.setScale(-radius,radius);
		String background = "images/starfield.jpg";
		StdDraw.picture(0, 0, background);
		for (Body body :bodies) {
			StdDraw.picture(body.xxPos, body.yyPos, "images"+"/"+body.imgFileName);
		}
		StdDraw.enableDoubleBuffering();
		double t = 0;
		double [] xForces = new double[N];
		double [] yForces = new double[N];
		while (t<T) {
			for(int i =0;i<N;i++) {
				xForces[i] = bodies[0].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[0].calcNetForceExertedByY(bodies);
				bodies[i].update(dt, xForces[i], yForces[i]);				
			}
			StdDraw.picture(0, 0, background);
			for (Body body :bodies) {
				StdDraw.picture(body.xxPos, body.yyPos, "images"+"/"+body.imgFileName);
			}
			StdDraw.show();
			StdDraw.pause(10);
			t+=dt;
		}

		
	}

	public static double readRadius(String Filename){
		In in = new In(Filename);
		int num = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}

	public static Body[] readBodies(String Filename){
		In in = new In(Filename);
		int N = in.readInt();
		double Radius = in.readDouble();
		Body [] res = new Body[N];
		double xPos= 0;
		double yPos= 0;
		double xVel= 0;
		double yVel= 0;
		double mass= 0;
		String name="";
		for(int i=0;i<N;i++){
			xPos = in.readDouble();
			yPos = in.readDouble();
			xVel = in.readDouble();
			yVel = in.readDouble();
			mass = in.readDouble();
			name = in.readString();			
			res [i] = new Body(xPos,yPos,xVel,yVel,mass,name);
		}
		return res;
}
}