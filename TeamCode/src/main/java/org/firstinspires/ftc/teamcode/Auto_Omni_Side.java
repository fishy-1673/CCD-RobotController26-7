
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.DepSystems.DriveTrain;
import org.firstinspires.ftc.teamcode.DepSystems.Intake;


@Autonomous(name="Auto Omni side", group="Robot")

public class Auto_Omni_Side extends LinearOpMode {
    public void Wait(double time, String Telemetry){
        ElapsedTime r = new ElapsedTime();
        r.reset();
        while (opModeIsActive() && (r.seconds() < time)) {

            telemetry.addLine(Telemetry+"time: " + r.seconds());

            telemetry.update();
        }
    }
    private ElapsedTime runtime = new ElapsedTime();
    // Send telemetry message to signify robot waiting;
    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        DriveTrain omni = new DriveTrain(hardwareMap);

        Intake Intake = new Intake(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();
        omni.Drive(0.25,0,0);
        Wait(2,"Driving");
        omni.Drive(0,0,0);
        Wait(1, "stop");
        omni.Drive(0,0.5, 0);
        Wait(6,"Driving left");
        omni.Drive(0,0,0);



    }
        // Wait for the game to start (driver presses START)



}
