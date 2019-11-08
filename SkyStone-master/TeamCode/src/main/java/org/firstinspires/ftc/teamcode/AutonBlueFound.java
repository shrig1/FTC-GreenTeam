package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpmode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@Autonomous(name="AutoBlueFound", group="Linear Opmode")
public class AutonBlueFound extends LinearOpMode 
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
   

    

    double ticks = 0;
    

    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

       
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        
      
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        
 
    
        
    }
@Override
 void loop() {
       
    

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            ticks++;
            // Show the elapsed game time and wheel power.
            if(ticks > 0 && ticks < ticks*0.5){
            leftDrive.setPower(1);
            rightDrive.setPower(1);
            
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        
        if(ticks > ticks*0.5 && ticks < ticks*1.2){
            leftDrive.setPower(-1);
            rightDrive.setPower(1);
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        if(ticks > ticks*1.2 && ticks < ticks*2.5){
            leftDrive.setPower(1);
            rightDrive.setPower(1);
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        
      }
        
        }
    }

