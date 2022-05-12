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
    private double gyroHeading;
    private final MecanumDrive mecanumDrive = new MecanumDrive(driveFLMotor,driveRLMotor,driveFRMotor,driveRRMotor);

    public MecanumDriveSubsystem(ADIS16470_IMU gyro){
        driveFRMotor.setInverted(true);
        driveRRMotor.setInverted(true);
        this.gyro = gyro;
        gyroHeading = gyro.getAngle();
    }

    public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative, boolean gyroMode) {
        if (fieldRelative && !gyroMode) {
            SmartDashboard.putNumber("xSpeed",xSpeed);
            SmartDashboard.putNumber("ySpeed",ySpeed);
            SmartDashboard.putNumber("rot",rot);
            SmartDashboard.putNumber("angle", -gyro.getAngle());

            mecanumDrive.driveCartesian(ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot, -gyro.getAngle());
        } else if(gyroMode && !fieldRelative){
            //Thanks to copperbots for the gyro code
            SmartDashboard.putNumber("xSpeed",xSpeed);
            SmartDashboard.putNumber("ySpeed",ySpeed);

            double error = gyro.getAngle() - gyroHeading;
            double kP = SmartDashboard.getNumber("kP", .05);
            if (rot == 0) {
                rot = rot + error * kP;
            } else {
                gyroHeading = gyro.getAngle();
            }
            SmartDashboard.putNumber("Gyro Heading", gyroHeading);
            SmartDashboard.putNumber("Gyro Error", error);

            SmartDashboard.putNumber("rotation",rot);

            mecanumDrive.driveCartesian(ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot);
        } else { 
            SmartDashboard.putNumber("xSpeed",xSpeed);
            SmartDashboard.putNumber("ySpeed",ySpeed);
            SmartDashboard.putNumber("rot",rot);
            mecanumDrive.driveCartesian(ySpeed*Constants.kMotorSpeedDampening, xSpeed*Constants.kMotorSpeedDampening, rot);
        }
    }
}
