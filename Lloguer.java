import java.util.Date;

public class Lloguer{

    private Date data;
    private int dias;
    private Vehicle vehicle;

    public Lloguer(Date data, int dias, Vehicle vehicle){
        this.data = data;
        this.dias = dias;
        this.vehicle = vehicle;
    }

    public Date getData() {
        return data;
    }

    public int getDias() {
        return dias;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

