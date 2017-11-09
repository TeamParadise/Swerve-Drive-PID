package util;

import org.usfirst.frc.team1165.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwerveModule extends PIDSubsystem
{
	private static final double kP = 0.01;
	private static final double kI = 0.00;
	private static final double kD = 0.00;

	private static final double TOLERANCE = 10;
	
	private int id = 0;

	private double speed = 0;
	private double angle = 0;
	
	private double heading = 0;

	private CANTalon translationMotor;
	private CANTalon rotationMotor;
	
	private AnalogInput analogInput;
	private AnalogPotentiometer encoder;
	
	public SwerveModule(int id, int analogInputPort)
	{
		super(kP, kI, kD);
		setInputRange(0, 360);
    	setOutputRange(-1, 1);
    	setAbsoluteTolerance(TOLERANCE);
    	getPIDController().setContinuous(true);
    	
		this.id = id;
		
		translationMotor = new CANTalon(RobotMap.CANTALON_DRIVE_PORTS[id][0]);
		rotationMotor = new CANTalon(RobotMap.CANTALON_DRIVE_PORTS[id][1]);
		
		analogInput = new AnalogInput(analogInputPort);

//		analogInput = new AnalogInput(RobotMap.CANTALON_DRIVE_PORTS[id][2]);
		encoder = new AnalogPotentiometer(analogInput, 360.0, 0);

		enable();
	}
	
	public void updateHeading()
	{
		double initialValue = 360 - RobotMap.RESET_ENCODERS[id];
		heading = (encoder.get() + initialValue) % 360;
	}

	public void resetEncoder()
	{
		angle = 0;

		driveModuleTo(0, angle);
	}

	public void driveModule(double x, double y, double twist)
	{
		double wx = x + twist * RobotMap.DISTANCES[id][1];
	 	double wy = y - twist * RobotMap.DISTANCES[id][0];

		speed = Math.sqrt(wx * wx + wy * wy) / Swerve.getMax(twist);
		angle = ( Math.atan2(wy, wx) * 180 / Math.PI ) + 180;

		driveModuleTo(speed, angle);
	}
	
	public void driveModuleTo(double speed, double angle)
	{
		updateHeading();
		
		this.speed = speed;
		this.angle = angle;
		
//		translationMotor.set(Math.pow(speed, 3));
		translationMotor.set(speed);
		if(Math.abs(heading - angle) > 10)
			setSetpoint(angle);
	}
	
	public void report()
	{
		SmartDashboard.putNumber("Swerve Module " + id + " Speed", speed);
		SmartDashboard.putNumber("Swerve Module " + id + " Angle", angle);
		SmartDashboard.putNumber("Swerve Module " + id + " Heading", heading);
		SmartDashboard.putNumber("Swerve Module " + id + " Encoder", encoder.get());
	}
	@Override
	protected double returnPIDInput()
	{
		return heading;
	}

	@Override
	protected void usePIDOutput(double output)
	{
//		rotationMotor.set(Math.pow(output, 3));
		rotationMotor.set(output);
	}

	@Override
	protected void initDefaultCommand()
	{
	}
}