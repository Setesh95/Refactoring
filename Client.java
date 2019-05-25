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

        return cabecera()+
                detalles()+
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
                    lloguer.quantitat() + "€" + "\n";
        }
        return detalles;
    }

    public String infoFinal(){
        String infoFinal = "Import a pagar: " + importTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotals() + "\n";
        return infoFinal;
    }

    public String informeHTML() {
        double total = 0;
        int bonificacions = 0;
        String cabecera;
        String lloguerCoche;
        String alquilerTotal = "";
        String resultat;
        cabecera = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")";
        for (Lloguer lloguer: lloguers) {

            // afegeix lloguers freqüents
            bonificacions ++;

            // afegeix bonificació per dos dies de lloguer de Luxe
            if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                    lloguer.getDies()>1 ) {
                bonificacions ++;
            }

            // composa els resultats d'aquest lloguer
            lloguerCoche = "\t\t<td>"+lloguer.getVehicle().getMarca()+"</td>\n";
            lloguerCoche += "\t\t<td>"+lloguer.getVehicle().getModel() + "</td>\n";
            lloguerCoche += "\t\t<td>"+lloguer.quantitat() + "€"+"</td>\n";

            lloguerCoche = "\t<tr>\n"+lloguerCoche+"\t</tr>\n";

            alquilerTotal += lloguerCoche;

            total += lloguer.quantitat();
        }

        // afegeix informació final

        cabecera = "<h2>"+cabecera+"</h2>\n";
        String tabla = "<table>\n"+
                        "   <tr>\n"+
                        "       <td>Marca</td>\n"+
                        "       <td>Modelo</td>\n"+
                        "       <td>Cantidad</td>\n"+
                        "   </tr>\n";
        String totalEuros = "   <tr>\n"+
                            "       <td>Total</td>\n"+
                            "       <td></td>\n"+
                            "       <td>"+total+"€</td>\n"+
                            "   </tr>\n"+
                            "</table>";
        resultat = cabecera+tabla+alquilerTotal+totalEuros;

        return resultat;
    }

    public double importTotal(){
        int total=0;
        for(Lloguer lloguer: lloguers){
            total += lloguer.quantitat();
        }
        return total;
    }

    public int bonificacionsTotals(){
        int bonificacions=0;
        for(Lloguer lloguer: lloguers){
            bonificacions += lloguer.bonificacions();
        }
        return bonificacions;
    }
}
