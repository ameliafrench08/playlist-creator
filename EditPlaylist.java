import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.*;
import java.io.File;  // Import the File class

/** The class EditPlaylist represents a playlist that needs to be edited. It has a list of songs and a first choice for a genre.**/
public class EditPlaylist {
    private List<String> songs;
    String firstChoice;

    /** EditPlaylist creates an instance of the EditPlaylist class with the following parameters:
     * @param songs is a list of the randomly chosen songs from CreatePlaylist.
     * @param firstChoice is the genre that was the first choice chosen by the user
     **/
    public EditPlaylist(List<String> songs, String firstChoice){
        this.songs = songs;
        this.firstChoice = firstChoice;
    }

    /** editOrder allows the user to pick a song and move it to a different index. It takes in these parameters:
     * @param oldIndex - the index of the song they want to move
     * @param newIndex - the index they want the song to move to
     * @return songs - returns songs but edited
     **/
    public List<String> editOrder(int oldIndex, int newIndex){
        String songToCopy = songs.get(oldIndex);
        songs.remove(oldIndex);
        songs.add(newIndex, songToCopy);
        return songs;
    }

    /** removeSong allows the user to remove a song that they don't want. It takes a singular parameter:
     * @param index - the index of the song they don't want in the playlist
     * @return songs - returns the songs list
     **/
    public List<String> removeSong(int index){
        songs.remove(index);
        return songs;
    }

    /** addSong adds a random song from their first choice genre
     * @return songs - returns songs list
     **/
    public List<String> addSong() throws FileNotFoundException {
        Random rand = new Random();

        File firstChoiceFile = new File(
                "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\" + firstChoice);
        Scanner myReader = new Scanner(firstChoiceFile);


        int randomSong = rand.nextInt(103) + 1;

        int k = 1;
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\" + firstChoice));
        lineNumberReader.setLineNumber(1);
        while (myReader.hasNext()) {
            String data = myReader.nextLine();
            if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                songs.add(data);
            }
            k++;
            lineNumberReader.setLineNumber(k);
//              k++;
        }
        myReader.close();
        return songs;
    }

    /** randomizeOrder randomizes the order of the playlist.
     * @return songs - returns the songs list
     **/
    public List<String> randomizeOrder(){
        Random rand = new Random();
        for (int v = 0; v < songs.size(); v++){
            String copyData = songs.get(v);
            songs.remove(v);
            int randomPlacement = rand.nextInt(songs.size());
            songs.add(randomPlacement, copyData);
        }
        return songs;
    }

    /** addForFirst adds songs of the first choice genre until the number of songs needed is fulfilled, given that there has always been 1-5 first choice songs missing
     * @return songs - returns the songs list
     **/
    public List<String> addForFirst() throws FileNotFoundException {
        Random rand = new Random();


        File firstChoiceFile = new File(
                "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\" + firstChoice);
        Scanner myReader = new Scanner(firstChoiceFile);


        int randomSong = rand.nextInt(103) + 1;

        int k = 1;
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\" + firstChoice));
        lineNumberReader.setLineNumber(1);
        while (myReader.hasNext()) {
            String data = myReader.nextLine();
            if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                songs.add(data);
            }
            k++;
            lineNumberReader.setLineNumber(k);
//              k++;
        }
        myReader.close();

        return songs;
    }

}
