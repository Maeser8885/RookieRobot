package maeser.rookie.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import maeser.rookie.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private PWMSparkMax intakePWMSparkLeft = new PWMSparkMax(Constants.kIntakeMotorLeftPort);
    private PWMSparkMax intakePWMSparkRight = new PWMSparkMax(Constants.kIntakeMotorRightPort);
    private PWMSparkMax intakeWinch = new PWMSparkMax(Constants.kIntakeMotorWinchPort);
    public enum IntakeStatuses{WAITING,LIFTING,DROPPING}
    public IntakeStatuses intakeStatus = IntakeStatuses.WAITING;
    public DigitalInput topSwitch = new DigitalInput(Constants.kLSTopPort);
    public DigitalInput bottomSwitch = new DigitalInput(Constants.kLSBotPort);
    public IntakeSubsystem(){
        intakePWMSparkRight.setInverted(true); // so then we can just set both to same value
    }

    // MAKE LIMIT SWITCHES!!!11!11!

    @Override
    public void periodic(){

    }
    public boolean getTopSwitch(){
        return topSwitch.get();
    }

    public boolean getBottomSwitch(){
        return bottomSwitch.get();
    }

    public void dropIntakes(){
        this.intakeStatus = IntakeStatuses.DROPPING;
        intakeWinch.set(1);
    }

    public void liftIntakes(){
        this.intakeStatus = IntakeStatuses.LIFTING;
        intakeWinch.set(-1);
    }

    public void stopWinch(){
        this.intakeStatus = IntakeStatuses.WAITING;
        intakeWinch.set(0);
    }

    public void setIntakeSpeed(double speed){
        intakePWMSparkRight.set(speed);
        intakePWMSparkLeft.set(speed);
    }

}
