import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {

    public static void main(String[] args)throws ParseException {

        Client yo = new Client("2345134T","Andrey","678412659");

        // demostració de construcció d'un vehicle de categoria BASIC
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

        // demostració de construccuó d'un lloguer amb una data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date = dateFormat.parse("2/8/2013");
        Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);

        // demostració de formatat d'una data
        //System.out.println(dateFormat.format(lloguerBasic.getData()));

        yo.afegeix(lloguerBasic);
        infoClient(yo);
    }
    // metodo para imprimir toda la informacion de un cliente
    public static void infoClient(Client client){
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        System.out.println("Client:  " +client.getNom());
        System.out.println("nie/nif: " +client.getNif());
        System.out.println("telefon: " +client.getTelefon());
        System.out.println("Lloguers: "+client.numLloguers());
        for(int i=0;i<client.numLloguers();i++){
            Lloguer lloguer = client.test(i);
            System.out.println((i+1)+". vehicle: "+lloguer.getVehicle().toString());
            System.out.println("data d'inici: "+dateFormat.format(lloguer.getData()));
            System.out.println("dies llogats: "+lloguer.getDias());
        }
    }
}