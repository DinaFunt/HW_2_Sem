public class Waggon extends Auto {
    private int max_weight;

    public Waggon(int max_speed, int v_of_fuel_tank, int year_of_issue, String man_country, String model, int max_weight) {
        super(max_speed, v_of_fuel_tank, year_of_issue, man_country, model);
        this.max_weight = max_weight;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " Max weight = " + max_weight + " ton.";
    }
}
