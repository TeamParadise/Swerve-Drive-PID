package org.usfirst.frc.team1165.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1165.robot.Robot;

/**
 *
 */
public class DriveWithJoystick extends Command
{
	public DriveWithJoystick()
	{
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.encoderPID);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		double x = Math.pow(Robot.oi.stick.getX(), 3);
		double y = -Math.pow(Robot.oi.stick.getY(), 3);
		double twist = Math.pow(Robot.oi.stick.getTwist(), 3);
		
		if (Math.abs(x) < .1)
			x = 0;
		if (Math.abs(y) < .1)
			y = 0;
		if (Math.abs(twist) < .1)
			twist = 0;

		Robot.driveTrain.drive(x, y, twist);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}
