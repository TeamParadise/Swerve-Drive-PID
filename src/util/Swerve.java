package util;

import org.usfirst.frc.team1165.robot.RobotMap;
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
}
