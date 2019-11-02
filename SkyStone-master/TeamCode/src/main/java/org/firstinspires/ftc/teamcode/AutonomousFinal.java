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
    private DcMotor intakeRight = null;
    private DcMotor intakeLeft = null;

    public Servo intakePivotLeft = null;
    public Servo intakePivotRight = null;

    NormalizedColorSensor colorSensor;
    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

       
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        
        intakeRight = hardwareMap.get(DcMotor.class, "left_intake");
        intakeLeft = hardwareMap.get(DcMotor.class, "right_intake");
        
        intakePivotLeft = hardwareMap.get(DcMotor.class, "left_intake_pivot");
        intakePivotRight = hardwareMap.get(DcMotor.class, "right_intake_pivot");
        

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        
        intakeLeft.setDirection(DcMotor.Direction.REVERSE);
       
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

       leftDrive.setPower(leftPower);
       rightDrive.setPower(rightPower);
    }

    @Override
    public void stop() {
    }

}
