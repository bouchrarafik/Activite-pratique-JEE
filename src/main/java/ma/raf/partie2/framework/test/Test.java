
package ma.raf.partie2.framework.test;

import ma.raf.partie2.framework.context.ApplicationContext;
import ma.raf.partie2.framework.dao.DaoImpl;
import ma.raf.partie2.framework.metier.MetierImpl;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context =
                new ApplicationContext(
                        new Class[]{
                                DaoImpl.class,
                                MetierImpl.class
                        }
                );

        // ✅ récupérer le bean
        MetierImpl metier = context.getBean(MetierImpl.class);

        // ✅ afficher le résultat
        System.out.println("Résultat = " + metier.calcul());
    }
}


