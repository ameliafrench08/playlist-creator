import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CreatePlaylist {
    private int popPercentage;
    private int classicalPercentage;
    private int countryPercentage;
    private int hipHopPercentage;
    private int indiePercentage;
    private int jazzPercentage;
    private int rapPercentage;
    private int rNBPercentage;
    private int rockPercentage;

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

        for (int i = 0; i <= genres.size(); i++){
            if (Objects.equals(genres.get(i), firstChoice)){
                numOfSongsPerGenre.add((int) (numSongs * 0.5));
            }
            else if (Objects.equals(genres.get(i), secondChoice)){
                numOfSongsPerGenre.add((int) (numSongs * 0.25));
            }
            else if (Objects.equals(genres.get(i), thirdChoice)){
                numOfSongsPerGenre.add((int)(numSongs * 0.12));
            }
            else if (Objects.equals(genres.get(i), fourthChoice)){
                numOfSongsPerGenre.add((int)(numSongs * 0.06));
            }
            else if (Objects.equals(genres.get(i), fifthChoice)){
                numOfSongsPerGenre.add((int)(numSongs * 0.03));
            }
            else{
                numOfSongsPerGenre.add((int)(numSongs * 0.01));
            }
        }
        return numOfSongsPerGenre;
    }
}
