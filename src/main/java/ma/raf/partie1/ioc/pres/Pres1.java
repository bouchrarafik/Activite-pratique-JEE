package ma.raf.partie1.ioc.pres;

import ma.raf.partie1.ioc.ext.DaoImplV2;
import ma.raf.partie1.ioc.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d);//injection des dependances via setter
        System.out.println("RES="+metier.calcul());
    }
}
