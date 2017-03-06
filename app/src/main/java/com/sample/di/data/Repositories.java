package com.sample.di.data;

public class Repositories {

    private Repositories() {
    }

    private static Repository sRepository = null;

    public synchronized static Repository getRepoInstance(ServiceApi serviceApi) {
        if (null == sRepository) {
            sRepository = new RepositoryImpl(serviceApi);
        }
        return sRepository;
    }
}
