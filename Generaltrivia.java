import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Math;

public class Generaltrivia {
    public Generaltrivia() {
    }

    public void runGame() {
        ArrayList<String> listOfOptions = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(/* Replace with the path */"trivia.txt"));
            while (sc.hasNextLine()) {
                listOfOptions.add(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing list of countries/capitals");
        }
        int count = 0;
        System.out.println("A score counter will be shown below. Type q at any time to quit, or anything other than q to start the game.");
        Scanner s = new Scanner(System.in);
        while (!s.nextLine().equals("q")) {
            int a = (int) (Math.random() *  listOfOptions.size());
            if(a % 2 == 1){
                a--;
            }
            System.out.println(listOfOptions.get(a));
            String b = s.nextLine();
            if(b.equals(listOfOptions.get(a + 1))){
                count++;
                System.out.println("You got it right, nice!");
                System.out.println("-------------------- + \n" + "Score: " + count + "\n --------------------");
                System.out.println("Type q to end the game or anything else to continue.");
            }
            else if(b.equals("q")){
                if(count == 0){
                    System.out.println("Oh well. You ended with 0 points.");
                }
                else if(count > 0 && count < 2){
                    System.out.println("You ended the game with " + count + " points. At least it's better than 0.");
                }
                else {
                    System.out.println("Nice! You ended with " + count + " points!");
                }
            }
            else{
                System.out.println("You got it wrong unfortunately. :(");
                System.out.println("The correct answer was " + listOfOptions.get(a + 1));
                count = 0;
                System.out.println("-------------------- + \n" + "Score: " + count + "\n --------------------");
            }
        }
        if(count == 0){
            System.out.println("Oh well. You ended with 0 points.");
        }
        else if(count > 0 && count < 2){
            System.out.println("You ended the game with " + count + " points. At least it's better than 0.");
        }
        else {
            System.out.println("Nice! You ended with " + count + " points!");
        }
        s.close();
    }
}
