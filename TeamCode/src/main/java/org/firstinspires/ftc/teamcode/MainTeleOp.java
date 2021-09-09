package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MainTeleOp") // Names the OP mode in the phone menu
public class MainTeleOp extends LinearOpMode {

    /*
    $$$$$$$\                      $$\                               $$\     $$\
    $$  __$$\                     $$ |                              $$ |    \__|
    $$ |  $$ | $$$$$$\   $$$$$$$\ $$ | $$$$$$\   $$$$$$\  $$$$$$\ $$$$$$\   $$\  $$$$$$\  $$$$$$$\   $$$$$$$\
    $$ |  $$ |$$  __$$\ $$  _____|$$ | \____$$\ $$  __$$\ \____$$\\_$$  _|  $$ |$$  __$$\ $$  __$$\ $$  _____|
    $$ |  $$ |$$$$$$$$ |$$ /      $$ | $$$$$$$ |$$ |  \__|$$$$$$$ | $$ |    $$ |$$ /  $$ |$$ |  $$ |\$$$$$$\
    $$ |  $$ |$$   ____|$$ |      $$ |$$  __$$ |$$ |     $$  __$$ | $$ |$$\ $$ |$$ |  $$ |$$ |  $$ | \____$$\
    $$$$$$$  |\$$$$$$$\ \$$$$$$$\ $$ |\$$$$$$$ |$$ |     \$$$$$$$ | \$$$$  |$$ |\$$$$$$  |$$ |  $$ |$$$$$$$  |
    \_______/  \_______| \_______|\__| \_______|\__|      \_______|  \____/ \__| \______/ \__|  \__|\_______/
     */

    private Motor frontLeft, frontRight, backLeft, backRight; // Drivetrain Motors
    private GamepadEx gPad;
    private MecanumDrive drivetrain; // The Drivetrain
    private ToggleButtonReader buttonReaderY1, buttonReaderA1, buttonReaderX1, buttonReaderB1, buttonReaderdPadUp1, buttonReaderdPadDown1, buttonReaderdPadRight1, buttonReaderdPadLeft1; // Toggle Buttons on Gamepad 1
    private ButtonReader rightTrigger1, leftTrigger1; // Triggers of controller

    @Override
    public void runOpMode() throws InterruptedException {

        /*
         /$$$$$$           /$$   /$$     /$$           /$$ /$$                       /$$     /$$
        |_  $$_/          |__/  | $$    |__/          | $$|__/                      | $$    |__/
          | $$   /$$$$$$$  /$$ /$$$$$$   /$$  /$$$$$$ | $$ /$$ /$$$$$$$$  /$$$$$$  /$$$$$$   /$$  /$$$$$$  /$$$$$$$   /$$$$$$$
          | $$  | $$__  $$| $$|_  $$_/  | $$ |____  $$| $$| $$|____ /$$/ |____  $$|_  $$_/  | $$ /$$__  $$| $$__  $$ /$$_____/
          | $$  | $$  \ $$| $$  | $$    | $$  /$$$$$$$| $$| $$   /$$$$/   /$$$$$$$  | $$    | $$| $$  \ $$| $$  \ $$|  $$$$$$
          | $$  | $$  | $$| $$  | $$ /$$| $$ /$$__  $$| $$| $$  /$$__/   /$$__  $$  | $$ /$$| $$| $$  | $$| $$  | $$ \____  $$
         /$$$$$$| $$  | $$| $$  |  $$$$/| $$|  $$$$$$$| $$| $$ /$$$$$$$$|  $$$$$$$  |  $$$$/| $$|  $$$$$$/| $$  | $$ /$$$$$$$/
        |______/|__/  |__/|__/   \___/  |__/ \_______/|__/|__/|________/ \_______/   \___/  |__/ \______/ |__/  |__/|_______/
         */

        // Initialize Drivetrain Motors
        frontLeft = new Motor(hardwareMap, "frontLeft");
        frontRight = new Motor(hardwareMap, "frontRight");
        backLeft = new Motor(hardwareMap, "backLeft");
        backRight = new Motor(hardwareMap, "backRight");

        // Initialize drivetrain
        drivetrain = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);

        // Initialize Gamepads
        gPad = new GamepadEx(gamepad1);

        // Initialize Gamepad Buttons
        buttonReaderX1 = new ToggleButtonReader(gPad, GamepadKeys.Button.X);
        buttonReaderY1 = new ToggleButtonReader(gPad, GamepadKeys.Button.Y);
        buttonReaderA1 = new ToggleButtonReader(gPad, GamepadKeys.Button.A);
        buttonReaderB1 = new ToggleButtonReader(gPad, GamepadKeys.Button.B);

        // Initialize Other Gamepad Buttons
        leftTrigger1 = new ButtonReader(gPad, GamepadKeys.Button.LEFT_BUMPER);
        rightTrigger1 = new ButtonReader(gPad, GamepadKeys.Button.RIGHT_BUMPER);

        buttonReaderdPadUp1 = new ToggleButtonReader(gPad, GamepadKeys.Button.DPAD_UP);
        buttonReaderdPadDown1 = new ToggleButtonReader(gPad, GamepadKeys.Button.DPAD_DOWN);
        buttonReaderdPadLeft1 = new ToggleButtonReader(gPad, GamepadKeys.Button.DPAD_LEFT);
        buttonReaderdPadRight1 = new ToggleButtonReader(gPad, GamepadKeys.Button.DPAD_RIGHT);

        /*
        ▒█▀▀▀ █░█ ▀▀█▀▀ █▀▀█ █▀▀█ 　 ▒█▀▀▀█ █▀▀ ▀▀█▀▀ █░░█ █▀▀█
        ▒█▀▀▀ ▄▀▄ ░░█░░ █▄▄▀ █▄▄█ 　 ░▀▀▀▄▄ █▀▀ ░░█░░ █░░█ █░░█
        ▒█▄▄▄ ▀░▀ ░░▀░░ ▀░▀▀ ▀░░▀ 　 ▒█▄▄▄█ ▀▀▀ ░░▀░░ ░▀▀▀ █▀▀▀
         */

        // Disable encoders on drivetrain motors
        frontLeft.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Now that initalization setup is done, wait for start button to be pressed
        waitForStart();

        /*
         _______                         __      __
        /       \                       /  |    /  |
        $$$$$$$  | __    __  _______   _$$ |_   $$/  _____  ____    ______
        $$ |__$$ |/  |  /  |/       \ / $$   |  /  |/     \/    \  /      \
        $$    $$< $$ |  $$ |$$$$$$$  |$$$$$$/   $$ |$$$$$$ $$$$  |/$$$$$$  |
        $$$$$$$  |$$ |  $$ |$$ |  $$ |  $$ | __ $$ |$$ | $$ | $$ |$$    $$ |
        $$ |  $$ |$$ \__$$ |$$ |  $$ |  $$ |/  |$$ |$$ | $$ | $$ |$$$$$$$$/
        $$ |  $$ |$$    $$/ $$ |  $$ |  $$  $$/ $$ |$$ | $$ | $$ |$$       |
        $$/   $$/  $$$$$$/  $$/   $$/    $$$$/  $$/ $$/  $$/  $$/  $$$$$$$/
         */

        // This runs in a loop while the robot is running in TeleOp and hasn't been stopped.
        while(opModeIsActive() && !isStopRequested()) {

            drivetrain.driveRobotCentric(gPad.getLeftX(), gPad.getLeftY(), gPad.getRightX());

            // Takes the status of each button (whether it is being pressed or not)
            buttonReaderA1.readValue();
            buttonReaderB1.readValue();
            buttonReaderX1.readValue();
            buttonReaderY1.readValue();

            buttonReaderdPadUp1.readValue();
            buttonReaderdPadDown1.readValue();
            buttonReaderdPadLeft1.readValue();
            buttonReaderdPadRight1.readValue();

            // getState() on a buttonReader returns either true or false.

            // telemetry examples
            // this prints onto the phone stats about the running robot, useful for debugging and diagnosing issues.
            telemetry.addData("frontLeft Maximum RPM", frontLeft.getMaxRPM());
            telemetry.addData("frontRight Maximum RPM", frontRight.getMaxRPM());
            telemetry.update(); // needed at end for telemetry to show up



        }


    }
}
