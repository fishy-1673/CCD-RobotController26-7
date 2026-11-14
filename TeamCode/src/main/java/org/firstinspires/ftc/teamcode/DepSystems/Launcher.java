//Version 25-26 2.0.1
package org.firstinspires.ftc.teamcode.DepSystems;


import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher {


    private DcMotor S1;
    private DcMotor S2;

    private double SP = 0;
    public Launcher(@NonNull HardwareMap hardwareMap) {
        //initialize the motors and servos so they can actually be used
        S1 = hardwareMap.get(DcMotor.class, "S1");
        S2 = hardwareMap.get(DcMotor.class, "S2");


        S1.setDirection(DcMotor.Direction.REVERSE);
        S2.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    //takes a value and gives it to the flywheels
    public void speed(double s) {

        SP=s;
        S1.setPower(SP);
        //adjusted value here because this motor is much faster and we want some backspin
        S2.setPower(SP);


    }
// used to be a few more functions here but all got migrated somwhere else
    public String getTel() {
        return (" Launcher power: " + SP );
    }

    }