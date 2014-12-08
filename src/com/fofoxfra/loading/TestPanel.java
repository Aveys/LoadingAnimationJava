package com.fofoxfra.loading;

import java.awt.*;
import javax.swing.*;

         public class TestPanel extends JFrame {
       public TestPanel() {
             super("Tennis");
             setSize(550, 450);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             LoadingWavyPanel animation = new LoadingWavyPanel();
             Container pane = getContentPane();
             pane.add(animation);
             setContentPane(pane);
             setVisible(true);
           }

               public static void main(String[] arguments) {
             TestPanel frame = new TestPanel();
           }
     }