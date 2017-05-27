package util;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Swerve
{
	public static double getMax(double twist)
	{
		if(twist == 0)
			return 1;
		double[] max = new double[2]; 
		
		for(int i=0;i<RobotMap.NUMBER_OF_WHEELS;i++)
		{
			if(max[0] < Math.abs(RobotMap.DISTANCES[i][0]))
				max[0] = Math.abs(RobotMap.DISTANCES[i][0]);
			if(max[1] < Math.abs(RobotMap.DISTANCES[i][1]))
				max[1] = Math.abs(RobotMap.DISTANCES[i][1]);
		}
		
		return Math.sqrt(Math.pow((1 + max[1]), 2) + Math.pow((1 + max[0]), 2));
	}

	public static void display(double x, double y, double twist)
	{
		double A = x - twist * RobotMap.LENGTH / 2.0;
		double B = x + twist * RobotMap.LENGTH / 2.0;
		double C = x - twist * RobotMap.WIDTH / 2.0;
		double D = x + twist * RobotMap.WIDTH / 2.0;
		
		SmartDashboard.putNumber("A", A);
		SmartDashboard.putNumber("B", B);
		SmartDashboard.putNumber("C", C);
		SmartDashboard.putNumber("D", D);
	}

}
