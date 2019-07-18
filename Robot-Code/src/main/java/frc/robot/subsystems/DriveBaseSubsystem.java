/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Imports Drive Base Motors, Makes left side inverted, sets all to coast and makes
 * all the motors only drivable by the myDriveBase() command that takes a 
 * {Double leftSpeed, Double rightSpeed} 
 * THIS IS THE ONLY WAY YOU CAN CONTROL THE DRIVE BASE
 * THIS IS TO MAKE SURE THEY ALL GO THE SAME DIRECTION
 */
public class DriveBaseSubsystem extends Subsystem {
	
	//Imports motors Left then Right.

	//Left Side
	private static TalonSRX leftDriveMaster = new TalonSRX(RobotMap.leftDriveMasterPort);
	private static VictorSPX leftDriveSlave = new VictorSPX(RobotMap.leftDriveSlavePort);

	//Right Side
	private static TalonSRX rightDriveMaster = new TalonSRX(RobotMap.rightDriveMasterPort);
	private static VictorSPX rightDriveSlave = new VictorSPX(RobotMap.rightDriveSlavePort);

	//Makes a control function, MOTORS CON ONLY BE CONTROLLED THROUGH HERE
	//Pass the joystick.getRawAxis to this function, It will take care of the rest
	public void robotTankDrive(double LeftDriveSpeed, double RightDriveSpeed){
		//SETS ALL MOTORS TO COAST
		leftDriveMaster.setNeutralMode(NeutralMode.Coast);
		leftDriveSlave.setNeutralMode(NeutralMode.Coast);
		rightDriveMaster.setNeutralMode(NeutralMode.Coast);
		rightDriveSlave.setNeutralMode(NeutralMode.Coast);

		//MAKES SLAVES FOLLOW MASTERS
		leftDriveSlave.follow(leftDriveMaster);
		rightDriveSlave.follow(rightDriveMaster);
		
		//PULLS INVERT SETTTINGS FROM ROBOTMAP
		leftDriveMaster.setInverted(RobotMap.leftDriveInverted);
		leftDriveSlave.setInverted(RobotMap.leftDriveInverted);
		rightDriveMaster.setInverted(RobotMap.rightDriveInverted);
		rightDriveSlave.setInverted(RobotMap.rightDriveInverted);

		//Pulls the LeftSpeed and RightSpeed and drives the master motors
		leftDriveMaster.set(ControlMode.PercentOutput, LeftDriveSpeed);
		rightDriveMaster.set(ControlMode.PercentOutput, RightDriveSpeed);
	}

	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(Robot.manualDriveCommand);
	}
}