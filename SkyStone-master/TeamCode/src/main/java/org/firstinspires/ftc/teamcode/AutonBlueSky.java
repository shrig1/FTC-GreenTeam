package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpmode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="AutoBlueSky", group="Linear Opmode")
public class AutonBlueSky extends LinearOpMode 
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    
	// Put stage timings at top of script to make config easy
    double ticks = 0; // DO NOT EDIT
    double firstStage  = 0;
	double secondStage = firstStage + 8000;
	double thirdStage  = secondStage + 4000;
    double fourthStage = thirdStage + 0;
    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

       
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        
      
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
	}
}

@Override
void loop() {    
	// run until the end of the match (driver presses STOP)
    while (opModeIsActive()) {
		ticks++;
		// Show the elapsed game time and wheel power.
		if(ticks > firstStage && ticks < secondStage) {
			leftDrive.setPower(1.0);
			rightDrive.setPower(1.0);
		} else if(ticks > secondStage && ticks < thirdStage) {
			leftDrive.setPower(-1.0);
			rightDrive.setPower(1.0);
        } else if(ticks > thirdStage && ticks < fourthStage) {
			leftDrive.setPower(1.0);
			rightDrive.setPower(1.0);
		} else {
			leftDrive.setPower(0.0);
			rightDrive.setPower(0.0);
		}
	}
}
