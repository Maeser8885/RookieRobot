package maeser.rookie.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import maeser.rookie.Constants;
import maeser.rookie.subsystems.ElevatorSubsystem;
import maeser.rookie.subsystems.MecanumDriveSubsystem;

public class AutoCommandGroup extends SequentialCommandGroup {
    public AutoCommandGroup(MecanumDriveSubsystem mecanumDriveSubsystem, ElevatorSubsystem elevatorSubsystem){
        addCommands(
            new RunElevator(elevatorSubsystem, 1.5),
            new DriveSetTime(mecanumDriveSubsystem, Constants.kAutonomousTime, -1, 0.5)
        );
    }
}
