package maeser.rookie.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import maeser.rookie.subsystems.IntakeSubsystem;

public class IntakeDropCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    public IntakeDropCommand(IntakeSubsystem intake) {
        this.intakeSubsystem = intake;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.dropIntakes();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stopWinch();
    }

    @Override
    public boolean isFinished() {
        return intakeSubsystem.getBottomSwitch();
    }
}
