package ma.raf.partie1.ioc.pres;


import ma.raf.partie1.ioc.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotations {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("ma.raf.partie1");

        IMetier metier = context.getBean(IMetier.class);

        System.out.println("RESULTAT PARTIE 1 = " + metier.calcul());
    }
}
