package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;
import util.Swerve;
import util.SwerveModule;

/**
 *
 */
public class DriveTrain extends Subsystem
{
	public SwerveModule[] modules;
	
	public DriveTrain()
	{
		modules = new SwerveModule[RobotMap.NUMBER_OF_WHEELS];
		for(int i = 0; i < RobotMap.NUMBER_OF_WHEELS;i++)
			modules[i] = new SwerveModule(i, RobotMap.CANTALON_DRIVE_PORTS[i]); 
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void drive(double x, double y, double twist)
	{
		Swerve.display(x, y, twist);
		for(int i=0;i<RobotMap.NUMBER_OF_WHEELS;i++)
		{
			modules[i].driveModule(x, y, twist);
			modules[i].report();
		}	
	}
}