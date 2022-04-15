package maeser.rookie.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import maeser.rookie.subsystems.ElevatorSubsystem;
import maeser.rookie.subsystems.MecanumDriveSubsystem;

public class AutoCommandGroup extends SequentialCommandGroup {
    public AutoCommandGroup(MecanumDriveSubsystem mecanumDriveSubsystem, ElevatorSubsystem elevatorSubsystem){
        addCommands(
            new RunElevator(elevatorSubsystem, 3.0),
            new DriveSetTime(mecanumDriveSubsystem,2.0, -1, 0.5)
        );
    }
}
