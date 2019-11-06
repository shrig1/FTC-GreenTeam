
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;




@TeleOp(name="TELEOP_FINALE", group="Linear Opmode")

public class TeleOpFinal extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive   = null;
    private DcMotor rightDrive  = null;
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
            double armPower         = gamepad2.left_stick_y;
            
            // leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            // rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;


            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            if(gamepad1.left_stick_button) {
                leftDrive.setPower(leftPower/2.0);
                //rightDrive.setPower(rightPower/2.0);
            } else {
                leftDrive.setPower(leftPower);
                //rightDrive.setPower(rightPower);
            }
            if(gamepad1.right_stick_button) {
                rightDrive.setPower(rightPower/2.0);
            } else {
                rightDrive.setPower(rightPower);
            }
            if(gamepad1.right_bumper) {
                rightIntake.setPower(rightIntakePower/2.0);
            } else {
                rightIntake.setPower(rightIntakePower);
            }
            if(gamepad1.left_bumper) {
                leftIntake.setPower(leftIntakePower/2.0);
            } else {
                leftIntake.setPower(leftIntakePower);
            }
            if(gamepad1.dpad_left) {
                leftIntakePivot.setPosition(leftIntakePivot.getPosition()-0.005);
            }
            if(gamepad1.dpad_right) {
                leftIntakePivot.setPosition(leftIntakePivot.getPosition()+0.005);
            }
            if(gamepad1.x) {
                rightIntakePivot.setPosition(rightIntakePivot.getPosition()-0.005);
            }
            if(gamepad1.b) {
                rightIntakePivot.setPosition(rightIntakePivot.getPosition()+0.005);
            }
            if(gamepad2.right_bumper){
                finger.setPosition(finger.getPosition()+0.05);
            }
             if(gamepad2.left_bumper){
                finger.setPosition(finger.getPosition()-0.05);
            }
            if(gamepad2.dpad_left){
                wrist.setPosition(wrist.getPosition()+0.05);
            }
            if(gamepad2.dpad_right){
                wrist.setPosition(wrist.getPosition()-0.05);
            }
             
            
            if(gamepad2.left_stick_button) {
                arm.setPower(armPower/2.0);
            } else {
                arm.setPower(armPower);
            }
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
