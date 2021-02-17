package business;

import business.custom.impl.CourseBOImpl;
import business.custom.impl.RegistrationBOImpl;
import business.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null==boFactory) ? boFactory=new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case Student:
                return (T) new StudentBOImpl();
            case Course:
                return (T) new CourseBOImpl();
            case Registration:
                return (T) new RegistrationBOImpl();
            default:
                return null;
        }
    }
}
