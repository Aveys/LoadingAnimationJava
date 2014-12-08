package com.fofoxfra.loading;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.util.*;

import static java.lang.Math.PI;

public class LoadingWavyPanel extends JPanel implements Runnable {
    Thread runner;

    private int timeStep=0;
    private final int NB_BALL = 24;
    private final int BALL_HEIGHT = 10;
    private ArrayList<Ellipse2D.Double> listBalls;
    public LoadingWavyPanel() {
        super();
        listBalls = new ArrayList<Ellipse2D.Double>();
        for (int i=0;i<NB_BALL;i++){
            listBalls.add(new Ellipse2D.Double(200 + 5 * i+30, getY(i, timeStep), BALL_HEIGHT, BALL_HEIGHT));
        }
        runner = new Thread(this);
        runner.start();
    }

    public void paintComponent(Graphics comp) {
        Graphics2D g = (Graphics2D) comp;
        for(Ellipse2D.Double ep : listBalls){
            g.draw(ep);
        }
        timeStep++;

    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread) {
            for(int i=0;i<NB_BALL;i++){
                listBalls.get(i).y=getY(i, timeStep);
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) { }
        }
    }
    public int getY(int i, int j)
    {
        return (int)(260 + BALL_HEIGHT/2 * (1 + Math.sin((((timeStep * ((i / 500) + 0.02)) % 2) * PI))));
    }
}