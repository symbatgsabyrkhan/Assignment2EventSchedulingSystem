public class Concert extends Event{
    private String artist;

    public Concert(String title,String date,String artist ){
        super(title,date);
        this.artist=artist;
    }
    public String getArtist(){
        return artist;
    }
}
