package org.firstinspires.ftc.teamcode.auto.condition;

import org.firstinspires.ftc.teamcode.module.*;

public class Distance extends Condition {
    private double goalTick;
    private double avgTick;
    private Motor[] motors;
    private double[] initialEncoders;
    private double[] tickDiffs;

    public Distance(Motor[] m, double tick) {
        goalTick = tick;
        motors = new Motor[m.length];
        initialEncoders = new double[m.length];
        tickDiffs = new double[m.length];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = m[i];
        }
    }

    public void init() {
        for (int i = 0; i < motors.length; i++) {
            initialEncoders[i] = motors[i].getEncoder();
        }
    }

    public boolean loop() {
        avgTick = 0;
        for (int i = 0; i < motors.length; i++) {
            tickDiffs[i] = motors[i].getEncoder() - initialEncoders[i];
            avgTick += tickDiffs[i];
        }
        avgTick = (avgTick / motors.length);
        return (avgTick >= goalTick);
    }
}
