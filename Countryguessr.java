import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Countryguessr { 
    private static class Image { //sam and rohan helped me implement this class so that the images would show up
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
        public guez(String image, String country) { //constructors, getters, some methods
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
            citiesToGuess.add(new guez("zone.jpg", "USA")); //just proof of concept, ultimately i could add an unlimited number of pictures to the game
            citiesToGuess.add(new guez("zfunnymountain.jpg", "China"));

        }
    }
    public static void runGame() {
        doOne();
        if(citiesToGuess.size() == 0) { //stop if no more pictures
            return;
        }

        System.out.println(
                "This gamemode is called CountryGuessr. You will receive an image from a country, and you will have to determine where it comes from.");

        citiesToGuess.get(0).start();

        Scanner sc = new Scanner(System.in);
        System.out.println("What country is this: ");
        if(sc.nextLine().toLowerCase().indexOf(citiesToGuess.get(0).getcountry().toLowerCase()) >= 0) { //checks if user input is same as the country in which the image is stored with
            System.out.println("You are correct, it is indeed " + citiesToGuess.get(0).getcountry());        
        }
        else {
            System.out.println("You are wrong, the city is actually" + citiesToGuess.get(0).getcountry());
        }
        sc.close();
        citiesToGuess.remove(0); // remove the image/country just guessed
        runGame();
    }

}

