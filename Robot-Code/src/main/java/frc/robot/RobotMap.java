/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Speeds
	public static double robotDriveSpeed = .4;
	public static double hatchIntakeSpeed = .5;
	public static double ballIntakeSpeed = .4;

	//Motor Controllers
		//Drive Train
			//Le
				public static int leftDriveMasterPort = 10;
				public static int leftDriveSlavePort = 11;

			//Right
				public static int rightDriveMasterPort = 12;
				public static int rightDriveSlavePort = 13;
		//Ball Intake
			public static int ballIntakePort = 14;
		//Hatch Intake
			public static int hatchIntakePort = 15;

	//Controllers
		//USB
			public static int driverController = 0;
			public static int operatorController = 1;

	//Invert Motors
		//Drive Train
			public static boolean leftDriveInverted = false;
			public static boolean rightDriveInverted = true;
		//Intakes
			public static boolean ballIntakeInverted = false;
			public static boolean hatchIntakeInverted = true;
	
}
