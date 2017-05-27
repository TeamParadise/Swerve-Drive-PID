package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderPID extends PIDSubsystem
{
	private static final double kP = 1.00;
	private static final double kI = 0.00;
	private static final double kD = 0.00;

	private static final double TOLERANCE = 10;
		
	private static int encoderID;
	
	private double output;

	public EncoderPID()
	{
		super(kP, kI, kD);
    	
    	setInputRange(0, 360);
    	setOutputRange(-.75, .75);
    	setAbsoluteTolerance(TOLERANCE);
    	        
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
	
	}
	
	public void setEncoderID(int encoderID)
	{
		EncoderPID.encoderID = encoderID;
	}

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput()
	{
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return Robot.driveTrain.modules[encoderID].encoder.get();
	}

	protected void usePIDOutput(double output)
	{
		this.output = output;
		SmartDashboard.putNumber("PID output", output);
	}
	
	public double getOutput()
	{
		return output;
	}
}