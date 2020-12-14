/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  VictorSP intake;
  /**
   * Creates a new Intake.
   */
  public Intake() {
    intake = new VictorSP(Constants.INTAKE);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeBall(XboxController controller,double speed){
    intake.set(controller.getRawAxis(Constants.RIGHT_TRIGGER)*speed);
  }
  public void stop(){
    intake.set(0);
  }
}
