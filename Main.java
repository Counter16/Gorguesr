import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Would you like to play Cityguessr(1), Countryguessr(2), or general trivia(3)?");
        Scanner sc = new Scanner(System.in);
        String sussy = sc.nextLine();
        if(sussy.equals("1")){
            Cityguessr b = new Cityguessr();
            b.runGame();
        }
        else if(sussy.equals("2")){
            Countryguessr.runGame();
        }
        else{
            System.out.println("Hello, you picked general trivia. Let's see how well you fare...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print("\033[H\033[2J");
            Generaltrivia a = new Generaltrivia();
            a.runGame();
        }
        sc.close();
    }
}

