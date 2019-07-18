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
 * Add your docs here.
 */
public class HatchIntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
	private static VictorSPX hatchIntake = new VictorSPX(RobotMap.hatchIntakePort);

	public void setHatchIntakeSpeed(double IntakeSpeed) {
		hatchIntake.setNeutralMode(NeutralMode.Brake);

		hatchIntake.setInverted(RobotMap.hatchIntakeInverted);

		hatchIntake.set(ControlMode.PercentOutput, IntakeSpeed);
	}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(Robot.hatchIntakeCommand);
  }
}
