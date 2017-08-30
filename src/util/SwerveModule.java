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

	private CANTalon translationMotor;
	private CANTalon rotationMotor;
	
	private AnalogInput analogInput;
	private AnalogPotentiometer encoder;
	
	public SwerveModule(int id, int analogInputPort)
	{
		super(kP, kI, kD);
		setInputRange(-360, 360);
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

	public void driveModule(double x, double y, double twist)
	{
		double wx = x + twist * RobotMap.DISTANCES[id][1];
	 	double wy = y - twist * RobotMap.DISTANCES[id][0];
		
		speed = Math.sqrt(wx * wx + wy * wy) / Swerve.getMax(twist);
		angle = Math.atan2(wy, wx) * 180 / Math.PI;

		translationMotor.set(speed);
		if(Math.abs(encoder.get() - angle) > 10)
			setSetpoint(angle);
	}

	public void reset()
	{
//		encoder.reset();
	}
	
	public void report()
	{
		SmartDashboard.putNumber("Swerve Module " + id + " Speed", speed);
		SmartDashboard.putNumber("Swerve Module " + id + " Angle", angle);
		
		if (encoder != null)
			SmartDashboard.putNumber("Swerve Module " + id + " Encoder Value", encoder.get());
	}

	@Override
	protected double returnPIDInput()
	{
		return encoder.get();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		rotationMotor.set(output);
	}

	@Override
	protected void initDefaultCommand()
	{
	}
}