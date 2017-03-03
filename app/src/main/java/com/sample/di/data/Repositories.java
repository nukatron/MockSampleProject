package com.sample.di.data;

public class Repositories {

    //flag to switch between mock mode and real mode
    private static boolean isMockMode = true;

    private Repositories() {
    }

    private static Repository sRepository = null;

    public synchronized static Repository getRepoInstance() {
        if (null == sRepository) {
            sRepository = new RepositoryImpl(getServiceApi());
        }
        return sRepository;
    }

    private static ServiceApi getServiceApi() {
        if(isMockMode) {
            return new MockServiceApiImpl();
        }
        return new ServiceApiImpl();
    }
}
