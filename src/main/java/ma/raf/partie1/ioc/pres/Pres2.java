package ma.raf.partie1.ioc.pres;

import ma.raf.partie1.ioc.dao.IDao;
import ma.raf.partie1.ioc.metier.IMetier;

import java.io.File;
import java.util.Scanner;

public class Pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("src/test/Config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d=(IDao) cDao.newInstance();

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier= (IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        //IMetier metier = (IMetier) cMetier.getConstructor().newInstance();
        //Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
        //setDao.invoke(metier,d);

        System.out.println("RES="+metier.calcul());
    }
}

