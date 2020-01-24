package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@Disabled
@TeleOp(name="TeleOpSingle", group="Linear Opmode")

public class TeleOpSingle extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive   = null;
    private DcMotor rightDrive  = null;
    private DcMotor leftAfterburn  = null;
    private DcMotor rightAfterburn = null;
    private DcMotor leftIntake  = null;
    private DcMotor rightIntake = null;
    private DcMotor arm = null;
    private Servo wrist = null;
    private Servo finger = null;
    private Servo leftIntakePivot = null;
    private Servo rightIntakePivot = null;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

       
        leftDrive   = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive  = hardwareMap.get(DcMotor.class, "right_drive");
        leftIntake  = hardwareMap.get(DcMotor.class, "left_intake");
        rightIntake = hardwareMap.get(DcMotor.class, "right_intake");
        leftAfterburn  = hardwareMap.get(DcMotor.class, "left_afterburner");
        rightAfterburn = hardwareMap.get(DcMotor.class, "right_afterburner");
        arm     = hardwareMap.get(DcMotor.class, "arm");
        wrist   = hardwareMap.get(Servo.class, "wrist");
        finger  = hardwareMap.get(Servo.class, "finger");
        leftIntakePivot     = hardwareMap.get(Servo.class, "left_intake_pivot");
        rightIntakePivot    = hardwareMap.get(Servo.class, "right_intake_pivot");
        
        
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        leftIntake.setDirection(DcMotor.Direction.REVERSE);
        rightIntake.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);
        //boolean slowmode = true;
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Setup a variable for each drive wheel to save power level for telemetry
            /*double leftPower;
            double rightPower;
            double leftIntakePower;
            double rightIntakePower;*/
            //double armPower;
            double wristPos;
            //double 
            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            // double drive = -gamepad1.left_stick_y;
            // double turn  =  gamepad1.right_stick_x;
            /*
            if(gamepad1.right_bumper && slowmode) {
                slowmode = false;
            } else if(gamepad1.right_bumper && !slowmode) {
                slowmode = true;
            }
            */   
            double leftPower        = -gamepad1.left_stick_y;
            double rightPower       = -gamepad1.right_stick_y;
            double leftIntakePower  = gamepad1.left_trigger;
            double rightIntakePower = gamepad1.right_trigger;
            double armPower         = gamepad2.left_stick_y/2;
            
            // leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            // rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;


            
           

            // Send calculated power to wheels
            if(!gamepad1.left_stick_button) {
                leftDrive.setPower(leftPower);
                leftAfterburn.setPower(leftPower);
            } else {
                leftDrive.setPower(leftPower);
            }
            if(!gamepad1.right_stick_button) {
                rightAfterburn.setPower(-rightPower);
                rightDrive.setPower(rightPower);
            } else {
                rightDrive.setPower(rightPower);
            }
            if(gamepad1.right_bumper) {
                rightIntake.setPower(-0.75);
            } else {
                rightIntake.setPower(rightIntakePower*1);
            }
            if(gamepad1.left_bumper) {
                leftIntake.setPower(-0.75);
                
            } else {
                leftIntake.setPower(leftIntakePower*1);
            }
            if(gamepad1.dpad_left) {
                leftIntakePivot.setPosition(leftIntakePivot.getPosition()-0.001);
            }
            if(gamepad1.dpad_right) {
                leftIntakePivot.setPosition(leftIntakePivot.getPosition()+0.001);
            }
            if(gamepad1.dpad_up) {
                rightIntakePivot.setPosition(rightIntakePivot.getPosition()-0.001);
            }
            if(gamepad1.dpad_down) {
                rightIntakePivot.setPosition(rightIntakePivot.getPosition()+0.001);
            }
            if(gamepad1.right_bumper && gamepad1.right_trigger != 0.0){
                finger.setPosition(finger.getPosition()+0.001);
            } else if (gamepad1.right_bumper) {
                finger.setPosition(finger.getPosition()-0.001);
            }
            if(gamepad1.b) {
                finger.setPosition(finger.getPosition()-0.001);
            }
            if(gamepad1.x){
                wrist.setPosition(1.0);
            }
            if(gamepad1.a){
                wrist.setPosition(-1.0);
            }
             
            if(gamepad1.left_stick_button) {
                arm.setPower(-1.0);
            } else {
                arm.setPower(1.0*armPower);
            }
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            // telemetry.addData("Servos", "left (%.2f), right (%.2f)", "wrist (%.2f)", leftIntakePivot.getPosition(), rightIntakePivot.getPosition(), wrist.getPosition());
            telemetry.update();
        }
    }
}