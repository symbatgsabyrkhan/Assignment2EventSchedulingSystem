import java.util.*;
public class EventManager {
    private ArrayList<Event> events=new ArrayList<>();

    public void addEvent(Event event){
        events.add(event);
    }
    public Event searchByTitle(String title){
        for(Event e:events){
            if (e.getTitle().equals(title)) return e;
        }
        return null;
    }
    public ArrayList<Event> filterByDate(String date){
        ArrayList<Event> result=new ArrayList<>();
        for (Event e:events){
            if(e.getDate().equals(date)) result.add(e);
        }
        return result;
    }
    public void sortByTitle(){
        events.sort(Comparator.comparing(Event::getTitle));
    }
    public void display(){
        for(Event e:events){
            System.out.println(e);
        }
    }
}
