package maeser.rookie;

import java.util.ArrayList;

public class Helpers {
    public static double deadzonedValue(double value, double deadzone) {
        if (Math.abs(value) < deadzone) {
            return 0.0;
        } else {
            return value - (Math.signum(value) * deadzone);
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
