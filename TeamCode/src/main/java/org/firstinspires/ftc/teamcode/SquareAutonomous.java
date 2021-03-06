package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.vuforia.Vec3F;


//Program should allow robot to move in a square pattern using a list of destinations
@Autonomous(name = "SquareAutonomous", group = "Autonomous")
public class SquareAutonomous extends OpMode
{
    private FieldNavigationBot1 nav;
    //private ExampleAttachment attachment;

    //Vec3F is a location structured as (x,y,rotation)
    private Vec3F[] navPoints;
    private int waypointIndex = 0;
    private boolean reachedDestination = true;

    @Override
    public void init()
    {
        telemetry.addData("SA Line: ", 28);
        nav = new FieldNavigationBot1(this);
        telemetry.addData("SA Line: ", 30);
        //attachment = new ExampleAttachment(this);
        nav.Init();
        telemetry.addData("SA Line: ", 33);
        //attachment.Init();

        navPoints  = new Vec3F[]{
                new Vec3F(-48, -48, 0),
                new Vec3F(48, -48, 90),
                new Vec3F(48, 48, 180),
                new Vec3F(-48, 48, 270)
        };
    }

    @Override
    public void start()
    {
        nav.Start();
    }

    @Override
    public void loop()
    {
        nav.Loop();
        telemetry.addData("SA Line: ", 48);
        telemetry.update();
        //attachment.Loop();
        if(reachedDestination) //navigate to next waypoint
        {
            //get vector data and set destination
            Vec3F target = navPoints[waypointIndex];
            float[] data = target.getData();
            nav.NavigateToLocation(data[0],data[1],data[2]);
            reachedDestination = false;

            if(waypointIndex >= navPoints.length -1)//reached end
            {
                waypointIndex = 0; //reset
            }
            else waypointIndex +=1; //add to index

            if(waypointIndex == 1)
            {
                //attachment.Run();
            }
        }
        else //check if done navigating
        {
            if(nav.CheckCloseEnoughDistance() && nav.CheckCloseEnoughRotation())
            {
                reachedDestination = true;
            }
        }
    }
}
