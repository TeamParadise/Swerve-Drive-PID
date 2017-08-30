package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;
import util.SwerveModule;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	private SwerveModule[] modules;
	
	public DriveTrain()
	{
		modules = new SwerveModule[RobotMap.NUMBER_OF_WHEELS];
		for(int i = 0; i < RobotMap.NUMBER_OF_WHEELS;i++)
			modules[i] = new SwerveModule(i, RobotMap.CANTALON_DRIVE_PORTS[i][2]);
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void drive(double x, double y, double twist)
	{
		for(int i=0; i < RobotMap.NUMBER_OF_WHEELS; i++)
		{
			modules[i].driveModule(x, y, twist);
			modules[i].report();
		}
	}
	
	public void reset()
	{
		for(int i=0; i < RobotMap.NUMBER_OF_WHEELS; i++)
			modules[i].reset();
	}
}