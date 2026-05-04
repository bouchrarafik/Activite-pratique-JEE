package ma.raf.partie2.framework.metier;

import ma.raf.partie1.ioc.metier.IMetier;
import ma.raf.partie2.framework.annotation.InjectMe;
import ma.raf.partie2.framework.dao.IDao;

public class MetierImpl implements IMetier {


    // ✔ Injection par attribut

    @InjectMe
    private IDao dao;


    // ✔ Injection par setter

    private IDao dao2;

    public void setDao2(IDao dao2) {
        this.dao2 = dao2;
    }


    // ✔ Injection par constructeur

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    // constructeur vide (important pour ton framework)
    public MetierImpl() {}


    // ✔ logique métier

    @Override
    public double calcul() {
        return dao.getData() * 2;
    }
}