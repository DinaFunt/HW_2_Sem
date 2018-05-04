public class Main {
    public static void main(String[] args) {
        Car BMW = new Car(250,42, 2014, "Germany", "BMW i8", 10040000);
        Minibus Volkswagen = new Minibus(170, 75, 2006, "Germany","Volkswagen Crafter",40);
        Waggon Man = new Waggon(100, 100, 2005, "Germany", "Man", 38);

        System.out.println(BMW.getInfo());
        System.out.println(Volkswagen.getInfo());
        System.out.println(Man.getInfo());
    }
}
