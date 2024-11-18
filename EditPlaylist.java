import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.*;
import java.io.File;  // Import the File class


public class EditPlaylist {
    private List<String> songs;

    public EditPlaylist(List<String> songs){
        this.songs = songs;
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
        int randomGenre = rand.nextInt(8) + 1;
        if (randomGenre == 1){ // If Classical
            File classicalFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Classical");
            Scanner myReader = new Scanner(classicalFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Classical"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else if (randomGenre == 2){ // Country
            File countryFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Country");
            Scanner myReader = new Scanner(countryFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Country"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else if (randomGenre == 3){ // Hip Hop
            File hipHopFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\HipHop");
            Scanner myReader = new Scanner(hipHopFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\HipHop"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else if (randomGenre == 4){
            File indieFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Indie");
            Scanner myReader = new Scanner(indieFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Indie"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else if (randomGenre == 5){
            File jazzFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Jazz");
            Scanner myReader = new Scanner(jazzFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Jazz"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else if (randomGenre == 6){
            File popFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Pop");
            Scanner myReader = new Scanner(popFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Pop"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else if (randomGenre == 7){
            File rapFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rap");
            Scanner myReader = new Scanner(rapFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rap"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }

        else{
            File rockFile = new File(
                    "C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rock");
            Scanner myReader = new Scanner(rockFile);

            int randomSong = rand.nextInt(103) + 1;

            int k = 1;
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("C:\\Users\\BT_2S14_05\\IdeaProjects\\Playlist Creator\\src\\Rock"));
            lineNumberReader.setLineNumber(1);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                if (randomSong == lineNumberReader.getLineNumber() && !songs.contains(data)) {
                    songs.add(data);
                }
                k++;
                lineNumberReader.setLineNumber(k);
            }
            myReader.close();
        }
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
