import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.*;
import java.io.File;  // Import the File class


/** CreatePlaylist class represents a Playlist. This has genres that are the 1st, second, 3rd, 4th, and 5th choices, and have numSongs songs.**/
public class CreatePlaylist {
    private String firstChoice;
    private String secondChoice;
    private String thirdChoice;
    private String fourthChoice;
    private String fifthChoice;
    private int numSongs;

    /** Constructor for the CreatePlaylist class. Parameters:
     * @param firstChoice represents the user's first choice for genre
     * @param secondChoice represents the user's second genre choice
     * @param thirdChoice represents the user's third genre choice
     * @param fourthChoice represents the user's fourth genre choice
     * @param fifthChoice represents the user's fifth genre choice
     * @param numSongs represents number of songs the user wants, from 1-160
     **/

    public CreatePlaylist(String firstChoice, String secondChoice, String thirdChoice, String fourthChoice, String fifthChoice, int numSongs){
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        this.thirdChoice = thirdChoice;
        this.fourthChoice = fourthChoice;
        this.fifthChoice = fifthChoice;
        this.numSongs = numSongs;
    }

    /** assignNumEachGenre assigns a certain number of songs to each genre based on the ranking of the songs and the # of songs
     * 1st choice gets 1/2
     * 2nd choice gets 1/4
     * 3rd gets 0.12
     * 4th get 0.06
     * 5th gets 0.04
     * All the rest get 0.03 each
     * @return returns a list of the number of songs for each genre
     **/
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
        genres.add("Rock");

        genresLeft.add("Classical");
        genresLeft.add("Country");
        genresLeft.add("HipHop");
        genresLeft.add("Indie");
        genresLeft.add("Jazz");
        genresLeft.add("Pop");
        genresLeft.add("Rap");
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



    /** choosingSongs randomly selects songs for each genre based on assignNumEachGenre and adds them to a list of strings
     * @return a list of the songs being added to that can be edited later.**/
    public List<String> choosingSongs() throws FileNotFoundException {

        List<String> songs = new ArrayList<>(160);
        List<Integer> numbersChosen = new ArrayList<>();
        Random rand = new Random();

        List<Integer> numSongsGenre = new ArrayList<>(assignNumEachGenre());
        int originalAddition = numSongsGenre.get(0) + numSongsGenre.get(1) + numSongsGenre.get(2) + numSongsGenre.get(3) + numSongsGenre.get(4) + numSongsGenre.get(5) + numSongsGenre.get(6) + numSongsGenre.get(7);
        //CLASSICAL
        boolean doneBefore = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File classicalFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Classical");
            Scanner myReader = new Scanner(classicalFile);


            int randomSong = rand.nextInt(103) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Classical"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
//              k++;
            if ("Classical".equals(firstChoice) && !doneBefore){
//                while ()
                lineNumberReader.setLineNumber(1);
                randomSong = rand.nextInt(103) + 1;
                k = 1;
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
                    doneBefore = true;
                }
            }
            myReader.close();
        }

        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //COUNTRY
        boolean doneBeforeCountry = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File countryFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Country");
            Scanner myReader = new Scanner(countryFile);
            int randomSong = rand.nextInt(83) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Country"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("Country".equals(firstChoice) && !doneBeforeCountry){
                randomSong = rand.nextInt(83) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforeCountry = true;
            }
            myReader.close();
        }
        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //HIPHOP
        boolean doneBeforeHipHop = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File hipHopFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\HipHop");
            Scanner myReader = new Scanner(hipHopFile);
            int randomSong = rand.nextInt(98) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\HipHop"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("HipHop".equals(firstChoice) && !doneBeforeHipHop){
                randomSong = rand.nextInt(98) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforeHipHop = true;
            }
            myReader.close();
        }
        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //Indie
        boolean doneBeforeIndie = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File indieFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Indie");
            Scanner myReader = new Scanner(indieFile);
            int randomSong = rand.nextInt(87) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Indie"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("Indie".equals(firstChoice) && !doneBeforeIndie){
                randomSong = rand.nextInt(87) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforeIndie = true;
            }
            myReader.close();
        }
        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //Jazz
        boolean doneBeforeJazz = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File jazzFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Jazz");
            Scanner myReader = new Scanner(jazzFile);
            int randomSong = rand.nextInt(81) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Jazz"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("Jazz".equals(firstChoice) && !doneBeforeJazz){
                randomSong = rand.nextInt(81) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforeJazz = true;
            }
            myReader.close();
        }
        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //Pop
        boolean doneBeforePop = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File jazzFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Pop");
            Scanner myReader = new Scanner(jazzFile);
            int randomSong = rand.nextInt(80) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Pop"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("Pop".equals(firstChoice) && !doneBeforePop){
                randomSong = rand.nextInt(97) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforePop = true;
            }
            myReader.close();
        }
        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //Rap
        boolean doneBeforeRap = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
            File rapFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rap");
            Scanner myReader = new Scanner(rapFile);
            int randomSong = rand.nextInt(122) + 1;
            numbersChosen.add(randomSong);

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rap"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("Rap".equals(firstChoice) && !doneBeforeRap){
                randomSong = rand.nextInt(122) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforeRap = true;
            }
            myReader.close();
        }

        numSongsGenre.removeFirst();
        numbersChosen.clear();

        //Rock
        boolean doneBeforeRock = false;
        for (int j = 0; j < numSongsGenre.getFirst(); j++){
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
                if (numbersChosen.contains(lineNumberReader.getLineNumber()) && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
//              k++;
            }
            if ("Rock".equals(firstChoice) && !doneBeforeRock){
                randomSong = rand.nextInt(106) + 1;
                k = 1;
                lineNumberReader.setLineNumber(1);
                while (myReader.hasNext()){
                    String data = myReader.nextLine();
                    if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                        songs.add(data);
                    }
                    k++;
                    lineNumberReader.setLineNumber(k);
//              k++;
                }
                doneBeforeRock = true;
            }
            myReader.close();
        }

        List<String> songsTester = new ArrayList<>(songs);
        for (int f = 0; f < songs.size(); f++){
            songsTester.remove(f);
            if (songsTester.contains(songs.get(f))){
                songs.remove(f);
            }
            else{
                songsTester.add(f, songs.get(f));
            }
        }

        return songs;
    }




}
