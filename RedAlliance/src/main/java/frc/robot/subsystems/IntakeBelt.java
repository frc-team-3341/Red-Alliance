/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.RobotMap;


public class IntakeBelt extends Subsystem {
  
  public TalonSRX intakemotor = new TalonSRX(RobotMap.intakePort);
  
  public static IntakeBelt intakebelt;
  public boolean upIntake;
  public boolean downIntake;

  public static IntakeBelt GetInstance() {
    if (intakebelt == null){
      intakebelt = new IntakeBelt();
    }
    return intakebelt;
  }

  public IntakeBelt() {
    intakemotor.setInverted(false);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void intakeMovement() {
    upIntake = OI.getJoy().getRawButtonPressed(2);
    downIntake = OI.getJoy().getRawButtonPressed(3);

    if (upIntake == true){
      intakemotor.set(ControlMode.PercentOutput, 0.2);
    }
    else if (downIntake == true){
      intakemotor.set(ControlMode.PercentOutput, -0.4);
    }
    else {
      intakemotor.set(ControlMode.PercentOutput, 0);
    }


  }


}
