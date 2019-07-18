/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * This houses all the raw code for the elevator, It Imports the motor(s) and makes
 * a function to control the Ball Intake *YOU CAN ONLY CONTROL THE MOTOR(S) THROUGH THIS
 * FUNCTION* [elvatorSpeed(double speed)]
 * It then tells the motor(s) to run on %output at that speed.
 */
public class BallIntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static VictorSPX ballIntake = new VictorSPX(RobotMap.ballIntakePort);

  public void setBallIntakeSpeed(double IntakeSpeed) {
		ballIntake.setNeutralMode(NeutralMode.Brake);

		ballIntake.setInverted(RobotMap.hatchIntakeInverted);

		ballIntake.set(ControlMode.PercentOutput, IntakeSpeed);
	}

  @Override
  public void initDefaultCommand() {
	setDefaultCommand(Robot.ballIntakeCommand);
  }
}
