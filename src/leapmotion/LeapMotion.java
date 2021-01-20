package leapmotion;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Math;
import sun.audio.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

class LeapMotion extends Listener {

    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    double palmPointX, palmPointY, palmPointZ;

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

    public void onFrame(Controller controller) {
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();

        //Get hands
        for (Hand hand : frame.hands()) {
            // Get the hand's normal vector and direction
            Vector normal = hand.palmNormal();
            Vector direction = hand.direction();
            Vector AmbilPalm = hand.palmPosition();

            palmPointX = AmbilPalm.getX();
            palmPointY = AmbilPalm.getY();
            palmPointZ = AmbilPalm.getZ();

            Mapping(palmPointX, palmPointY, palmPointZ);

            System.out.println("Nilai X :" + palmPointX);
            System.out.println("Nilai Y :" + palmPointY);
            System.out.println("Nilai Z :" + palmPointZ);
            System.out.println("\n\n");

        }
    }

    public static void SuaraSatu() {
        InputStream iAudio;
        

        try {
            //iAudio = new FileInputStream(new File("E:\\redondo ta\\dung.wav"));
            iAudio = new FileInputStream(new File("D:\\POLITEKNIK\\TA\\2017\\LABORAN\\TES\\SuaraSatu.wav"));
            AudioStream iMusic = new AudioStream(iAudio);
            AudioPlayer.player.start(iMusic);
            Thread.sleep(200);
           
        } catch (Exception e) {
        }
        
    }
    
    public static void SuaraDua() {
        InputStream iAudio;

        try {
            iAudio = new FileInputStream(new File("D:\\POLITEKNIK\\TA\\2017\\LABORAN\\TES\\SuaraDua.wav"));
            AudioStream iMusic = new AudioStream(iAudio);
            AudioPlayer.player.start(iMusic);
            Thread.sleep(200);

        } catch (Exception e) {
        }
    }

    public static void Mapping(double X, double Y, double Z) {
        if (Y > 150 & Y < 300 & Z < 60 & Z > -70 & X <= 40 & X >= -20){
            Main.basmarawis2();
            SuaraSatu();
        } else if (Y > 300 & Y < 500 & Z < 60 & Z > -120 & X <= 30 & X >= -20){
            Main.marawis3();
            SuaraDua();
        } else if (Y > 10 & Y < 150 & Z < 60 & Z > -60 & X <= 40 & X >= -20){
            Main.marawis3();
            SuaraDua();
        } else if (Z < 300 & Z > 50 & Y > 50 & Y < 350 & X <= 40 & X >= -5){
            Main.marawis3();
            SuaraDua();
        } else if (Z < -50 & Z > -300 & Y > 50 & Y < 350 & X <= 40 & X >= -5){
            Main.marawis3();
            SuaraDua();
        } else{
            Main.basmarawis1();
            Main.marawis2();
        }
    }
}

class Sample {

    public static void Leap(String[] args) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
