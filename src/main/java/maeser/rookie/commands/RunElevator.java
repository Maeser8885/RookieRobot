package maeser.rookie.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import maeser.rookie.Constants;
import maeser.rookie.subsystems.ElevatorSubsystem;
import maeser.rookie.subsystems.IntakeSubsystem;
import maeser.rookie.subsystems.MecanumDriveSubsystem;



public class RunElevator extends CommandBase {
    private final ElevatorSubsystem elevatorSubsystem;
    private final double timeAmount;
    private Timer timer = new Timer();
    public RunElevator(ElevatorSubsystem elevator, double timeAmount) {
        this.elevatorSubsystem = elevator;
        this.timeAmount = timeAmount;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        this.elevatorSubsystem.setPulleyMotor(-1 * Constants.kElevatorDampening);
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        this.elevatorSubsystem.setPulleyMotor(0);

    }

    @Override
    public boolean isFinished() {
        return timer.get() > this.timeAmount;
    }
}
