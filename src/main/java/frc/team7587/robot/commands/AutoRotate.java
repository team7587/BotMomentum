/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team7587.robot.Robot;

public class AutoRotate extends Command {

  private double rotateAngle;
  private int inErrZoneCount;

  public AutoRotate(double angle) {
    this.rotateAngle = angle;
    requires(Robot.m_driveTrain);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.m_driveTrain.rotateAngle(this.rotateAngle);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Robot.m_driveTrain.testGyro();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double err = Robot.m_driveTrain.getTurnController().getError();
    if( Math.abs(err)<2.0 ){
      return (++inErrZoneCount) >= 5;   // after 5 consecutive inZone test
    }else{
      inErrZoneCount = 0;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveTrain.stop();
    Robot.m_driveTrain.getTurnController().close();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
