// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package maeser.rookie;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Multipliers
     public static final double kMotorSpeedDampening = 1;
    public static final double kTwistDampening = 0.5;
    public static final double kWinchDampening = 0.25;
    public static final double kIntakeDampening = 1;
    public static final double kElevatorDampening = 0.7; //.0.7
    public static final double kDisabledIntakeDampening = 1;

    // DIO ports
    public static final int kLSTopPort = 1;
    public static final int kLSBotPort = 0;

    // Motor PWM Ports
        //Wheels
    public static final int kDriveMotorFLPort = 3;
    public static final int kDriveMotorFRPort = 0;
    public static final int kDriveMotorRLPort = 2;
    public static final int kDriveMotorRRPort = 1;

        //Intake
    public static final int kIntakeMotorLeftCAN = 2;
    public static final int kIntakeMotorRightCAN = 3;
    public static final int kIntakeMotorWinchCAN = 1;
        //Elevator
    public static final int kPulleyMotorCAN = 4;

    // Autonomous stuff
    public static final double kAutonomousTime = 1.5;

}
