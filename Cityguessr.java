import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Cityguessr extends Generaltrivia {
    
    public Cityguessr () {

    }
    public void runGame(){
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(/* Replace with the path */"poop.txt"));
            while (sc.hasNextLine()) {
                list.add(sc.nextLine()); //compiles all the text from trivia.txt to an arraylist
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing list of countries/capitals");
        }
        int count = 0;
        System.out.println("A score counter will be shown below. Type q at any time to quit, or anything other than q to start the game.");
        Scanner s = new Scanner(System.in);
        while (!s.nextLine().equals("q")) { //checks to make sure the input isn't ever q
            int a = (int) (Math.random() *  list.size());
            if(a % 3 == 1 || a % 3 == 2){ // makes sure to output the country and population by making a the country name, as in the text file they are listed in order of country, city, population 
                int b = a % 3;
                a -= b;
            }
            System.out.println("The country that the city originates in is " + list.get(a) + ". The estimated population of the metro area of the city is " + list.get(a + 2) + "."); //output country and population
            String b = s.nextLine();
            if(b.equals(list.get(a + 1))){ //checks to confirm accuracy
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
                    System.out.println("You ended the game with " + count + " point. At least it's better than 0.");
                }
                else {
                    System.out.println("Nice! You ended with " + count + " points!");
                }
            }
            else{
                System.out.println("You got it wrong unfortunately. :(");
                System.out.println("The correct answer was " + list.get(a + 1));
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