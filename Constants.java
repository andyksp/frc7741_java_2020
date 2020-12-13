/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //4 motor controller's PWM ID
	public static final int LEFT_FRONT = 0;
	public static final int RIGHT_FRONT = 1;
	public static final int LEFT_BACK = 2;
    public static final int RIGHT_BACK = 3;
	public static final int SHOOTER = 4;
	public static final int INTAKE = 5;
	//Analog input
	public static final int RANGE_FINDER = 0;
	//joystick's left y and x axis ID
	public static final int XBOX_LEFT_Y_AXIS = 1;
	public static final int XBOX_LEFT_X_AXIS = 0;
	public static final int RIGHT_TRIGGER = 3;
	//drivetrain speed 0.1~1.0
	public static final double DRIVETRAINSPEED = 0.7;
	public static final double DRIVE_FORWARD_TIME = 3.0;
	public static final double AUTONOMOUS_SPEED = 0.4;
	//joystick usb number
	public static final int JOYSTIC_NUMBER = 0;
	public static final double SHOOTER_SPEED = 0.5;
	public static final double INTAKE_SPEED = 0.7;
	public static final int CAMERA_RES_X = 320;
	public static final int CAMERA_RES_Y = 240;
	public static final double AUTO_SHOOT_TIME = 2.0;
	public static final double SETPOINT_FORWARD = 1.5;
	
	
	
	
}
