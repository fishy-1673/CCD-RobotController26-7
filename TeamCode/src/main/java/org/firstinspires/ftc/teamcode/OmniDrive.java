//Version 25-26 2.4.3
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.DepSystems.DriveTrain;
//import org.firstinspires.ftc.teamcode.systems.Indexer;
//import org.firstinspires.ftc.teamcode.systems.Intake;
//import org.firstinspires.ftc.teamcode.systems.Launcher;

import java.util.List;


@TeleOp(name="OmniDrive", group="Linear OpMode")

public class OmniDrive extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();

    boolean unlockedSP = true;
    /** @noinspection SpellCheckingInspection*/
    boolean islockIS = false;
    double SP;
    double FS;

    @Override
    public void runOpMode() {
        DriveTrain Omni = new DriveTrain(hardwareMap);
        //Launcher Shoot = new Launcher(hardwareMap);
       // Intake Take = new Intake(hardwareMap);
       // Indexer Index = new Indexer(hardwareMap);
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();

       // Take.OSS(true);

        while (opModeIsActive()) {


            double dly =  gamepad1.left_stick_y;
            double dlx =  gamepad1.left_stick_x;
            double drx =  gamepad1.right_stick_x;
            /*double clt = gamepad2.left_trigger;
            double crt = gamepad2.right_trigger;*/
            double  drt = gamepad1.right_trigger;
            double dlt = gamepad1.left_trigger;
             Omni.Drive(dly+drt-dlt, dlx, drx); //for trigger control too.
            //original: Omni.Drive(dly, dlx, drx);
            /*if(unlockedSP){
                SP = clt;
                Shoot.speed(SP);
            }
            if (gamepad1.yWasPressed()){
                Take.ROS();
            }
            if (gamepad1.yWasReleased()){
                Take.OSS(true);
            }
            if (gamepad2.yWasPressed()){
                unlockedSP = !unlockedSP;
            }
            if (gamepad1.xWasPressed()){
                islockIS = !islockIS;}
            if (!islockIS){
                Take.intakeSpeed(drt-dlt);
            }
            if (gamepad2.dpad_up) Index.Index(0);
            else if (gamepad2.dpad_left) Index.Index(1);
            else if (gamepad2.dpad_right) Index.Index(2);

            if (gamepad2.xWasPressed()) Index.Load(0);
            else if (gamepad2.aWasPressed()) Index.Load(1);
            else if (gamepad2.bWasPressed()) Index.Load(2);
            //adjust to edit zone that the trigger will fire in, changes fire sensitivity
            Index.Eject(crt>0.75);
            */
            // Show any telemetry deemed relevant
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine(Omni.getTel() );
            //telemetry.addLine(" unlocked SP: " + unlockedSP + "locked InS: "+ islockIS +Shoot.getTel()+Index.getTel()+Take.getTel()))
            telemetry.update();
        }
    }}
