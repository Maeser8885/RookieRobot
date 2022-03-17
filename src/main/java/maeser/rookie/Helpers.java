package maeser.rookie;

public class Helpers {
    public static double adjustTwist(double twist){
        if (Math.abs(twist) >= Constants.kTiltDampening){
            int sign = Integer.signum((int) twist); // get the sign
            double modified = Math.abs(twist) - Constants.kTiltDampening; // adjust the value
            return sign * modified; // reapply the sign

        } else {
            return 0;
        }
    }
}
