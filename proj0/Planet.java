public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /** Constructor */
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    /** Copy constructor */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;       
    }
    /** Return the distance between this planet and
     * Plane P in the arg.     */
    public double calcDistance(Planet p){
        double delta_x = this.xxPos - p.xxPos;
        double delta_y = this.yyPos - p.yyPos;
        return Math.sqrt(delta_x*delta_x+delta_y*delta_y);
    }

    /** Returns the force exerted on this Planet
     * by Planet P from arg.     */
    public double calcForceExertedBy(Planet p){
        double G = 6.67e-11;
        double r = calcDistance(p);
        double result = G*mass*p.mass/(r*r);
        return result;
    }

    /** Returns the force exerted on this Planet
     *  by P in the X direction.     */
    public double calcForceExertedByX(Planet p){
        double delta_x = p.xxPos-xxPos;
        // double sign=delta_x>0?1.0:-1.0;
        double distane = calcDistance(p);
        double F_x = calcForceExertedBy(p)*delta_x/distane;
        return F_x;
    }
    /** Returns the force exerted on this Planet
     *  by P in the Y direction.     */
    public double calcForceExertedByY(Planet p){
        double delta_y = p.yyPos-yyPos;
        // double sign=delta_x>0?1.0:-1.0;
        double distane = calcDistance(p);
        double F_y = calcForceExertedBy(p)*delta_y/distane;
        return F_y;
    }

    /**Returns true when planet p is the same with
     * Plant *this.     */
    public boolean equals(Planet p){
        if(xxPos==p.xxPos && yyPos==p.yyPos)
            return true;
        else
            return false;
    }

    /**Returns the net force on this Planet
     * in X direction.     */
    public double calcNetForceExertedByX(Planet[] a){
        double NetForce_X = 0;
        for(int i=0;i<a.length;i++){
            if(equals(a[i]))
                continue;
            NetForce_X += calcForceExertedByX(a[i]);
        }
        return NetForce_X;
    }

    /**Returns the net force on this Planet
     * in Y direction.     */
    public double calcNetForceExertedByY(Planet[] a){
        double NetForce_Y = 0;
        for(int i=0;i<a.length;i++){
            if(equals(a[i]))
                continue;
            NetForce_Y += calcForceExertedByY(a[i]);
        }
        return NetForce_Y;
    }

    /**Update the planet's velocity and position
     * in the small amount of time d_t, with the Net force F_x
     * and F_y in X and Y direction.     */
    public void update(double d_t, double F_x, double F_y){
        double a_x = F_x/mass;
        double a_y = F_y/mass;
        // Update the velocity.
        xxVel = xxVel + d_t * a_x;
        yyVel = yyVel + d_t * a_y;
        // Update the position.
        xxPos = xxPos + d_t * xxVel;
        yyPos = yyPos + d_t * yyVel; 
    }

    /**Draw a planet at its position. */
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}