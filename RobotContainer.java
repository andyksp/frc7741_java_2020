/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ShootBall;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.AutonomousOne;
import frc.robot.commands.AutonomousTwo;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveToDistance;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Drivetrain declare
  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoystick;
  private final DriveForwardTimed driveForwardTimed;
  private final DriveToDistance driveToDistance;
  public static XboxController driverJoystick;

  private final Shooter shooter;
  private final ShootBall shootBall;
  private final AutoShoot autoShoot; 

  private final Intake intake;
  private final IntakeBall intakeBall;

  private final AutonomousOne autonomousOne;
  private final AutonomousTwo autonomousTwo; 

  SendableChooser<Command> chooser = new SendableChooser<>();
   
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveTrain = new DriveTrain();
    driveWithJoystick = new DriveWithJoysticks(driveTrain);
    driveWithJoystick.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoystick);

    driveForwardTimed = new DriveForwardTimed(driveTrain);
    driveForwardTimed.addRequirements(driveTrain);
     
    driveToDistance = new DriveToDistance(driveTrain);
    driveToDistance.addRequirements(driveTrain);

    driverJoystick = new XboxController(Constants.JOYSTIC_NUMBER);

    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);

    autoShoot = new AutoShoot(shooter);
    autoShoot.addRequirements(shooter);

    intake = new Intake();
    intakeBall = new IntakeBall(intake);
    intakeBall.addRequirements(intake);
    intake.setDefaultCommand(intakeBall);

    autonomousOne = new AutonomousOne(driveTrain , shooter);
    autonomousTwo = new AutonomousTwo(driveTrain , shooter);
    
      chooser.addOption("Autonomous Two", autonomousTwo);
      chooser.setDefaultOption("Autonomous One", autonomousOne);
      SmartDashboard.putData("Autonomous", chooser);

     UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
     camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    JoystickButton shootButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperRight.value);
    shootButton.whileHeld(new ShootBall(shooter));

    JoystickButton aButton = new JoystickButton(driverJoystick, XboxController.Button.kA.value);
    aButton.whenPressed(new DriveToDistance(driveTrain));

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}
