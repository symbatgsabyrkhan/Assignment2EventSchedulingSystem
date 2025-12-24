public class Main{
    public static void main(String[] args){
        EventManager manager=new EventManager();

        manager.addEvent(new Concert("Kairat Nurtas concert", "30-12-2025","Kairat Nurtas"));
        manager.addEvent(new Conference("IT", "28-12-2025","Software Engineering"));
        manager.addEvent(new Concert("Opera","27-12-2025","Tynda"));

        System.out.println("All events:");
        manager.display();

        System.out.println("\nSearch 'Kairat Nurtas concert':");
        System.out.println(manager.searchByTitle("Kairat Nurtas concert"));

        System.out.println("\nFilter by date '28-12-2025' :");
        manager.filterByDate("28-12-2025").forEach(System.out::println);

        System.out.println("\nSorted by title:");
        manager.sortByTitle();
        manager.display();
    }
}