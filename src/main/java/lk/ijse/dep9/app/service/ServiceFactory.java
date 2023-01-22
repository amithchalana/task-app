package lk.ijse.dep9.app.service;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return (serviceFactory == null) ? serviceFactory = new ServiceFactory() : serviceFactory;
    }
}
