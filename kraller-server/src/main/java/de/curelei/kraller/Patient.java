package de.curelei.kraller;

public class Patient {
    private int id;
    private String vname;
    private String nname;
    private int alter;
    private String geschlecht;
    private String raum;
    private String[] allergene;


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getVname(){
        return vname;
    }
    public void setVname(String vname){
        this.vname=vname;
    }

    public String getNname(){
        return nname;
    }
    public void setNname(String nname) {
        this.nname = nname;
    }

    public int getAlter() {
        return alter;
    }
    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getGeschlecht() {
        return geschlecht;
    }
    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getPatientRaum(){
        return raum;
    }
    public void setPatientRaum(String raum){
        this.raum = raum;
    }

    public String[] getPatientAllergene(){
        return allergene;
    }

    public void setAllergene(String[] allergene) {
        this.allergene = allergene;
    }

}
