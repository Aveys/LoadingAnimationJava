package com.fofoxfra.loading;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.util.*;

import static java.lang.Math.PI;

public class LoadingWavyPanel extends JPanel implements Runnable{
    Thread runner;

    private int timeStep=0;
    private final int NB_BALL = 24;
    private final int BALL_HEIGHT = 10;
    private ArrayList<Ellipse2D.Double> listBalls;
    public LoadingWavyPanel() {
        super();
        listBalls = new ArrayList<Ellipse2D.Double>();
        for (int i=0;i<NB_BALL;i++) {
            listBalls.add(new Ellipse2D.Double(200 + 15 * i + 30, getY(i, timeStep), BALL_HEIGHT, BALL_HEIGHT));
        }

    }

    public void paintComponent(Graphics comp) {
        Graphics2D g = (Graphics2D) comp;
        for(Ellipse2D.Double ep : listBalls){
            g.draw(ep);
        }
        timeStep++;

    }

    public void moveBall(){
            for(int i=0;i<NB_BALL;i++){
                listBalls.get(i).y=getY(i, timeStep);
            }
    }
    public double getY(int i, int j)
    {
        double debug = (260 + BALL_HEIGHT/2 * (1 + Math.sin((((timeStep * ((i / 500) + 0.02)) % (2 * PI))))));
        return debug;
    }

    @Override
    public void run() {
        while(true){
            repaint();
            moveBall();
            removeAll();
        }
    }
}