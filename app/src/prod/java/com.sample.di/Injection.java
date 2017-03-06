package com.sample.di;

import com.sample.di.data.Repositories;
import com.sample.di.data.Repository;
import com.sample.di.data.ServiceApiImpl;

public class Injection {

    public static Repository provideRepository() {
        return Repositories.getRepoInstance(new ServiceApiImpl());
    }
}
