package metier;

import dao.IDao;

import lombok.*;
import model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data @AllArgsConstructor @NoArgsConstructor
@Service("metier")
public class CreditMetier implements ICreditMetier{
    @Autowired
    @Qualifier("dao")
    IDao<Credit,Long> creditDao;
    @Override
    public Credit calculer_Mensualite(Long id) throws Exception{
        var credit = creditDao.trouverParID(id);

        if (credit == null)
        {
            throw new Exception("L'id du credit est incorrecte :: [Credit non trouve]");
        }
        else {
            double  Mustapha_taux         = credit.getMustapha_taux_Mensuel();
            Mustapha_taux         = Mustapha_taux/1200;
            double  Mustapha_capitale     = credit.getMustapha_capitale_Emprunt();
            int     Mustapha_nbr_mois     = credit.getMustapha_nombre_Mois();

            double  Mustapha_mensualite   = (Mustapha_capitale * Mustapha_taux) / (1 - (Math.pow((1 + Mustapha_taux), -1 * Mustapha_nbr_mois)));
            Mustapha_mensualite   = Math.round(Mustapha_mensualite*100)/100;

                   credit.setMustapha_mensualite(Mustapha_mensualite);

            return credit;
        }
    }
}
