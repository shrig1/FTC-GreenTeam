package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;


@Autonomous(name="Auto Finale", group="Iterative Opmode")
public class AutoFinal extends OpMode 
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor rightIntake = null;
    private DcMotor leftIntake = null;

    public Servo leftIntakePivot = null;
    public Servo rightIntakePivot = null;
    NormalizedColorSensor colorSensor = null;
    
    public static final int coreHexEncode = 288;
    public static final int dcMotorEncode = 2240;

    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

       
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        
        rightIntake = hardwareMap.get(DcMotor.class, "right_intake");
        leftIntake = hardwareMap.get(DcMotor.class, "left_intake");
        
        leftIntakePivot = hardwareMap.get(Servo.class, "left_intake_pivot");
        rightIntakePivot = hardwareMap.get(Servo.class, "right_intake_pivot");
        
        
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        
        leftIntake.setDirection(DcMotor.Direction.REVERSE);
        
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftIntake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        

    }

 
    @Override
    public void init_loop() {
    }
    @Override
    public void start() {
        runtime.reset();
    }
    @Override
    public void loop() {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);        
        leftDrive.setTargetPosition(1833);
        rightDrive.setTargetPosition(1833);
    
    while(rightDrive.getCurrentPosition() < rightDrive.getTargetPosition() && leftDrive.getCurrentPosition() < leftDrive.getTargetPosition()) {

        
        leftDrive.setPower(1);
        rightDrive.setPower(1);
    }
    leftDrive.setPower(0);
    rightDrive.setPower(0);
    /*
    INSERT CODE TO TURN HERE. 
    
    INSERT CODE TO GRAB BUILD SITE HERE.
    
    CODE TO MOVE BACKWARDS TO BUILDING ZONE.
        leftDrive.setTargetPosition(INSERT NUMBER HERE);
        rightDrive.setTargetPosition(INSERT NUMBER HERE);
        
    while(rightDrive.getCurrentPosition() < rightDrive.getTargetPosition() && leftDrive.getCurrentPosition() < leftDrive.getTargetPosition()) {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        leftDrive.setPower(-1);
        rightDrive.setPower(-1);
    }
    
    leftDrive.setPower(0);
    rightDrive.setPower(0);
    
    INSERT CODE TO PARK UNDERNEATH BRIDGE.
    
    */    

    }

    @Override
    public void stop() {
    }

}
