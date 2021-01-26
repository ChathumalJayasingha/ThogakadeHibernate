package lk.ijse.thogakadehibernate.business;

import lk.ijse.thogakadehibernate.business.custom.Impl.CustomerBOImpl;
import lk.ijse.thogakadehibernate.business.custom.Impl.ItemBOImpl;

public class BOFactory {

    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory==null?boFactory=new BOFactory():boFactory;
    }

    public Object getBO(BOType boType){
        switch (boType){
            case CUSTOMER: return new CustomerBOImpl();
            case ITEM: return  new ItemBOImpl();
            default:return null;
        }
    }
}
