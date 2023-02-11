package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DeviceMap {

    private final DcMotor frontRight,frontLeft,backLeft,backRight,powerLed,colorLed;
    private final DcMotorEx arm;


    private final Servo claw;
    private final DistanceSensor rangeSensor;

    public DeviceMap(HardwareMap map){
        // define & initializing motors & Servos
        frontLeft = map.get(DcMotor.class,"frontLeft");
        backLeft = map.get(DcMotor.class,"backLeft");
        frontRight = map.get(DcMotor.class,"frontRight");
        backRight = map.get(DcMotor.class,"backRight");
        arm = map.get(DcMotorEx.class,"Arm");

        powerLed = map.get(DcMotor.class,"power");
        colorLed = map.get(DcMotor.class,"LED");

        claw = map.get(Servo.class,"claw");
        rangeSensor = map.get(DistanceSensor.class, "sensor_distance");
    }

    // MOTOR GETTERS
    public  DcMotor getFrontLeft(){return frontLeft;}
    public  DcMotor getBackLeft(){return backLeft;}
    public  DcMotor getFrontRight(){return frontRight;}
    public  DcMotor getBackRight(){return backRight;}
    public  DcMotorEx getArm(){return arm;}
    public DcMotor getColorLed(){return colorLed;}
    public DcMotor getPowerLed(){return powerLed;}
    // SERVO GETTERS
    public  Servo getClaw(){return claw;}

    public  DistanceSensor getRangeSensor(){return rangeSensor;}

}
