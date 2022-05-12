package maeser.rookie.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import maeser.rookie.Constants;
import maeser.rookie.subsystems.IntakeSubsystem;
import maeser.rookie.subsystems.MecanumDriveSubsystem;



public class DriveSetTime extends CommandBase {
    private final MecanumDriveSubsystem mecanumDriveSubsystem;
    private final double timeAmount;
    private final double direction;
    private final double speed;
    private Timer timer = new Timer();
    public DriveSetTime(MecanumDriveSubsystem drive, double timeAmount, double direction, double speed) {
        this.mecanumDriveSubsystem = drive;
        this.timeAmount = timeAmount;
        this.direction = direction;
        this.speed = speed;
        addRequirements(mecanumDriveSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        mecanumDriveSubsystem.drive(0,speed * direction,0,true,false);
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        mecanumDriveSubsystem.drive(0,0,0,true, false);

    }

    @Override
    public boolean isFinished() {
        return timer.get() > this.timeAmount;
    }
}
