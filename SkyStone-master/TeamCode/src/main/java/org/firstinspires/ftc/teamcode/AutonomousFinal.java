package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@Autonomous(name="Auto Finale", group="Iterative Opmode")
public class Auto_Finale extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor intakeRight = null;
    private DcMotor intakeLeft = null;

    public Servo servo1 = null;
    public Servo servo2 = null;
    public Servo servo3 = null;
    public Servo servo4 = null;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

       
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

       
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
