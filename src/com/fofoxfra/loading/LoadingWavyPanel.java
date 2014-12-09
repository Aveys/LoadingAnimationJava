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
            listBalls.add(new Ellipse2D.Double(100 + 15 * i + 30, getY(i, timeStep), BALL_HEIGHT, BALL_HEIGHT));
        }

    }

    public void paintComponent(Graphics comp) {
        Graphics2D g = (Graphics2D) comp;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for(Ellipse2D.Double ep : listBalls){
            g.fill(ep);
        }
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timeStep++;

    }

    public void moveBall(){
        for(int i=0;i<NB_BALL;i++){
            listBalls.get(i).y=getY(i, timeStep)*20;
        }
    }
    public int getY(int i, int j)
    {   double intermediaire = ((timeStep * (i + 0.08)) % (2*Math.PI))/10;
        double debug = 0 + BALL_HEIGHT * (1 + Math.sin(intermediaire));
        System.out.println("Valeur de Y calculée pour la point "+i+":"+intermediaire+"  - "+debug);
        return (int) debug;
    }

    @Override
    public void run() {
        while(true){
            repaint();
            moveBall();
            removeAll();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}