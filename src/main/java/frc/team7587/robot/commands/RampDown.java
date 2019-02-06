/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team7587.robot.Robot;

/**
 * Add your docs here.
 */
public class RampDown extends TimedCommand {
  /**
   * Add your docs here.
   */
  public RampDown(double timeout) {
    super(timeout);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.arm.reverse();
  }

  // Called repeatedly when this Command is scheduled to run
  // @Override
  // protected void execute() {
  // }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.arm.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  // @Override
  // protected void interrupted() {
  // }
}
