//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
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


        System.out.println("Welcome to Playlist Creator! \nTo use, you will enter your 1st-5th picks of genres and we will create a playlist for you according to those choices. \nYou will also enter the number of songs you want, 1-160. \nBe careful with the numbers you enter, because if you enter a number not from 1-however many genres left, classical will be your automatic choice.");
        System.out.println();

        System.out.println();

        System.out.println("Your options: ");
        for (String item : genres) {
            System.out.println(counter + ") " + item);
            counter++;
        }
        counter = 1;
        System.out.print("Enter your first choice (number): ");
        int firstChoiceNum = s.nextInt();
        if (!(1 <= firstChoiceNum) || !(8 >= firstChoiceNum)){
            firstChoiceNum = 1;
        }
        firstChoice = genres.get(firstChoiceNum - 1);
        genres.remove(firstChoiceNum - 1);

        System.out.println();

        for (String value : genres) {
            System.out.println(counter + ") " + value);
            counter++;
        }
        counter = 1;

        System.out.print("Enter your second choice (number): ");
        int secondChoiceNum = s.nextInt();
        if (!(1 <= secondChoiceNum) || !(7 >= secondChoiceNum)){
            secondChoiceNum = 1;
        }
        secondChoice = genres.get(secondChoiceNum - 1);
        genres.remove(secondChoiceNum - 1);

        System.out.println();

        for (String string : genres) {
            System.out.println(counter + ") " + string);
            counter++;
        }
        counter = 1;

        System.out.print("Enter your third choice (number): ");
        int thirdChoiceNum = s.nextInt();
        if (!(1 <= thirdChoiceNum) || !(6 >= thirdChoiceNum)){
            thirdChoiceNum = 1;
        }
        thirdChoice = genres.get(thirdChoiceNum - 1);
        genres.remove(thirdChoiceNum - 1);

        System.out.println();


        for (String genre : genres) {
            System.out.println(counter + ") " + genre);
            counter++;
        }
        counter = 1;

        System.out.print("Enter your fourth choice (number): ");
        int fourthChoiceNum = s.nextInt();
        if (!(1 <= fourthChoiceNum) || !(5 >= fourthChoiceNum)) {
            fourthChoiceNum = 1;
        }
        fourthChoice = genres.get(fourthChoiceNum - 1);
        genres.remove(fourthChoiceNum - 1);

        System.out.println();

        for (String genre : genres) {
            System.out.println(counter + ") " + genre);
            counter++;
        }
        counter = 1;

        System.out.print("Enter your fifth choice (number): ");
        int fifthChoiceNum = s.nextInt();
        if (!(1 <= fifthChoiceNum) || !(4 >= fifthChoiceNum)){
            fifthChoiceNum = 1;
        }
        fifthChoice = genres.get(fifthChoiceNum - 1);
        genres.remove(fifthChoiceNum - 1);

        System.out.println();

        System.out.println();

        System.out.print("How many songs would you like in your playlist: ");
        numSongs = Math.min(s.nextInt(), 160);



        CreatePlaylist playlist = new CreatePlaylist(firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice, numSongs);


        numSongsPerGenre = playlist.assignNumEachGenre();
        songs = playlist.choosingSongs();



        EditPlaylist editedPlaylist = new EditPlaylist(songs, firstChoice);
        while (songs.size() < numSongs) {
            songs = editedPlaylist.addForFirst();
        }

        System.out.println();

        System.out.println("Rough Playlist: ");
        for (int v = 0; v < songs.size(); v++){
            System.out.println((v +1) + ") " + songs.get(v));
        }


        System.out.println();

        System.out.println("You can: \n   1) Edit placement of songs (Enter 1) \n   2) Remove a song (Enter 2) \n   3) Add a random song (Enter 3) \n   4) Randomize the order of the playlist (Enter 4) \n   5) Quit and print playlist (Enter 5)");
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();

        System.out.println();



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
                System.out.println("New Playlist: ");
                for (int e = 0; e < songs.size(); e++){
                    System.out.println((e +1) + ") " + songs.get(e));
                }

                System.out.println();
            }

            else if (choice == 2){
                System.out.print("Enter the number of the song you would like to remove (1 - " + songs.size() + "): ");
                int indexRemove = s.nextInt() - 1;
                songs = editedPlaylist.removeSong(indexRemove);

                System.out.println();
                System.out.println("New Playlist: ");
                for (int r = 0; r < songs.size(); r++){
                    System.out.println((r +1) + ") " + songs.get(r));
                }

                System.out.println();
            }

            else if (choice == 3){
                System.out.print("Enter the number of songs you would like to add: ");
                int numTimes = s.nextInt();

                int origSongsSize = songs.size();
                while (songs.size() < (origSongsSize + numTimes)){
                    songs = editedPlaylist.addSong();

                }

                System.out.println();
                System.out.println("Edited playlist: ");
                for (int m = 0; m < songs.size(); m++){
                    System.out.println((m +1) + ") " + songs.get(m));
                }

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

                System.out.println("Final Playlist: ");
                for (int l = 0; l < songs.size(); l++){
                    System.out.println((l+1) + ") " + songs.get(l));
                }
            }

            System.out.println("You can: \n   1) Edit songs (Enter 1) \n   2) Remove a song (Enter 2) \n   3) Add a random song (Enter 3) \n   4) Randomize the order of the playlist (Enter 4) \n   5) Quit and print playlist (Enter 5)");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();


            System.out.println();
        }

        System.out.println();

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Final Playlist: ");
        for (int t = 0; t < songs.size(); t++){
            System.out.println((t+1) + ") " + songs.get(t));
        }


        System.out.println("------------------------------------------------------------------------------");

        System.out.println();

        System.out.print("Would you like to create your own playlist? (1 for yes, anything other number for no): ");
        int createOwnPlaylist = s.nextInt();

        if (createOwnPlaylist == 1){
            int numberOfSong = 0;
            List<String> userPlaylist = new ArrayList<>();
            System.out.println();

            System.out.println("Perfect! Unlike our randomly generated playlist, your playlist can go on forever! \nTo get started, just enter the number of the song. Don't worry, we'll save them! \nTo quit, enter -1");
            String userSong = "";

            System.out.println();

            while (!userSong.equals("-1")){
                numberOfSong++;
                System.out.print(numberOfSong + ") ");
                userSong = s.nextLine();
                userPlaylist.add(userSong);

            }

            userPlaylist.removeLast();

            System.out.println(userPlaylist);
            System.out.println();

            System.out.println("Wow, that looks like a great playlist! Would you like to edit it? (1 for yes, anything else for no): ");
            int editPlaylist = s.nextInt();
            if (editPlaylist == 1){
                EditPlaylist userEditPlaylist = new EditPlaylist(userPlaylist, "Classical");

                System.out.println();

                System.out.println("You can: \n   1) Edit placement of songs (Enter 1) \n   2) Remove a song (Enter 2) \n   3) Add a random song (Enter 3) \n   4) Randomize the order of the playlist (Enter 4) \n   5) Quit and print playlist (Enter 5)");
                System.out.print("Enter your choice: ");
                int choiceUserPlaylist = s.nextInt();

                System.out.println();


                while (choiceUserPlaylist != 5){
                    if (choiceUserPlaylist == 1){
                        System.out.print("Enter the number of the song you would like to change (1 - " + userPlaylist.size() + "): ");
                        int originalIndex = s.nextInt() - 1;

                        System.out.println();

                        System.out.print("Enter the number of the place to change the song to (1 - " + userPlaylist.size() + "): ");
                        int newIndex = s.nextInt() - 1;
                        userPlaylist = userEditPlaylist.editOrder(originalIndex, newIndex);

                        System.out.println();

                        System.out.println();
                        System.out.println("New Playlist: ");
                        for (int i = 0; i < userPlaylist.size(); i++){
                            System.out.println((i +1) + ") " + userPlaylist.get(i));
                        }

                        System.out.println();
                    }

                    else if (choiceUserPlaylist == 2){
                        System.out.print("Enter the number of the song you would like to remove (1 - " + userPlaylist.size() + "): ");
                        int indexRemoveUser = s.nextInt() - 1;
                        userPlaylist = userEditPlaylist.removeSong(indexRemoveUser);

                        System.out.println();
                        System.out.println("New Playlist: ");
                        for (int a = 0; a < userPlaylist.size(); a++){
                            System.out.println((a +1) + ") " + userPlaylist.get(a));
                        }

                        System.out.println();
                    }

                    else if (choiceUserPlaylist == 3){
                        System.out.print("Enter the number of songs you would like to add: ");
                        int numTimesUser = s.nextInt();

                        int origSongsSizeUser = userPlaylist.size();
                        while (userPlaylist.size() < (origSongsSizeUser + numTimesUser)){
                            userPlaylist = userEditPlaylist.addSong();

                        }

                        System.out.println();
                        System.out.println("Edited playlist: ");
                        for (int m = 0; m < userPlaylist.size(); m++){
                            System.out.println((m +1) + ") " + userPlaylist.get(m));
                        }

                        System.out.println();
                    }

                    else if (choiceUserPlaylist == 4){
                        System.out.println();

                        System.out.print("How many times would you like to randomize: ");
                        int numRandomsUser = s.nextInt();

                        System.out.println();

                        int trackerUser = 1;
                        while (numRandomsUser > 0){
                            userPlaylist = userEditPlaylist.randomizeOrder();
                            System.out.println(trackerUser + ") " + userPlaylist);
                            trackerUser++;
                            numRandomsUser--;
                        }

                        System.out.println();

                        System.out.println("Final Playlist: ");
                        for (int l = 0; l < userPlaylist.size(); l++){
                            System.out.println((l+1) + ") " + userPlaylist.get(l));
                        }
                    }

                    System.out.println();
                    System.out.println("You can: \n   1) Edit songs (Enter 1) \n   2) Remove a song (Enter 2) \n   3) Add a random song (Enter 3) \n   4) Randomize the order of the playlist (Enter 4) \n   5) Quit and print playlist (Enter 5)");
                    System.out.print("Enter your choice: ");
                    choiceUserPlaylist = s.nextInt();


                    System.out.println();
                }
            }


        }

        else {
            System.out.println("GOODBYE!");
        }




    }
}