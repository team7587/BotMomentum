/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.team7587.robot.Robot;

/**
 * Have the robot drive tank style using the logitech F310 gamepad
 */
public class TeleopDrive extends Command {

  Joystick stick = Robot.m_oi.getLogiJoy();

  public TeleopDrive() {
    requires(Robot.m_driveTrain);
  }

  // arcade drive with joystick
  @Override
  protected void execute() {
    /* Competition Code */ Robot.m_driveTrain.drive(stick.getThrottle() * stick.getY(),
        0.75 * stick.getTwist() * Math.abs(stick.getThrottle()));
    // /*Oct. 5th Fair Code*/ Robot.m_driveTrain.drive(stick.getThrottle() *
    // stick.getY() * 0.25, 0.75 * stick.getTwist() *
    // Math.abs(stick.getThrottle()));
  }

  @Override
  protected boolean isFinished() {
    return false; // Runs until interrupted
  }

  @Override
  protected void end() {

  }

}
