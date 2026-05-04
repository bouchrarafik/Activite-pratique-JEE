package ma.raf.partie1.ioc.metier;

import ma.raf.partie1.ioc.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component("metier")
public class MetierImpl implements IMetier {

    private IDao dao; //couplage faible
    /**
     * pour injecter dans l atrtribut dao
     * un pbjet d une class qui implemente linterface IDao
     * au moment de l instantiation
     */
    public MetierImpl(@Qualifier("d") IDao dao) {
        this.dao = dao;
    }
   // public MetierImpl() {
    //}
    @Override

    public double calcul() {
        double t = dao.getData();
        double res = t * 540*Math.PI/2*Math.cos(t);
        return res;
    }
    /**
     * pour injecter dans l atrtribut dao
     * un pbjet d une class qui implemente linterface IDao
     * apres l instantiation
     */
    //public void setDao (IDao dao) {
    //this.dao = dao;
    //}
}





