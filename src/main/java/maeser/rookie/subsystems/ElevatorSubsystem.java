package maeser.rookie.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import maeser.rookie.Constants;

public class ElevatorSubsystem extends SubsystemBase {
    private CANSparkMax pulleyMotor = new CANSparkMax(Constants.kPulleyMotorCAN, CANSparkMaxLowLevel.MotorType.kBrushless);
    public ElevatorSubsystem(){}

    public void setPulleyMotor(double speed) {
        pulleyMotor.set(speed);
    }

}
