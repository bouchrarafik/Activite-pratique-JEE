package ma.raf.partie1.ioc.pres;

import ma.raf.partie1.ioc.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presSpringXML {
    public static void main(String[] args) {

        ApplicationContext springContext = new ClassPathXmlApplicationContext("config-partie1.xml");
        IMetier metier = (IMetier) springContext.getBean("metier");
        //IMetier metier =  springContext.getBean(IMetier.class);

        System.out.println("RES="+metier.calcul());

    }
}
