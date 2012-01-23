/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    //Declare variables for Victors
    Victor leftM,rightM;
    
    //Declare Joysticks
    Joystick leftStick, rightStick;
    
    //Declare RobotDrive
    RobotDrive roboDR;
    
    //Declare DriveMode boolean
    boolean isArcadeDrive;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        leftM=new Victor(1,3);
        rightm=new Victor(1,4);
        
        roboDR=new RobotDrive(leftM,rightM);
        leftStick=new Joystick(2);
        rightStick=new Joystick(1);
        isArcadeDrive=false;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called Continously during operator control
     */
    public void teleopContinous() {
        //Drive Selection
        if(rightStick.getRawButton(3))isArcadeDrive=true;
        else if(rightStick.getRawButton(2))isArcadeDrive=false;
        
        if(isArcadeDrive) //ArcadeDrive
            roboDR.arcadeDrive(rightStick,true);
        else //TankDrive
            roboDR.tankDrive(leftStick,rightStick);
    }
}
