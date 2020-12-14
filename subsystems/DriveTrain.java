/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  VictorSP leftFront;
  VictorSP rightFront;
  VictorSP leftBack;
  VictorSP rightBack;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drive;
  private final AnalogInput rangeFinder;


  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    //User 4 motor controller
    leftFront = new VictorSP(Constants.LEFT_FRONT);
    leftFront.setInverted(false);
    rightFront = new VictorSP(Constants.RIGHT_FRONT);
    rightFront.setInverted(true);
    leftBack = new VictorSP(Constants.LEFT_BACK);
    leftBack.setInverted(false);
    rightBack = new VictorSP(Constants.RIGHT_BACK);
    rightBack.setInverted(true);

    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(leftMotors, rightMotors);
    rangeFinder = new AnalogInput(Constants.RANGE_FINDER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed){
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);   
  }

  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
  }

  public boolean driverToDistance(double setPointDistance, double speed){
    while(rangeFinder.getAverageVoltage() > setPointDistance)
    {
      driveForward(speed);
    }
    return true;
  }

  public void stop(){
    drive.stopMotor();
  }
}
