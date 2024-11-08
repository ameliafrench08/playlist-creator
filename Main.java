//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int popNumber = 0;
        int rockNumber = 0;
        int classicalNumber = 0;
        int countryNumber = 0;
        int hipHopNumber = 0;
        int jazzNumber = 0;
        int rapNumber = 0;
        int rNBNumber = 0;
        int counter = 1;
        int numSongs = 0;

        String firstChoice = "";
        String secondChoice = "";
        String thirdChoice = "";
        String fourthChoice = "";
        String fifthChoice = "";

        List<String> genres = new ArrayList<>();
        genres.add("Classical");
        genres.add("Country");
        genres.add("HipHop");
        genres.add("Indie");
        genres.add("Jazz");
        genres.add("Pop");
        genres.add("Rap");
        genres.add("RnB");
        genres.add("Rock");

        System.out.println("Your options: ");
        for (int i = 0; i < genres.size(); i++){
            System.out.println(counter +  ") " + genres.get(i));
            counter++;
        }

        System.out.print("Enter your first choice (number): ");
        int firstChoiceNum = s.nextInt();
        firstChoice = genres.get(firstChoiceNum - 1);
        genres.remove(firstChoiceNum - 1);

        for (int i = 0; i < genres.size(); i++){
            System.out.println(counter +  ") " + genres.get(i));
            counter++;
        }

        System.out.print("Enter your second choice (number): ");
        int secondChoiceNum = s.nextInt();
        secondChoice = genres.get(secondChoiceNum - 1);
        genres.remove(secondChoiceNum - 1);

        for (int i = 0; i < genres.size(); i++) {
            System.out.println(counter + ") " + genres.get(i));
            counter++;
        }

        System.out.print("Enter your third choice (number): ");
        int thirdChoiceNum = s.nextInt();
        thirdChoice = genres.get(thirdChoiceNum - 1);
        genres.remove(thirdChoiceNum - 1);

        for (int i = 0; i < genres.size(); i++) {
            System.out.println(counter + ") " + genres.get(i));
            counter++;
        }

        System.out.print("Enter your fourth choice (number): ");
        int fourthChoiceNum = s.nextInt();
        fourthChoice = genres.get(fourthChoiceNum - 1);
        genres.remove(fourthChoiceNum - 1);

        for (int i = 0; i < genres.size(); i++) {
            System.out.println(counter + ") " + genres.get(i));
            counter++;
        }

        System.out.print("Enter your fifth choice (number): ");
        int fifthChoiceNum = s.nextInt();
        fifthChoice = genres.get(fifthChoiceNum - 1);
        genres.remove(fifthChoiceNum - 1);

        System.out.println();

        System.out.print("How many songs would you like in your playlist: ");
        if (s.nextInt() <= 50){
            numSongs = s.nextInt();
        }
        else{
            numSongs = 50;
        }
        

        
        CreatePlaylist playlist = new CreatePlaylist(firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice, numSongs);
    }
}
