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

    public Lloguer test(int i){
        Lloguer lloguer = this.lloguers.get(i);
        return lloguer;
    }

    public String informe() {
    	double total = 0;
        int bonificacions = 0;
        String resultat = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
            double quantitat = 0;
            switch (lloguer.getVehicle().getCategoria()) {
                case Vehicle.BASIC:
                    quantitat += 3;
                    if (lloguer.getDias() > 3) {
                        quantitat += (lloguer.getDias() - 3) * 1.5;
                    }
                    break;
                case Vehicle.GENERAL:
                    quantitat += 4;
                    if (lloguer.getDias() > 2) {
                        quantitat += (lloguer.getDias() - 2) * 2.5;
                    }
                    break;
                case Vehicle.LUXE:
                    quantitat += lloguer.getDias() * 6;
                    break;
            }

            // afegeix lloguers freqüents
            bonificacions ++;

            // afegeix bonificació per dos dies de lloguer de Luxe
            if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                    lloguer.getDias()>1 ) {
                bonificacions ++;
            }

            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModelo() + ": " +
                    (quantitat * 30) + "€" + "\n";
            total += quantitat * 30;
        }

        // afegeix informació final
        resultat += "Import a pagar: " + total + "€\n" +
                "Punts guanyats: " + bonificacions + "\n";
        return resultat;
    }
}
