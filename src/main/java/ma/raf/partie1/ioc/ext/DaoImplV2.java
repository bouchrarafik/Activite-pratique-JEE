package ma.raf.partie1.ioc.ext;


import ma.raf.partie1.ioc.dao.IDao;
import org.springframework.stereotype.Component;

@Component("d2")

public class DaoImplV2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version capteurs......");
        double t = 14;
        return t;
    }
}

