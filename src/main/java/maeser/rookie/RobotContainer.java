// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package maeser.rookie;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import maeser.rookie.subsystems.MecanumDriveSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    //private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    
    //private final ExampleCommand autoCommand = new ExampleCommand(exampleSubsystem);

    private final MecanumDriveSubsystem mecanumDriveSubsystem = new MecanumDriveSubsystem();
    Joystick flightStick = new Joystick(0);
    JoystickButton motorButton = new JoystickButton(flightStick,2);
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();


        mecanumDriveSubsystem.setDefaultCommand(
            // A split-stick arcade command, with forward/backward controlled by the left
            // hand, and turning controlled by the right.
            new RunCommand(
                () ->
                    mecanumDriveSubsystem.drive(
                        flightStick.getX(),
                        flightStick.getY(),
                        Helpers.adjustTwist(flightStick.getTwist()),
                        false),
                    mecanumDriveSubsystem));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        /**motorButton.toggleWhenPressed(new StartEndCommand(
                () -> exampleSubsystem.set(1),
                () -> exampleSubsystem.set(0),
                exampleSubsystem));**/
        // Add button to command mappings here.
        // See https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html

    }
    
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
