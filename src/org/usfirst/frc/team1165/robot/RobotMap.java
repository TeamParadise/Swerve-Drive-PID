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
		// translation talon, rotation talon, encoder port
		{ 0, 1, 0 },
		{ 2, 3, 1 },
		{ 4, 5, 2 },
		{ 6, 7, 3 }
	};

	public static final int[] RESET_ENCODERS = { 268, 107, 349, 330 };//358, 197, 79, 152 };
}
