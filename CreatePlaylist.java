import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.*;
import java.io.File;  // Import the File class


public class CreatePlaylist {
    private String firstChoice;
    private String secondChoice;
    private String thirdChoice;
    private String fourthChoice;
    private String fifthChoice;
    private int numSongs;

    public CreatePlaylist(String firstChoice, String secondChoice, String thirdChoice, String fourthChoice, String fifthChoice, int numSongs){
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        this.thirdChoice = thirdChoice;
        this.fourthChoice = fourthChoice;
        this.fifthChoice = fifthChoice;
        this.numSongs = numSongs;
    }

    public List<Integer> assignNumEachGenre(){
        List<Integer> numOfSongsPerGenre = new ArrayList<>();
        int numSongsLeft = numSongs;
        List<String> genres = new ArrayList<>();
        List<String> genresLeft = new ArrayList<>();
        genres.add("Classical");
        genres.add("Country");
        genres.add("HipHop");
        genres.add("Indie");
        genres.add("Jazz");
        genres.add("Pop");
        genres.add("Rap");
        genres.add("RnB");
        genres.add("Rock");

        genresLeft.add("Classical");
        genresLeft.add("Country");
        genresLeft.add("HipHop");
        genresLeft.add("Indie");
        genresLeft.add("Jazz");
        genresLeft.add("Pop");
        genresLeft.add("Rap");
        genresLeft.add("RnB");
        genresLeft.add("Rock");

        for (String genre : genres) {
            if (Objects.equals(genre, firstChoice)) {
                numOfSongsPerGenre.add((int) (numSongs * 0.5));
            } else if (Objects.equals(genre, secondChoice)) {
                numOfSongsPerGenre.add((int) (numSongs * 0.25));
            } else if (Objects.equals(genre, thirdChoice)) {
                numOfSongsPerGenre.add((int) (numSongs * 0.12));
            } else if (Objects.equals(genre, fourthChoice)) {
                numOfSongsPerGenre.add((int) (numSongs * 0.06));
            } else if (Objects.equals(genre, fifthChoice)) {
                numOfSongsPerGenre.add((int) (numSongs * 0.04));
            } else {
                numOfSongsPerGenre.add((int) (numSongs * 0.03));
            }
        }
        return numOfSongsPerGenre;
    }



    public List<String> choosingSongs() throws FileNotFoundException {


        //CODE TTHAT I SHOULD IMPLEMENT:

        //INSTEAD OF THE FILE READING CODE RN BC IT DOESNT WORK

//        InputStream is = new FileInputStream(path);
//
//        // Try block to check for exceptions
//        try (Scanner sc = new Scanner(
//                is, StandardCharsets.UTF_8.name())) {
//
//
//            while (sc.hasNextLine()) {
//
//                // Printing the content of file
//                System.out.println(sc.nextLine());
        // Just in Case
//                for (int k = 1; k <= numbersChosen.getFirst(); k++) {
//                    String data = myReader.nextLine();
//                    if (k == numbersChosen.getFirst()) {
//                        songs.add(data);
//                    }
//                }

        List<String> songs = new ArrayList<>(50);
        List<Integer> numbersChosen = new ArrayList<>();
        Random rand = new Random();


        //CLASSICAL
        for (int j = 0; j < assignNumEachGenre().getFirst(); j++){
            File classicalFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Classical");
            Scanner myReader = new Scanner(classicalFile);

            int randomSong = rand.nextInt(103) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Classical"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //COUNTRY
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File countryFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Country");
            Scanner myReader = new Scanner(countryFile);
            int randomSong = rand.nextInt(83) + 1;
            numbersChosen.add(randomSong);

//            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Country"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //HIPHOP
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File hipHopFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\HipHop");
            Scanner myReader = new Scanner(hipHopFile);
            int randomSong = rand.nextInt(98) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\HipHop"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //Indie
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File indieFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Indie");
            Scanner myReader = new Scanner(indieFile);
            int randomSong = rand.nextInt(87) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Indie"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //Jazz
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File jazzFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Jazz");
            Scanner myReader = new Scanner(jazzFile);
            int randomSong = rand.nextInt(81) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Jazz"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //Pop
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File jazzFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Pop");
            Scanner myReader = new Scanner(jazzFile);
            int randomSong = rand.nextInt(77) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Pop"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();
        //Rap
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File rapFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rap");
            Scanner myReader = new Scanner(rapFile);
            int randomSong = rand.nextInt(122) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rap"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //RnB
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File RnBFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\RnB");
            Scanner myReader = new Scanner(RnBFile);
            int randomSong = rand.nextInt(114) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\RnB"));
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        numbersChosen.clear();

        //Rock
        for (int j = 0; j <= assignNumEachGenre().getFirst(); j++){
            File rockFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rock");
            Scanner myReader = new Scanner(rockFile);
            int randomSong = rand.nextInt(106) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rock"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber())) {
                    songs.add(data);
                }
//                k++;
            }

            myReader.close();
        }

        System.out.println(assignNumEachGenre());
        return songs;
    }


}
