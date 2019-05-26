import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }

    public String getNom()     { return nom;     }

    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }

    public void setNom(String nom) { this.nom = nom; }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }

    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }

    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public int numLloguers(){
        return this.lloguers.size();
    }

    public Lloguer LloguerDeterminat(int i){
        Lloguer lloguer = this.lloguers.get(i);
        return lloguer;
    }

    public String informe() {

        return cabecera() +
                detalles() +
                infoFinal();
    }

    public String cabecera(){
        String cabecera = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
        return cabecera;
    }

    public String detalles(){
        String detalles = "";
        for (Lloguer lloguer: lloguers) {

            // composa els resultats d'aquest lloguer
            detalles += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    lloguer.PreuDelAlquiler() + "€" + "\n";
        }
        return detalles;
    }

    public String infoFinal(){
        String infoFinal = "Import a pagar: " + importTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotals() + "\n";
        return infoFinal;
    }

    public String informeHTML() {

        return cabeceraHTML() +
                detallesHTML() +
                infoFinalHTML();
    }

    public String cabeceraHTML(){
        String cabecera = "";
        cabecera += "Informe de lloguers del client " +
               "<em>" + getNom() + "</em>" +
                " (<strong>" + getNif() + "</strong>)";
        cabecera = "<p>" + cabecera + "</p>\n";
        cabecera = "<h1>Informe de lloguers</h1>\n" + cabecera;
        return cabecera;
    }

    public String detallesHTML(){
        String detalle;
        String detalles = "";
        for (Lloguer lloguer: lloguers) {

            // composa els resultats d'aquest lloguer
            detalle = "<td>" + lloguer.getVehicle().getMarca() + "</td>";
            detalle += "<td>" + lloguer.getVehicle().getModel() + "</td>";
            detalle += "<td>" + lloguer.PreuDelAlquiler() + "€"+"</td>";

            detalle = "\t<tr>" + detalle + "</tr>\n";

            detalles += detalle;
        }
        String tabla = "<table>\n" +
                "\t<tr>" +
                "<td><strong>Marca</strong></td>" +
                "<td><strong>Modelo</strong></td>" +
                "<td><strong>Importe</strong></td>" +
                "</tr>\n";

        detalles = tabla + detalles + "</table>\n";
        return detalles;
    }

    public String infoFinalHTML(){
        String infoFinal = "<p>Import a pagar: " + "<em>" + importTotal() + "€</em>" + "</p>\n" +
                "<p>Punts guanyats: " + "<em>" + bonificacionsTotals() + "</em>" + "</p>";
        return infoFinal;
    }

    public double importTotal(){
        int total = 0;
        for(Lloguer lloguer: lloguers){
            total += lloguer.PreuDelAlquiler();
        }
        return total;
    }

    public int bonificacionsTotals(){
        int bonificacions = 0;
        for(Lloguer lloguer: lloguers){
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }
}
