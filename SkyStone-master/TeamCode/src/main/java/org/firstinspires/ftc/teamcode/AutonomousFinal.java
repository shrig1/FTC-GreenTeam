package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;


@Autonomous(name="Auto Finale", group="Iterative Opmode")
public class Auto_Finale extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor rightIntake = null;
    private DcMotor leftLntake = null;

    public Servo leftIntakePivot = null;
    public Servo rightIntakePivot = null;
    
    public static final int coreHexEncode = 288;
    public static final int dcMotorEncode = 2240;

    NormalizedColorSensor colorSensor;
    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

       
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        
        rightIntake = hardwareMap.get(DcMotor.class, "left_intake");
        leftIntake = hardwareMap.get(DcMotor.class, "right_intake");
        
        leftIntakePivot = hardwareMap.get(DcMotor.class, "left_intake_pivot");
        rightIntakePivot = hardwareMap.get(DcMotor.class, "right_intake_pivot");
        

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        
        leftIntake.setDirection(DcMotor.Direction.REVERSE);
        
        leftDrive.RunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.RunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightIntake.RunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftIntake.RunMode(DcMotor.RunMode.RUN_USING_ENCODER); 
       
        telemetry.addData("Status", "Initialized");
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
     
        
        
        double leftPower;
        double rightPower;
        
        double intakePower
        
        

    }

    @Override
    public void stop() {
    }

}
