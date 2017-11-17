package org.usfirst.frc.team1165.robot.commandgroups;

import org.usfirst.frc.team1165.robot.commands.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest1 extends CommandGroup {

    public AutoTest1()
    {
//    	addSequential(new DriveStraight(0.3, 270), 1);
//    	addSequential(new DriveStraight(0.3, 180), 1);
//    	addSequential(new DriveStraight(0.3, 45), Math.sqrt(2));

    	addSequential(new DriveStraight(0.3, 0), 1);
    	addSequential(new DriveStraight(0.3, 90), 1);
    	addSequential(new DriveStraight(0.3, 225), Math.sqrt(2));
    }
}