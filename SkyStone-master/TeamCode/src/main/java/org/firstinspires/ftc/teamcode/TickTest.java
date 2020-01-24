
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@Disabled
@Autonomous(name="TickTest", group="Linear Opmode")

public class TickTest extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private double ticks = 0.0;
    private DcMotor leftDrive   = null;
    private DcMotor rightDrive  = null;
    @Override
    public void runOpMode() {
        // telemetry.addData("Status", "Initialized");
        telemetry.update();
        //telemetry.addData();
        leftDrive   = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive  = hardwareMap.get(DcMotor.class, "right_drive");
        waitForStart();
        runtime.reset();
        

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            ticks++;
            // Show the elapsed game time and wheel power.
            if(ticks < 10888.0) {
                leftDrive.setPower(1.0);
                rightDrive.setPower(1.0);
            } else {
                leftDrive.setPower(0.0);
                rightDrive.setPower(0.0);
            }
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "ticks (%.2f)", ticks);
            // telemetry.addData("Servos", "left (%.2f), right (%.2f)", "wrist (%.2f)", leftIntakePivot.getPosition(), rightIntakePivot.getPosition(), wrist.getPosition());
            telemetry.update();
        }
    }
}
