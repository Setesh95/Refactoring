import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestInfoHTML {
    @Test
    public void TestInfoHTML(){
        Client yo = new Client("2345134T","Andrey","678412659");

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>0.0€</em></p>\n" +
                "<p>Punts guanyats: <em>0</em></p>";
        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestInfoHTMLVariosVehiculos() throws ParseException {
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>Vista</td><td>Tata</td><td>1080.0€</td></tr>\n" +
                "\t<tr><td>Ford</td><td>Mondeo</td><td>2220.0€</td></tr>\n" +
                "\t<tr><td>BMW</td><td>745i</td><td>1800.0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>5100.0€</em></p>\n" +
                "<p>Punts guanyats: <em>4</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLgeneral() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>Ford</td><td>Mondeo</td><td>" + (4*30) + ".0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + (4*30) + ".0€</em></p>\n" +
                "<p>Punts guanyats: <em>1</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLGeneralDosDies() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>Ford</td><td>Mondeo</td><td>" + (4*30) + ".0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + (4*30) + ".0€</em></p>\n" +
                "<p>Punts guanyats: <em>1</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLGeneralMesDies() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>Ford</td><td>Mondeo</td><td>" + ((4+(3-2)*2.5)*30) + "€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + ((4+(3-2)*2.5)*30) + "€</em></p>\n" +
                "<p>Punts guanyats: <em>1</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLLuxe() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>BMW</td><td>745i</td><td>" + (6*30) + ".0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + (6*30) + ".0€</em></p>\n" +
                "<p>Punts guanyats: <em>1</em></p>";
        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLLuxeDosDies() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>BMW</td><td>745i</td><td>" + (2*6*30) + ".0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + (2*6*30) + ".0€</em></p>\n" +
                "<p>Punts guanyats: <em>2</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLLuxeMesCoches() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>BMW</td><td>745i</td><td>" + (5*6*30) + ".0€</td></tr>\n" +
                "\t<tr><td>Mazda</td><td>rx8</td><td>" + (6*30) + ".0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + (5*6*30+6*30) + ".0€</em></p>\n" +
                "<p>Punts guanyats: <em>3</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }

    @Test
    public void TestHTMLLuxeMesCochesYdies() throws ParseException{
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

        String resultat = "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Andrey</em> (<strong>2345134T</strong>)</p>\n" +
                "<table>\n" +
                "\t<tr><td><strong>Marca</strong></td><td><strong>Modelo</strong></td><td><strong>Importe</strong></td></tr>\n" +
                "\t<tr><td>BMW</td><td>745i</td><td>" + (5*6*30) + ".0€</td></tr>\n" +
                "\t<tr><td>Mazda</td><td>rx8</td><td>" + (4*6*30) + ".0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>" + (5*6*30+4*6*30) + ".0€</em></p>\n" +
                "<p>Punts guanyats: <em>4</em></p>";

        assertEquals(resultat,yo.informeHTML());
    }
}
