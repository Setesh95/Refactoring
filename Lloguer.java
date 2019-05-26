import java.util.Date;

public class Lloguer{
    private static final double EUROS_PER_UNITAT_COST = 30;
    private static final double basic = 1.5;
    private static final double general = 2.5;
    private static final int luxe = 6;
    private static final int promoBasic = 3;
    private static final int promoGeneral = 2;

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

    public double PreuDelAlquiler(){
        double PreuDelAlquiler = 0;

        switch (getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                PreuDelAlquiler += promoBasic;
                if (getDies() > promoBasic) {
                    PreuDelAlquiler += (getDies() - promoBasic) * basic;
                }
                break;
            case Vehicle.GENERAL:
                PreuDelAlquiler += 4;
                if (getDies() > promoGeneral) {
                    PreuDelAlquiler += (getDies() - promoGeneral) * general;
                }
                break;
            case Vehicle.LUXE:
                PreuDelAlquiler += getDies() * luxe;
                break;
        }
        PreuDelAlquiler = PreuDelAlquiler * EUROS_PER_UNITAT_COST;
        return PreuDelAlquiler;
    }

    public int bonificacions(){

        // afegeix bonificació per dos dies de lloguer de Luxe
        if (getVehicle().getCategoria() == Vehicle.LUXE &&
                getDies() > 1 ) {
            return 2;
        }
        return 1;
    }
}

