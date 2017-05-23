package util;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwerveModule
{
	private int id;
	private double speed = 0;
	private double angle = 0;
	
	CANTalon translationMotor;
	CANTalon rotationMotor;

	public SwerveModule(int id, int[] ports)
	{
		this.id = id;
		translationMotor = new CANTalon(ports[0]);
		rotationMotor = new CANTalon(ports[1]);
	}

	public void driveModule(double x, double y, double twist)
	{
		double wx = x + twist * RobotMap.DISTANCES[id][1];
		double wy = y - twist * RobotMap.DISTANCES[id][0];

		speed = Math.sqrt(wx * wx + wy * wy)/Swerve.getMax(twist);
		angle = Math.atan2(wy, wx) * 180 / Math.PI;
		
		translationMotor.set(speed);
	}
	
	public void report()
	{
		SmartDashboard.putNumber("Swerve Module "+ id + " Speed", speed);
		SmartDashboard.putNumber("Swerve Module "+ id + " Angle", angle);
	}
}