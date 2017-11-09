package org.usfirst.frc.team1165.robot.commandgroups;

import org.usfirst.frc.team1165.robot.commands.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest1 extends CommandGroup {

    public AutoTest1()
    {
    	addSequential(new DriveStraight(0.3, 360), 1);
    	addSequential(new DriveStraight(0.3, 90), .5);
    	addSequential(new DriveStraight(0.3, 330), .5);
    }
}
