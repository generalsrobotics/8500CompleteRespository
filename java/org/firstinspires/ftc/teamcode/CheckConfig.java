package org.firstinspires.ftc.teamcode;

import android.os.Environment;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CheckConfig {
    private String position;
    private String teamColor;
    private boolean isRed;
    private boolean isLeft;
    public CheckConfig() {}


       public void Init(OpMode opMode){
        try {
            FileInputStream inputStream = new FileInputStream(new File(String.format("%s/FIRST/java/src/org/firstinspires/ftc/teamcode/RobotConfig.txt", Environment.getExternalStorageDirectory().getAbsolutePath())));
            if(inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                position = bufferedReader.readLine().split(":")[1].trim();
                teamColor = bufferedReader.readLine().split(":")[1].trim();
                inputStream.close();
                opMode.telemetry.addData("TeamColor: %s",teamColor);
                opMode.telemetry.addData("Robot Position: %s", position);

                isLeft = position.equalsIgnoreCase("L");
                isRed = teamColor.equalsIgnoreCase("R");

            }
        }catch (Exception e){
            opMode.telemetry.addData("exception", "Error reading file config file: " + e.toString());
        }


    }

    public boolean isRed(){
        return isRed ;
    }

    public boolean isLeft(){
        return isLeft;
    }

//    @Override
//    public String toString(){
//        return String.format("Robot Position: %s \nTeam Color: %s ", position, teamColor);
//    }

}
