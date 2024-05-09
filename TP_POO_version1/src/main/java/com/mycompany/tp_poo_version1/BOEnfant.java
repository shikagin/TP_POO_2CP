package com.mycompany.tp_poo_version1;

public class BOEnfant extends BO {
    private String classeEtude;

    public BOEnfant(Anamnese anamnese, Diagnostic diagnostic, String projetTherapeutique, String numTel, String classeEtude) {
        super(anamnese,diagnostic,projetTherapeutique,numTel);
        this.classeEtude = classeEtude;
    }

    public String getClasseEtude()
    {
        return(this.classeEtude);
    }
    public void setClasseEtude(String classeEtude)
    {
        this.classeEtude=classeEtude;
    }

}
