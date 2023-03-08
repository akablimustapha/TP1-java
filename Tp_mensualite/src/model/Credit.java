package model;


import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor
public class Credit {


    private Long Mustapha_id;
    private Double Mustapha_capitale_Emprunt;
    private Integer Mustapha_nombre_Mois;
    private Double Mustapha_taux_Mensuel;
    private String Mustapha_nom_Demandeur;
    private Double Mustapha_mensualite;

    @Override
    public String toString(){
        var creditStr = "==================================================================== \n";
            creditStr+= "=> Crédit n°                  : " +getMustapha_id()+ "                        \n";
            creditStr+= "=> Nom du demandeur de crédit : " + getMustapha_nom_Demandeur() + "           \n";
            creditStr+= "-------------------------------------------------------------------- \n";
            creditStr+= "=> Capitale Emprunté          : " + getMustapha_capitale_Emprunt() + "        \n";
            creditStr+= "=> Nombre de mois             : " + getMustapha_nombre_Mois() + "             \n";
            creditStr+= "=> Taux mensuel               : " + getMustapha_taux_Mensuel() + "            \n" ;
            creditStr+= "-------------------------------------------------------------------- \n";
            creditStr+= "=> Mensualité                 : "
                    + (getMustapha_mensualite() == 0.0 ? "NON-CALCULE":getMustapha_mensualite()+ " DH/mois")+"\n";
            creditStr+= "==================================================================== \n";

        return creditStr;
    }
}
