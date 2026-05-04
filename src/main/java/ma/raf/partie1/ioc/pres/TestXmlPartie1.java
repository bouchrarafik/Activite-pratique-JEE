package ma.raf.partie1.ioc.pres;


import ma.raf.partie1.ioc.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



    public class TestXmlPartie1 {
        public static void main(String[] args) {


            ApplicationContext context =
                    new ClassPathXmlApplicationContext("config-partie1.xml");

            IMetier metier = (IMetier) context.getBean("metier");

            System.out.println("RESULTAT PARTIE 1 = " + metier.calcul());
        }
    }


