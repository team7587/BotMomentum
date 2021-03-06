/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team7587.robot.subsystems;

import edu.wpi.first.wpilibj.DMC60;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team7587.robot.OI;

/**
 * Add your docs here.
 */
public class Ramp extends Subsystem {
  private final SpeedController rampMotor = new DMC60(OI.RAMP_MOTOR);
  //DigitalInput stopUpSwitch = new DigitalInput(OI.STOP_UP_SWITCH);
  // DigitalInput stopDownSwitch = new DigitalInput(OI.STOP_DOWN_SWITCH);

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new RampHold());
  }

  // public boolean upLimitReached() {
  //   return stopUpSwitch.get();
  // }

  // public boolean downLimitReached() {
  // return stopDownSwitch.get();
  // }

  // positive counterclockwise, negative clockwise
  public void rampUp() {
    rampMotor.set(-0.75);
  }

  public void rampDown() {
    rampMotor.set(0.75);
  }

  public double rampGet() {
    return rampMotor.get();
  }

  public void stop() {
    // rampMotor.stopMotor();
    rampMotor.set(0);
  }
}
