import org.junit.*;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClientInfo {

    @Test
    public void TestSinAlquiler() throws ParseException {
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
        "Import a pagar: 0.0€\n" +
        "Punts guanyats: 0\n";
        assertEquals(resultat,yo.informe());
    }

     @Test
    public void TestMoltsAlquilers() throws ParseException{
         //Creamos el cliente
         Client yo = new Client("2345134T","Andrey","678412659");

         // Creamos vehiculos
         Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
         Vehicle vehicleGeneral = new Vehicle("Mondeo", "Ford", Vehicle.GENERAL);
         Vehicle vehicleLuxe = new Vehicle("745i", "BMW", Vehicle.LUXE);

         //Configuramos el formato de la data
         SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
         //Damos valor a data y agregamos el alquiler
         Date date = dateFormat.parse("23/3/2019");
         Lloguer lloguerBasic = new Lloguer(date, 25, vehicleBasic);
         yo.afegeix(lloguerBasic);

         date = dateFormat.parse("13/4/2019");
         lloguerBasic = new Lloguer(date,30,vehicleGeneral);
         yo.afegeix(lloguerBasic);

         date = dateFormat.parse("7/2/2019");
         lloguerBasic = new Lloguer(date,10,vehicleLuxe);
         yo.afegeix(lloguerBasic);

         String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                 "\tVista Tata: 1080.0€\n" +
                 "\tFord Mondeo: 2220.0€\n" +
                 "\tBMW 745i: 1800.0€\n" +
                 "Import a pagar: 5100.0€\n" +
                 "Punts guanyats: 4\n";

         assertEquals(resultat,yo.informe());
     }

    @Test
    public void TestVehicleGeneral() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("Mondeo", "Ford", Vehicle.GENERAL);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,1,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tFord Mondeo: "+(4*30)+".0€\n" +
                "Import a pagar: "+(4*30)+".0€\n" +
                "Punts guanyats: 1\n";

        assertEquals(resultat,yo.informe());
    }

    @Test
    public void TestVehicleGeneralDosDies() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("Mondeo", "Ford", Vehicle.GENERAL);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,2,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tFord Mondeo: "+(4*30)+".0€\n" +
                "Import a pagar: "+(4*30)+".0€\n" +
                "Punts guanyats: 1\n";

        assertEquals(resultat,yo.informe());
    }
    @Test
    public void TestVehicleGeneralMesDies() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("Mondeo", "Ford", Vehicle.GENERAL);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,3,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tFord Mondeo: "+((4+(3-2)*2.5)*30)+"€\n" +
                "Import a pagar: "+((4+(3-2)*2.5)*30)+"€\n" +
                "Punts guanyats: 1\n";

        assertEquals(resultat,yo.informe());
    }
    @Test
    public void TestVehicleLuxe() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("745i", "BMW", Vehicle.LUXE);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,1,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tBMW 745i: "+(6*30)+".0€\n" +
                "Import a pagar: "+(6*30)+".0€\n" +
                "Punts guanyats: 1\n";

        assertEquals(resultat,yo.informe());
    }

    @Test
    public void TestVehicleLuxeDosDies() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("745i", "BMW", Vehicle.LUXE);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,2,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tBMW 745i: "+(2*6*30)+".0€\n" +
                "Import a pagar: "+(2*6*30)+".0€\n" +
                "Punts guanyats: 2\n";

        assertEquals(resultat,yo.informe());
    }
    @Test
    public void TestVehicleLuxeMesCoches() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("745i", "BMW", Vehicle.LUXE);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,5,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        vehicleGeneral = new Vehicle("rx8","Mazda",Vehicle.LUXE);
        date = dateFormat.parse("15/5/2019");
        lloguerBasic = new Lloguer(date,1, vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tBMW 745i: "+(5*6*30)+".0€\n" +
                "\tMazda rx8: "+(6*30)+".0€\n" +
                "Import a pagar: "+((5*6*30)+6*30)+".0€\n" +
                "Punts guanyats: 3\n";

        assertEquals(resultat,yo.informe());
    }
    @Test
    public void TestVehicleLuxeMesCochesYdies() throws ParseException{
        //Creamos el cliente
        Client yo = new Client("2345134T","Andrey","678412659");

        // Creamos vehiculos
        Vehicle vehicleGeneral = new Vehicle("745i", "BMW", Vehicle.LUXE);

        //Configuramos el formato de la data
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        //Damos valor a data y agregamos el alquiler

        Date date = dateFormat.parse("13/4/2019");
        Lloguer lloguerBasic = new Lloguer(date,5,vehicleGeneral);
        yo.afegeix(lloguerBasic);

        vehicleGeneral = new Vehicle("rx8","Mazda",Vehicle.LUXE);
        date = dateFormat.parse("15/5/2019");
        lloguerBasic = new Lloguer(date,4, vehicleGeneral);
        yo.afegeix(lloguerBasic);

        String resultat = "Informe de lloguers del client Andrey (2345134T)\n" +
                "\tBMW 745i: "+(5*6*30)+".0€\n" +
                "\tMazda rx8: "+(4*6*30)+".0€\n" +
                "Import a pagar: "+((5*6*30)+4*6*30)+".0€\n" +
                "Punts guanyats: 4\n";

        assertEquals(resultat,yo.informe());
    }
}
