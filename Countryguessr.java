import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Countryguessr {
    private static class Image {
        public Image(String file) {
            JFrame frame = new JFrame(file);
            frame.setDefaultCloseOperation(1);
            try {
                frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(file)))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            frame.pack();
            frame.setVisible(true);

        }

    }

    private static class guez {
        public guez(String image, String country) {
            this.image = image;
            this.country = country;
        }
        
        public void start() {
            new Image(image);

        }

        public String getcountry() {
            return country;
        }

        private String image, country;
    }

    private static ArrayList<guez> citiesToGuess = new ArrayList<>();
    private static boolean doOnce = false;
    private static void doOne() {
        if(!doOnce) {
            doOnce = true;
            citiesToGuess.add(new guez("zone.jpg", "USA"));
        }
    }
    public static void runGame() {
        doOne();
        if(citiesToGuess.size() == 0) {
            return;
        }

        System.out.println(
                "This gamemode is called CountryGuessr. You will receive a collection of a few images from a single country of origin, and you will have to determine where they come from.");

        citiesToGuess.get(0).start();

        Scanner sc = new Scanner(System.in);
        System.out.println("What country is this: ");
        if(sc.nextLine().toLowerCase().indexOf(citiesToGuess.get(0).getcountry().toLowerCase()) >= 0) {
            System.out.println("You are correct, it is indeed " + citiesToGuess.get(0).getcountry());        
        }
        else {
            System.out.println("You are wrong, the city is actually" + citiesToGuess.get(0).getcountry());
        }
        sc.close();
        citiesToGuess.remove(0);
        runGame();
    }

}

