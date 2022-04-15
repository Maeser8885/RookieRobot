package maeser.rookie;

import java.util.ArrayList;

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
    public static double timedTrapezoidRiemannSum(ArrayList<Double> list, ArrayList<Double> time){
        double sum = 0;
        for (int i = 0; i < list.size() - 1; i++){
            sum += (list.get(i) + list.get(i + 1)) * (time.get(i + 1) - time.get(i)) / 2;
        }
        return sum;
    }
    public static double booleanToDouble(boolean bool){
        if(bool){
            return 1.0;
        } else {
            return -1.0;
        }
    }

}
