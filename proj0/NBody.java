public class NBody {
    /** Return the value of radius from the input file. */
    public static double readRadius(String file){
        In in = new In(file);
        int N_body = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /**Read the array of planets from the file. */
    public static Planet[] readPlanets(String file){
        In in = new In(file);
        int N_body = in.readInt();
        double radius = in.readDouble();
        Planet[] a = new Planet[N_body];
        for(int i=0;i<N_body;i++){
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            a[i] = new Planet(xPos, yPos, xVel, yVel, m, img);
        }
        return a;
    }

    public static void main(String[] args) {
        //Read input info
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        double t = 0.0;
        //Draw the background
        StdDraw.setScale(-1*radius,radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        //Draw all the planets
        for(int i=0;i<planets.length;i++){
            planets[i].draw();
        }
        StdDraw.show();
        //Add Animation
        while(t<T){
            Double[] xForces = new Double[planets.length];
            Double[] yForces = new Double[planets.length];
            for(int i=0;i<planets.length;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i=0;i<planets.length;i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(int i=0;i<planets.length;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
        
    }
}