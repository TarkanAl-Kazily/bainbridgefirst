// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4915.ArcadeDriveRobot.commands;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4915.ArcadeDriveRobot.Robot;
public class WindLauncher extends Command {
    private boolean shouldQuit;
    public WindLauncher() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.launcher);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("WindLauncher initialized");
        Robot.launcher.pneumaticsReverse();
        shouldQuit = false;
        // do not wind if harvester is up
        if (Robot.harvester.isHarvesterUp()) {
            shouldQuit = true;
            return;
        } else {
            setTimeout(4.5);
        }
        setInterruptible(false);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (((Talon) Robot.launcher.getWindingMotor()).isSafetyEnabled()) {
            System.out.println("Winding SetSafetyEnabled is true");
        }
        else {
            System.out.println("Winding SetSafetyEnabled is false");
        }
        if (!shouldQuit) {
            Robot.launcher.startWindingMotor(1.0);
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean result;
        result = true;
        
        if (shouldQuit) {
            System.out.println("WindLauncher: Quit flag is set to true");
        }
        else if (isTimedOut()) {
            System.out.println("WindLauncher: Timed out");
        }
        else if (Robot.launcher.getLimitSwitchForLauncherDownValue()) {
            System.out.println("WindLauncher: Limit switch reached");
        }
        else {
            System.out.println("WindLauncher: Is NOT finished");
            result = false;
        }
        return result;
    }
    // Called once after isFinished returns true
    protected void end() {
        System.out.println("WindLauncher end");
        Robot.launcher.stopWindingMotor();
        Robot.launcher.setLaunchedBall(false);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        /*
         System.out.println("WindLauncher has been interrupted with launched ball = " + Robot.launcher.hasLaunchedBall());
         end();
         Robot.launcher.setLaunchedBall(true);
         System.out.println("WindLauncher has been ended with launched ball = " + Robot.launcher.hasLaunchedBall());
         */
    }
}
