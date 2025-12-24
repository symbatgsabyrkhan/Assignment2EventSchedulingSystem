public class Conference extends Event{
    private String topic;

    public Conference(String title,String date, String topic){
        super(title, date);
        this.topic=topic;
    }
    public String getTopic(){
        return topic;
    }
}
