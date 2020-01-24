package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;




@TeleOp(name="WIPARM_TELEOP_FINALE", group="Linear Opmode")

public class TeleOpFinal_Copy extends LinearOpMode {

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
            //double armPower         = gamepad2.left_stick_y;
            
            arm.setTargetPosition(arm.getTargetPosition() + Math.round(gamepad2.left_stick_y * 10));
            
            
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
                rightIntake.setPower(rightIntakePower*-1.0);
            } else {
                rightIntake.setPower(rightIntakePower);
            }
            if(gamepad1.left_bumper) {
                leftIntake.setPower(leftIntakePower*-1.0);
            } else {
                leftIntake.setPower(leftIntakePower);
            }
            if(gamepad1.dpad_left) {
                leftIntakePivot.setPosition(leftIntakePivot.getPosition()-0.001);
            }
            if(gamepad1.dpad_right) {
                leftIntakePivot.setPosition(leftIntakePivot.getPosition()+0.001);
            }
            if(gamepad1.x) {
                rightIntakePivot.setPosition(rightIntakePivot.getPosition()-0.001);
            }
            if(gamepad1.b) {
                rightIntakePivot.setPosition(rightIntakePivot.getPosition()+0.001);
            }
            if(gamepad2.right_bumper) {
                finger.setPosition(finger.getPosition()+0.001);
            }
            if(gamepad2.left_bumper) {
                finger.setPosition(finger.getPosition()-0.001);
            }
            if(finger.getPosition() > 0.7) {
                finger.setPosition(0.7);
            }
            if(finger.getPosition() < 0.05) {
                finger.setPosition(0.05);
            }
            if(gamepad2.a) {
                finger.setPosition(0.05);
            }
            if(gamepad2.b) {
                finger.setPosition(0.7);
            }
            if(gamepad2.dpad_left){
                wrist.setPosition(1.0);
            }
            if(gamepad2.dpad_right){
                wrist.setPosition(-1.0);
            }
            if(gamepad2.right_stick_x > 0.05) {
                wrist.setPosition(wrist.getPosition() + (0.1 * gamepad2.right_stick_x));
            } else if(gamepad2.right_stick_x < -0.05) {
                wrist.setPosition(wrist.getPosition() - (0.1 * gamepad2.right_stick_x));
                
            }
            
            /* 
            if(gamepad2.left_stick_button) {
                arm.setPower(armPower);
            } else {
                arm.setPower(armPower * 0.75);
            }
            */
            
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Servos:", "finger (%.2f), wrist (%.2f), leftIntakePivot (%.2f), rightIntakePivot(%.2f)", finger.getPosition(), wrist.getPosition(), leftIntakePivot.getPosition(), rightIntakePivot.getPosition() );
            // telemetry.addData("Arm Data:", "target (%.2f), current (%.2f)", arm.getTargetPosition(), arm.getCurrentPosition());
            // telemetry.addData("Servos", "left (%.2f), right (%.2f)", "wrist (%.2f)", leftIntakePivot.getPosition(), rightIntakePivot.getPosition(), wrist.getPosition());
            telemetry.update();
        }
    }
}
