package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;

@Autonomous(name = "AutoTesting", group = "Autonomous")
public class AutoTesting extends OpMode
{
    private DcMotor DriveL = null;
    private DcMotor DriveR = null;
    private DcMotor ShooterL = null;
    private DcMotor ShooterR = null;
    private DcMotor Intake = null;
    private Servo  Gate= null;
    private Servo Feeder = null;


    @Override
    public void init()
    {

        DriveL = hardwareMap.dcMotor.get("left_drive");
        DriveR = hardwareMap.dcMotor.get("right_drive");

        ShooterL = hardwareMap.dcMotor.get("shooterl");
        ShooterR = hardwareMap.dcMotor.get("shooterr");
        Intake = hardwareMap.dcMotor.get("intake_drive                                                                                                                                                                                  ");
        Feeder = hardwareMap.servo.get("feeder");
        Gate = hardwareMap.servo.get("stopper");

    }

    @Override

    public void loop(){


    }


    public void start()
    {

        DriveL.setPower(1);
        DriveR.setPower(1);


        try {
            sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        telemetry.addData("uh oh","stinky poopy monkey");
        telemetry.update();


        DriveL.setPower(-1);
        DriveR.setPower(1);

    }
}
