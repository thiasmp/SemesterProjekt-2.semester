package business.entities;

public class Stykliste {

    private int forespørgsel_id;
    private int materiale_id;
    private String navn;
    private String beskrivelse;
    private int længde;
    private int antal;
    private String enhed;

    public Stykliste(int forespørgsel_id, int materiale_id, String navn, String beskrivelse, int længde, int antal, String enhed) {
        this.forespørgsel_id = forespørgsel_id;
        this.materiale_id = materiale_id;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.længde = længde;
        this.antal = antal;
        this.enhed = enhed;
    }

    public int getForespørgsel_id() {
        return forespørgsel_id;
    }

    public void setForespørgsel_id(int forespørgsel_id) {
        this.forespørgsel_id = forespørgsel_id;
    }

    public int getMateriale_id() {
        return materiale_id;
    }

    public void setMateriale_id(int materiale_id) {
        this.materiale_id = materiale_id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getLængde() {
        return længde;
    }

    public void setLængde(int længde) {
        this.længde = længde;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getEnhed() {
        return enhed;
    }

    public void setEnhed(String enhed) {
        this.enhed = enhed;
    }
}
