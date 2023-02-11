package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;


@Autonomous(name="AutonomousTesting")
public class AutonomousBlue extends LinearOpMode {


    @Override
    public void runOpMode() {
        MecanumRobot robot = new MecanumRobot();
        robot.init(hardwareMap, this);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap,this);
        drive.setPoseEstimate(new Pose2d(-34.33, 61.70, Math.toRadians(270)));
        robot.closeClaw();
        boolean once = true;
        waitForStart();
        robot.armUp(5);
       TrajectorySequence go = drive.trajectorySequenceBuilder(new Pose2d(-34.33, 61.70, Math.toRadians(270)))
               .lineToConstantHeading(new Vector2d(-26,59))
               .addTemporalMarker(1, ()-> {robot.armUp(13.9);})
               .build();

       TrajectorySequence go2 = drive.trajectorySequenceBuilder(go.end())
               .lineToConstantHeading(new Vector2d(-26,52))
               .addDisplacementMarker(()->{robot.openClaw();})
               .back(4).
               build();
        TrajectorySequence go3 = drive.trajectorySequenceBuilder(go2.end())
                .strafeLeft(15)
                .build();
        TrajectorySequence go4 = drive.trajectorySequenceBuilder(go3.end())
                .lineToConstantHeading(new Vector2d(-11,10)).build();


       drive.followTrajectorySequence(go);
       drive.followTrajectorySequence(go2);
       drive.followTrajectorySequence(go3);
       drive.followTrajectorySequence(go4);



    }
}
