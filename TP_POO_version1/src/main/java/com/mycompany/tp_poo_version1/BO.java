package com.mycompany.tp_poo_version1;

public class BO {

    private Anamnese anamnese;
    private EpreuveClinique[] listeEpreuves;
    private Diagnostic diagnostic;
    private String projetTherapeutique;
    private String numTel;

    public BO (Anamnese anamnese, Diagnostic diagnostic, String projetTherapeutique, String numTel) {
        this.anamnese = anamnese;
        this.diagnostic = diagnostic;
        this.projetTherapeutique = projetTherapeutique;
        this.numTel = numTel;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }
    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

    public EpreuveClinique[] getListeEpreuves() {
        return listeEpreuves;
    }

    public void setListeEpreuves(EpreuveClinique[] listeEpreuves) {
        this.listeEpreuves = listeEpreuves;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getProjetTherapeutique() {
        return projetTherapeutique;
    }

    public void setProjetTherapeutique(String projetTherapeutique) {
        this.projetTherapeutique = projetTherapeutique;
    }

    public String getNumTel() {
        return(this.numTel);
    }

    public void setNumTel(String numTel) {
        this.numTel=numTel;
    }

}