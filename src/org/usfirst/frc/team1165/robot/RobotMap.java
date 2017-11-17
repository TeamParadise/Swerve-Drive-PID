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
		{ WIDTH/2, -LENGTH/2 }
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
	
	public static final int[] RESET_ENCODERS = { 279, 95, 350, 82 }; // twist works
//	public static final int[] RESET_ENCODERS = { 189, 5, 260, 352 }; // twist does not work
//	public static final int[] RESET_ENCODERS = { 99, 275, 170, 262 }; // twist works
//	public static final int[] RESET_ENCODERS = { 9, 185, 80, 172 }; // twist does not work
}
