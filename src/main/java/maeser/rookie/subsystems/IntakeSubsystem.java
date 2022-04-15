package maeser.rookie.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import maeser.rookie.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private CANSparkMax intakePWMSparkLeft = new CANSparkMax(Constants.kIntakeMotorLeftCAN, CANSparkMaxLowLevel.MotorType.kBrushed);
    private CANSparkMax intakePWMSparkRight = new CANSparkMax(Constants.kIntakeMotorRightCAN, CANSparkMaxLowLevel.MotorType.kBrushed);
    private CANSparkMax intakeWinch = new CANSparkMax(Constants.kIntakeMotorWinchCAN, CANSparkMaxLowLevel.MotorType.kBrushed);


    public IntakeSubsystem(){
        intakePWMSparkRight.setInverted(true); // so then we can just set both to same value
    }

    // MAKE LIMIT SWITCHES!!!11!11!

    @Override
    public void periodic(){

    }

    public void setWinchSpeed(double speed){
        intakeWinch.set(speed);
    }

    public void setIntakeSpeed(double speed){
        intakePWMSparkRight.set(speed*Constants.kDisabledIntakeDampening);
        intakePWMSparkLeft.set(speed);
    }

}
