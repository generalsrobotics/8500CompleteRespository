package org.firstinspires.ftc.teamcode;

import android.os.Environment;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CheckConfig() {
    private boolean currentA;
    private boolean currentB;
    private boolean isRed;
    private boolean isLeft;
    public CheckConfig(HardwareMap map, opMode opmode) {
        currentA = gamepad.a;
        currentB = gamepad.b;

        opmode.telemetry.addLine("Which Position is the robot on?");
        opmode.telemetry.addLine("if bot is on the right press A, or press B if on the left.");

        if(currentA) isLeft = false;
        else if(CurrentB) isLeft= true;


    }
    public boolean isLeft(){
        return isLeft;
    }


}
