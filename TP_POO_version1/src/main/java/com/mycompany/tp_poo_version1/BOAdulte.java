package com.mycompany.tp_poo_version1;

public class BOAdulte extends BO {

    private String diplome;
    private String profession;

    public BOAdulte(Anamnese anamnese, Diagnostic diagnostic, String projetTherapeutique, String numTel, String diplome, String profession) {
        super(anamnese,diagnostic,projetTherapeutique,numTel);
        this.diplome = diplome;
        this.profession = profession;
    }

    public String getDiplome() {
        return(this.diplome);
    }

    public String getProfission() {
        return(this.profession);
    }

    public void setDiplome(String diplome) {
        this.diplome=diplome;
    }

    public void setProfission(String profission) {
        this.profession =profission;
    }

}
