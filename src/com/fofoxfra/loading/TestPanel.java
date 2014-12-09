package com.fofoxfra.loading;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

public class TestPanel extends JFrame {
    public TestPanel() {
        super("Loading Animation Test");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoadingWavyPanel animation = new LoadingWavyPanel();
        Container pane = getContentPane();
        pane.add(animation);
        setContentPane(pane);
        this.setBackground(Color.DARK_GRAY);
        setVisible(true);
        ExecutorService execute = Executors.newSingleThreadExecutor();
        execute.execute(animation);
    }
    public static void main(String[] arguments) {
        TestPanel frame = new TestPanel();
    }
}