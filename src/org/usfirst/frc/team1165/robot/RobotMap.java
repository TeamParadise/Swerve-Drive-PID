package org.usfirst.frc.team1165.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	public static final int NUMBER_OF_WHEELS = 4;
	
	public static final double LENGTH = 72;
	public static final double WIDTH = 52;
	
	public static final double[][] DISTANCES =
	{
		{ WIDTH/2, LENGTH/2 },
		{ -WIDTH/2, LENGTH/2 },
		{ -WIDTH/2, -LENGTH/2 },
		{ WIDTH/2, -LENGTH/2 },
	};
	
	public static final int JOYSTICK_PORT = 0;

	public static final int[][] CANTALON_DRIVE_PORTS =
	{
		{ 0, 1, 0, 1 },
		{ 2, 3, 2, 3 },
		{ 4, 5, 6, 7 },
		{ 6, 7, 4, 5 }
	};

}
