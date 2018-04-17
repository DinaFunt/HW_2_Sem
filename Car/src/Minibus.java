public class Minibus extends Auto {
    private int max_num_of_pass;

    public Minibus(int max_speed, int v_of_fuel_tank, int year_of_issue, String man_country, String model, int max_num_of_pass) {
        super(max_speed, v_of_fuel_tank, year_of_issue, man_country, model);
        this.max_num_of_pass = max_num_of_pass;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "Max number of passengers = " + max_num_of_pass + ".";
    }
}
