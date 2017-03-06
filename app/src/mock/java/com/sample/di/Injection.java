package com.sample.di;

import com.sample.di.data.MockServiceApiImpl;
import com.sample.di.data.Repositories;
import com.sample.di.data.Repository;

public class Injection {

    public static Repository provideRepository() {
        return Repositories.getRepoInstance(new MockServiceApiImpl());
    }
}
