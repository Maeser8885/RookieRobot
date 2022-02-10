package maeser.rookie.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import maeser.rookie.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private PWMSparkMax intakePWMSparkLeft = new PWMSparkMax(Constants.kIntakeMotorLeftPort);
    private PWMSparkMax intakePWMSparkRight = new PWMSparkMax(Constants.kIntakeMotorRightPort);
    private PWMSparkMax intakeWinch = new PWMSparkMax(Constants.kIntakeMotorWinchPort);
    private enum IntakeStatus{WAITING,LIFTING,DROPPING}
    public IntakeSubsystem(){}

    // MAKE LIMIT SWITCHES

    @Override
    public void periodic(){

    }


}
