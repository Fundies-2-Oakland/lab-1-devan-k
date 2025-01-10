import java.util.Vector;

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

    public Vector3D normalize(){
        double magnitude = getMagnitude();
        if(magnitude == 0){
            throw new IllegalStateException("Magnitude is 0");
        }
        return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    public Vector3D addition(Vector3D vector){
        return new Vector3D(x + vector.getX(), y + vector.getY(), z + vector.getZ());
    }

    public Vector3D multiply(double constant){
        return new Vector3D(x * constant, y * constant, z * constant);
    }

    public double dotProduct(Vector3D vector){
        return (x * vector.getX()) + (y * vector.getY()) + (z * vector.getZ());
    }

    public double angleBetween(Vector3D vector){
        double thisMagnitude = getMagnitude();
        double vectorMagnitude = vector.getMagnitude();
        if(thisMagnitude == 0 || vectorMagnitude == 0){
            throw new IllegalStateException("One of the vector magnitudes is 0");
        }
        return Math.acos(dotProduct(vector) / (thisMagnitude * vectorMagnitude));
    }

    public Vector3D crossProduct(Vector3D vector){
        double uX = y * vector.getZ() - z * vector.getY();
        double uY = z * vector.getX() - x * vector.getZ();
        double uZ = x * vector.getY() - y * vector.getX();
        return new Vector3D(uX, uY, uZ);
    }
}
