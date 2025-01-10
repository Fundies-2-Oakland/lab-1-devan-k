public class Vector3D {

    private double x, y, z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ(){
        return z;
    }

    public String toString() {
        return String.format("(%1$.2f, %2$.2f, %3$.2f)", x, y, z);
    }

    public double getMagnitude() {
        double xSqrd = Math.pow(x, 2);
        double ySqrd = Math.pow(y, 2);
        double zSqrd = Math.pow(z, 2);
        return Math.sqrt(xSqrd + ySqrd + zSqrd);
    }
}
