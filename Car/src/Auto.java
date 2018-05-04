public class Auto {
    protected int max_speed;
    protected int v_of_fuel_tank;
    protected int year_of_issue;
    protected String man_country;
    protected String model;

    public Auto(int max_speed, int v_of_fuel_tank, int year_of_issue, String man_country, String model) {
        this.max_speed = max_speed;
        this.v_of_fuel_tank = v_of_fuel_tank;
        this.year_of_issue = year_of_issue;
        this.man_country = man_country;
        this.model = model;
    }

    public String getInfo() {
        return "The model of this car is " + model + ". It was produced in " + man_country + " in " + year_of_issue +
                ". Max speed of the car = " + max_speed + "km/h. Volue of fuel tank = " + v_of_fuel_tank + ". ";
    }
}
