// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4915.ArcadeDriveRobot;
import org.usfirst.frc4915.ArcadeDriveRobot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton intakeDownButton;
    public JoystickButton intakeUpButton;
    public JoystickButton ejectBallButton;
    public JoystickButton stopHarvesterWheelsButton;
    public JoystickButton turn180;
    public Joystick joystickDrive;
    public JoystickButton secondaryIntakeUp;
    public JoystickButton secondaryIntakeDown;
    public JoystickButton launchCommandGroupButton;
    public JoystickButton windCommandGroupButton;
    public Joystick secondaryJoystick;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        secondaryJoystick = new Joystick(2);
        
        windCommandGroupButton = new JoystickButton(secondaryJoystick, 11);
        windCommandGroupButton.whenPressed(new WindCommandGroup());
        launchCommandGroupButton = new JoystickButton(secondaryJoystick, 10);
        launchCommandGroupButton.whenPressed(new LaunchCommandGroup());
        secondaryIntakeDown = new JoystickButton(secondaryJoystick, 6);
        secondaryIntakeDown.whenPressed(new IntakeDown());
        secondaryIntakeUp = new JoystickButton(secondaryJoystick, 7);
        secondaryIntakeUp.whenPressed(new IntakeUp());
        joystickDrive = new Joystick(1);
        
        turn180 = new JoystickButton(joystickDrive, 5);
        turn180.whenPressed(new Turn180());
        stopHarvesterWheelsButton = new JoystickButton(joystickDrive, 9);
        stopHarvesterWheelsButton.whenPressed(new ToggleHarvesterWheels());
        ejectBallButton = new JoystickButton(joystickDrive, 2);
        ejectBallButton.whenPressed(new IntakeRelease());
        intakeUpButton = new JoystickButton(joystickDrive, 4);
        intakeUpButton.whenPressed(new IntakeUp());
        intakeDownButton = new JoystickButton(joystickDrive, 3);
        intakeDownButton.whenPressed(new IntakeDown());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Launch Command Group", new LaunchCommandGroup());
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Start Compression", new StartCompression());
        SmartDashboard.putData("Stop Compression", new StopCompression());
        SmartDashboard.putData("Wind Launcher", new WindLauncher());
        SmartDashboard.putData("Intake Up", new IntakeUp());
        SmartDashboard.putData("Intake Down", new IntakeDown());
        SmartDashboard.putData("PID Turn 180", new PIDTurn180());
        SmartDashboard.putData("Launch", new Launch());
        SmartDashboard.putData("Wind Command Group", new WindCommandGroup());
        SmartDashboard.putData("Autonomous Command Group", new AutonomousCommandGroup());
        SmartDashboard.putData("Toggle Harvester Wheels", new ToggleHarvesterWheels());
        SmartDashboard.putData("Move Up To Distance", new MoveUpToDistance());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystickDrive() {
        return joystickDrive;
    }
    public Joystick getSecondaryJoystick() {
        return secondaryJoystick;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
