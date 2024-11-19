import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.*;
import java.io.File;  // Import the File class


public class EditPlaylist {
    private List<String> songs;
    String firstChoice;

    public EditPlaylist(List<String> songs, String firstChoice){
        this.songs = songs;
        this.firstChoice = firstChoice;
    }

    public List<String> editOrder(int oldIndex, int newIndex){
        String songToCopy = songs.get(oldIndex);
        songs.remove(oldIndex);
        songs.add(newIndex, songToCopy);
        return songs;
    }

    public List<String> removeSong(int index){
        songs.remove(index);
        return songs;
    }

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

}
