package maeser.rookie.subsystems;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
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
    private ADIS16470_IMU gyro;

    private final MecanumDrive mecanumDrive = new MecanumDrive(driveFLMotor,driveRLMotor,driveFRMotor,driveRRMotor);

    public MecanumDriveSubsystem(ADIS16470_IMU gyro){
        driveFRMotor.setInverted(true);
        driveRRMotor.setInverted(true);
        this.gyro = gyro;
    }

    public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative) {
        if (fieldRelative) {
            SmartDashboard.putNumber("xSpeed",xSpeed);
            SmartDashboard.putNumber("ySpeed",ySpeed);
            SmartDashboard.putNumber("rot",rot);
            SmartDashboard.putNumber("angle", gyro.getAngle());
            mecanumDrive.driveCartesian(-1 * ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot*Constants.kMotorSpeedDampening, -gyro.getAngle());
        } else {
            SmartDashboard.putNumber("xSpeed",xSpeed);
            SmartDashboard.putNumber("ySpeed",ySpeed);
            SmartDashboard.putNumber("rot",rot);
            mecanumDrive.driveCartesian(-1 * ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot*Constants.kMotorSpeedDampening);
        }
    }
}
