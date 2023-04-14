package lk.sankalpa.hms.service;

import lk.sankalpa.hms.service.custom.impl.ReservationServiceImpl;
import lk.sankalpa.hms.service.custom.impl.RoomServiceImpl;
import lk.sankalpa.hms.service.custom.impl.StudentServiceImpl;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes serviceType) {
        switch (serviceType){

            case STUDENT:return (T) new StudentServiceImpl();
            case ROOM:return (T) new RoomServiceImpl();
            case RESERVATION:return (T) new ReservationServiceImpl();

            default:return null;
        }

    }


}
