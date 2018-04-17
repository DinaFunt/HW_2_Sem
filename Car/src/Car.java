public class Car extends Auto {
    private int price;

    public Car(int max_speed, int v_of_fuel_tank, int year_of_issue, String man_country, String model, int price) {
        super(max_speed, v_of_fuel_tank, year_of_issue, man_country, model);
        this.price = price;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Car price = " + price + " RUB.";
    }
}
