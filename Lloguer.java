public class Lloguer{

    private String data;
    private int dias;
    private Vehicle vehicle;

    public Lloguer(int dias,String data){
        this.data = data;
        this.dias = dias;
    }

    public String getData() {
        return data;
    }

    public int getDias() {
        return dias;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

