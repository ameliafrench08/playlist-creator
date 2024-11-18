//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
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

        List<Integer> numSongsPerGenre = new ArrayList<>();
        List<String> songs = new ArrayList<>();
        List<String> genres = new ArrayList<>();
        genres.add("Classical");
        genres.add("Country");
        genres.add("HipHop");
        genres.add("Indie");
        genres.add("Jazz");
        genres.add("Pop");
        genres.add("Rap");
        genres.add("Rock");

        System.out.println("Your options: ");
        for (int i = 0; i < genres.size(); i++){
            System.out.println(counter +  ") " + genres.get(i));
            counter++;
        }
        counter = 1;
        System.out.print("Enter your first choice (number): ");
        int firstChoiceNum = s.nextInt();
        firstChoice = genres.get(firstChoiceNum - 1);
        genres.remove(firstChoiceNum - 1);


        for (int i = 0; i < genres.size(); i++){
            System.out.println(counter +  ") " + genres.get(i));
            counter++;
        }
        counter = 1;

        System.out.print("Enter your second choice (number): ");
        int secondChoiceNum = s.nextInt();
        secondChoice = genres.get(secondChoiceNum - 1);
        genres.remove(secondChoiceNum - 1);


        for (int i = 0; i < genres.size(); i++) {
            System.out.println(counter + ") " + genres.get(i));
            counter++;
        }
        counter = 1;

        System.out.print("Enter your third choice (number): ");
        int thirdChoiceNum = s.nextInt();
        thirdChoice = genres.get(thirdChoiceNum - 1);
        genres.remove(thirdChoiceNum - 1);


        for (int i = 0; i < genres.size(); i++) {
            System.out.println(counter + ") " + genres.get(i));
            counter++;
        }
        counter = 1;

        System.out.print("Enter your fourth choice (number): ");
        int fourthChoiceNum = s.nextInt();
        fourthChoice = genres.get(fourthChoiceNum - 1);
        genres.remove(fourthChoiceNum - 1);


        for (int i = 0; i < genres.size(); i++) {
            System.out.println(counter + ") " + genres.get(i));
            counter++;
        }
        counter = 1;

        System.out.print("Enter your fifth choice (number): ");
        int fifthChoiceNum = s.nextInt();
        fifthChoice = genres.get(fifthChoiceNum - 1);
        genres.remove(fifthChoiceNum - 1);


        System.out.println();

        System.out.print("How many songs would you like in your playlist: ");
        numSongs = Math.min(s.nextInt(), 80);



        CreatePlaylist playlist = new CreatePlaylist(firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice, numSongs);
        numSongsPerGenre = playlist.assignNumEachGenre();
        songs = playlist.choosingSongs();
        System.out.println(songs);

        System.out.println("You can: \n   1) Edit songs (Enter 1) \n   2) Remove a song (Enter 2) \n   3) Add a random song (Enter 3) \n   4) Randomize the order of the playlist (Enter 4) \n   5) Quit and print playlist (Enter 5)");
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();

        System.out.println();


        EditPlaylist editedPlaylist = new EditPlaylist(songs);
        while (choice != 5){
            if (choice == 1){
                System.out.print("Enter the number of the song you would like to change (1 - " + songs.size() + "): ");
                int originalIndex = s.nextInt() - 1;

                System.out.println();

                System.out.print("Enter the number of the place to change the song to (1 - " + songs.size() + "): ");
                int newIndex = s.nextInt() - 1;
                songs = editedPlaylist.editOrder(originalIndex, newIndex);

                System.out.println();

                System.out.println();
                System.out.println("New Playlist: " + songs);

                System.out.println();
            }

            else if (choice == 2){
                System.out.print("Enter the number of the song you would like to remove (1 - " + songs.size() + "): ");
                int indexRemove = s.nextInt() - 1;
                songs = editedPlaylist.removeSong(indexRemove);

                System.out.println();
                System.out.println("New Playlist: " + songs);

                System.out.println();
            }

            else if (choice == 3){
                System.out.print("Enter the number of songs you would like to add: ");
                int numTimes = s.nextInt();

                while (numTimes >= 0){
                    songs = editedPlaylist.addSong();
                    numTimes--;
                }

                System.out.println();
                System.out.println("Edited playlist: " + songs);

                System.out.println();
            }

            else if (choice == 4){
                System.out.println();

                System.out.print("How many times would you like to randomize: ");
                int numRandoms = s.nextInt();

                System.out.println();

                int tracker = 1;
                while (numRandoms > 0){
                    songs = editedPlaylist.randomizeOrder();
                    System.out.println(tracker + ") " + songs);
                    tracker++;
                    numRandoms--;
                }

                System.out.println();

                System.out.println("Final Playlist: " + songs);
            }

            System.out.println("You can: \n   1) Edit songs (Enter 1) \n   2) Remove a song (Enter 2) \n   3) Add a random song (Enter 3) \n   4) Randomize the order of the playlist (Enter 4) \n   5) Quit and print playlist (Enter 5)");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();


            System.out.println();
        }

        System.out.println("Final Playlist: " + songs);




    }
}