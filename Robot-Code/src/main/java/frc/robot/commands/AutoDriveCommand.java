/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class AutoDriveCommand extends Command {
	public AutoDriveCommand() {
		requires(Robot.driveSubsystem);
	}
	private double LLtx;
	private double LLty;
	private double LLta;
	public boolean hi;

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	NetworkTable LimeLightTable = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry LLtx = LimeLightTable.getEntry("tx");
	NetworkTableEntry LLty = LimeLightTable.getEntry("ty");
	NetworkTableEntry LLta = LimeLightTable.getEntry("ta");
	boolean hi = true;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (OI.driverController.getRawButton(1) == true)
			if (LLta < 5) {
				//Robot.driveSubsystem.robotTankDrive(.4, .4);
				System.out.print("Driving Forward");
			}

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
