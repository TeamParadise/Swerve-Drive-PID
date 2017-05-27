package util;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
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

	public Encoder encoder;

	public SwerveModule(int id, int[] ports)
	{
		this.id = id;
		translationMotor = new CANTalon(ports[0]);
		rotationMotor = new CANTalon(ports[1]);

		encoder = new Encoder(ports[2], ports[3], false, EncodingType.k4X);
	}

	public void driveModule(double x, double y, double twist)
	{
		double wx = x + twist * RobotMap.DISTANCES[id][1];
		double wy = y - twist * RobotMap.DISTANCES[id][0];
		
		speed = Math.sqrt(wx * wx + wy * wy) / Swerve.getMax(twist);
		angle = Math.atan2(wy, wx) * 180 / Math.PI;

		Robot.encoderPID.setSetpoint(angle);
		Robot.encoderPID.setEncoderID(id);
		Robot.encoderPID.enable();
		
		rotationMotor.set(Robot.encoderPID.getOutput());
		
//		translationMotor.set(speed);
//		setAngle(angle);
	}

	public void setAngle(double setpoint)
	{
		double power = 1;
		double tolerance = 10;
//		if (id == 2)
//		{
//			power = 0.5;
//			tolerance = 20;
//		}
		if (Math.abs(setpoint - encoder.get()) > tolerance)
		{
			SmartDashboard.putNumber("Error", Math.abs(setpoint - encoder.get()));
			if (setpoint > encoder.get())
				rotationMotor.set(power);
			else if (setpoint < encoder.get())
				rotationMotor.set(-power);
		} else
			rotationMotor.set(0);
	}

	public void report()
	{
		SmartDashboard.putNumber("Swerve Module " + id + " Speed", speed);
		SmartDashboard.putNumber("Swerve Module " + id + " Angle", angle);

		// Encoder Stuff
		SmartDashboard.putNumber("Swerve Module " + id + " Encoder Value", encoder.get());
	}
}