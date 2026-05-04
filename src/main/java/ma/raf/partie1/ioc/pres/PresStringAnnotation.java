package ma.raf.partie1.ioc.pres;

import ma.raf.partie1.ioc.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresStringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ma.raf.partie1.ioc");
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("RES=" +metier.calcul());

    }
}
