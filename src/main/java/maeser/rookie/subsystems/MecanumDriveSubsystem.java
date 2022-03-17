package maeser.rookie.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import maeser.rookie.Constants;

public class MecanumDriveSubsystem extends SubsystemBase {
    private Spark driveFLMotor = new Spark(Constants.kDriveMotorFLPort);
    private Spark driveFRMotor = new Spark(Constants.kDriveMotorFRPort);
    private Spark driveRLMotor = new Spark(Constants.kDriveMotorRLPort);
    private Spark driveRRMotor = new Spark(Constants.kDriveMotorRRPort);

    private final MecanumDrive mecanumDrive = new MecanumDrive(driveFLMotor,driveRLMotor,driveFRMotor,driveRRMotor);

    public MecanumDriveSubsystem(){
        driveFRMotor.setInverted(true);
        driveRRMotor.setInverted(true);
    }
    public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative) {
        if (fieldRelative) {
           // mecanumDrive.driveCartesian(ySpeed, xSpeed, rot, -m_gyro.getAngle());
        } else {
            SmartDashboard.putNumber("xSpeed",xSpeed);
            SmartDashboard.putNumber("ySpeed",ySpeed);
            SmartDashboard.putNumber("rot",rot);
            mecanumDrive.driveCartesian(-1 * ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot*Constants.kMotorSpeedDampening);
        }
    }
}
