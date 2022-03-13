package maeser.rookie.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import maeser.rookie.Constants;

public class MecanumDriveSubsystem extends SubsystemBase {
    private PWMSparkMax driveFLMotor = new PWMSparkMax(Constants.kDriveMotorFLPort);
    private PWMSparkMax driveFRMotor = new PWMSparkMax(Constants.kDriveMotorFRPort);
    private PWMSparkMax driveRLMotor = new PWMSparkMax(Constants.kDriveMotorRLPort);
    private PWMSparkMax driveRRMotor = new PWMSparkMax(Constants.kDriveMotorRRPort);

    private final MecanumDrive mecanumDrive = new MecanumDrive(driveFLMotor,driveRLMotor,driveFRMotor,driveRRMotor);

    public MecanumDriveSubsystem(){
        driveFRMotor.setInverted(true);
        driveRRMotor.setInverted(true);
    }
    public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative) {
        if (fieldRelative) {
           // mecanumDrive.driveCartesian(ySpeed, xSpeed, rot, -m_gyro.getAngle());
        } else {
            //TODO make rotation 0 unless above set dampening range.
            mecanumDrive.driveCartesian(ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot*Constants.kMotorSpeedDampening);
        }
    }
}
