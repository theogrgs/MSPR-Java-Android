package mspr.java.android_ocrsample;

public class IDCInformation {

    private String nom;
    private String prenom;
    private String numCarte;

    IDCInformation() {
        nom = "";
        prenom = "";
        numCarte = "";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(String numCarte) {
        this.numCarte = numCarte;
    }
}
