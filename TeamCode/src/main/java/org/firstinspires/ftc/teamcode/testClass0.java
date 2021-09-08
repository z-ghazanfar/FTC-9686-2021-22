package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "urdad")
public class testClass0 extends LinearOpMode {
    private Motor frontLeft, backLeft, frontRight, backRight;

    private SimpleServo servo;
    private GamepadEx gamepad1, gamepad2;
    private MecanumDrive mecDrive;

    private ToggleButtonReader buttonX, buttonY, buttonA, buttonB, dUp, dDown, dLeft, dRight;

    private ButtonReader triggerLeft, triggerRight;

    @Override
    public void runOpMode() throws InterruptedException {

    }
    //urmom

}