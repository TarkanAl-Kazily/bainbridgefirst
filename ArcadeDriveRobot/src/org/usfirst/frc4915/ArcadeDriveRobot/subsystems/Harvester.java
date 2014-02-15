// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4915.ArcadeDriveRobot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4915.ArcadeDriveRobot.Robot;
import org.usfirst.frc4915.ArcadeDriveRobot.RobotMap;
/**
 *
 */
public class Harvester extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid pneumaticAnglers = RobotMap.harvesterPneumaticAnglers;
    SpeedController collectionWheels = RobotMap.harvesterCollectionWheels;
    DigitalInput testForBall = RobotMap.harvesterTestForBall;
    DigitalInput magneticSwitchBottom = RobotMap.harvesterMagneticSwitchBottom;
    DigitalInput magneticSwitchTop = RobotMap.harvesterMagneticSwitchTop;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static final int INTAKE = 1;
    public static final int EXPEL = 2;
    private final double VOLTAGE_GOOD = 0.5;
    private final double VOLTAGE_LOW_1 = 0.6;
    private final double VOLTAGE_LOW_2 = 0.8;
    private final double VOLTAGE_BAD = 1.0;
    private double wheelSpeed = 0.5;
    public double getHarvesterSpeed(int direction) {
        //Check the battery voltage and adjust harvesterWheel speed to compensate for lower values
        if (Robot.batteryVoltage >= 11.5) {
            wheelSpeed = VOLTAGE_GOOD;
        }
        else if (Robot.batteryVoltage < 11.5 && Robot.batteryVoltage >= 11.0) {
            wheelSpeed = VOLTAGE_LOW_1;
        }
        else if (Robot.batteryVoltage < 11.0 && Robot.batteryVoltage >= 10.5) {
            wheelSpeed = VOLTAGE_LOW_2;
        }
        else {
            wheelSpeed = VOLTAGE_BAD;
        }
        System.out.println("wheelSpeed: " + wheelSpeed);
        //Return wheelSpeed based on requested direction
        if (direction == INTAKE) {
            return -1.0 * wheelSpeed;
        }
        else if (direction == EXPEL) {
            return wheelSpeed;
        }
        else {
            return 0.0;
        }
    }
    
    public boolean getLimitSwitchBallLoaded() {
        return testForBall.get(); // true if ball is inside the loader and intake is complete
    }
    
    public boolean isHarvesterDown() {
        return !(magneticSwitchTop.get()); // is false if magnetic switch is near magnet -- fully retracted // true if extended at all
    }
    
    public boolean isHarvesterUp() {
        return !(magneticSwitchBottom.get()); // is false if magnetic switch is near magnet  -- fully extended // true if retracted at all
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void extendPneumatics() {
        pneumaticAnglers.set(DoubleSolenoid.Value.kForward);
    }
    
    public void retractPneumatics() {
        pneumaticAnglers.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void stopPneumatics() {
        pneumaticAnglers.set(DoubleSolenoid.Value.kOff);
    }
    
    public void stopWheels() {
        collectionWheels.set(0.0);
    }
    
    public void setWheelSpeed(double speed) {
        collectionWheels.set(speed);
    }
}
