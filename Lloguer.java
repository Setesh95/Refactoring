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

    public int getDies() {
        return dias;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setDies(int dias) {
        this.dias = dias;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double quantitat(){
        double quantitat=0;

        double multiplicador=30; //multiplicador para el precio en €

        double basic = 1.5; //Oferta basic
        double general = 2.5; //Oferta general
        double luxe = 6;

        switch (getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                quantitat += 3;
                if (getDies() > 3) {
                    quantitat += (getDies() - 3) * basic;
                }
                break;
            case Vehicle.GENERAL:
                quantitat += 4;
                if (getDies() > 2) {
                    quantitat += (getDies() - 2) * general;
                }
                break;
            case Vehicle.LUXE:
                quantitat += getDies() * luxe;
                break;
        }
        quantitat=quantitat*multiplicador;
        return quantitat;
    }
}

