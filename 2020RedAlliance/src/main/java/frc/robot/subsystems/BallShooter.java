/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 */
public class BallShooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private PWMTalonSRX frontShooterTalon1 = new PWMTalonSRX(6);
  private PWMTalonSRX frontShooterTalon2 = new PWMTalonSRX(6);
  private PWMTalonSRX backShooterTalon1 = new PWMTalonSRX(6);
  private PWMTalonSRX backShooterTalon2 = new PWMTalonSRX(6);
  private PWMTalonSRX hoodTalon = new PWMTalonSRX(5);

  public static BallShooter shooter;

  public BallShooter() {}

  public static BallShooter getInstance() {
    if (shooter == null) {
      shooter = new BallShooter();
    }
    return shooter;
  }


  public void setFrontShooterPow1(double speed) {
    frontShooterTalon1.set(speed);
  }

  public void setFrontShooterPow2(double speed) {
    frontShooterTalon2.set(speed);
  }

  public void setBackShooterPow1(double speed) {
    backShooterTalon1.set(speed);
  }

  public void setBackShooterPow2(double speed) {
    backShooterTalon2.set(speed);
  }

  
  public void setHoodPow(double speed) {
    hoodTalon.set(speed);
  }

  @Override
  public void initDefaultCommand() {}

  @Override
  public void periodic() {
    if (OI.getArcJoy().getRawButton(RobotMap.backInButton)){
      setHoodPow(0.2);
      setBackShooterPow1(0.2);
      setBackShooterPow2(0.2);
      setFrontShooterPow1(0);
      setFrontShooterPow2(0);
    } else if (OI.getArcJoy().getRawButton(RobotMap.backOutButton)){
      setHoodPow(-0.2);
      setBackShooterPow1(-0.2);
      setBackShooterPow2(-0.2);
      setFrontShooterPow1(0);
      setFrontShooterPow2(0);
    } else if (OI.getArcJoy().getRawButton(RobotMap.frontInButton)) {
      setHoodPow(0);
      setBackShooterPow1(0);
      setBackShooterPow2(0);
      setFrontShooterPow1(0.5);
      setFrontShooterPow2(0.5);
    }
  }
}
