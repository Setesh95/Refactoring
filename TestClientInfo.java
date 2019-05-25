import org.junit.*;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClientInfo {
    @Test
    public void TestClientInfo() throws ParseException {
        Client yo = new Client("2345134T","Andrey","678412659");

        // demostració de construcció d'un vehicle de categoria BASIC
        Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

        // demostració de construccuó d'un lloguer amb una data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        Date date = dateFormat.parse("2/8/2013");
        Lloguer lloguerBasic = new Lloguer(date, 9, vehicleBasic);
        yo.afegeix(lloguerBasic);
        String resultat = "<h1>Informe de lloguers del client Andrey (2345134T)</h1>\n" +
        "<p>	Vista Tata: 360.0€</p>\n" +
        "<h3>Import a pagar: 360.0€</h3>\n" +
        "<h3>Punts guanyats: 1</h3>\n";
        assertEquals(resultat,yo.informe());
    }
}
