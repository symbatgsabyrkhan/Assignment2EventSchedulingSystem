import java.util.Objects;
public abstract class Event {
    private String title;
    private String date;

    public Event(String title, String date){
        this.title=title;
        this.date=date;
    }
    public String getTitle(){
        return title;
    }
    public String getDate(){
        return date;
    }
    @Override
    public String toString(){
        return title+" ("+date+")";
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if (o==null||getClass()!=o.getClass())return false;
        Event event =(Event) o;
        return title.equals(event.title)&&date.equals(event.date);
    }
    @Override
    public int hashCode(){
        return Objects.hash(title,date);
    }
}

