package com.ratnikov.serialization;

import java.io.IOException;

public class MainCache {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service service = new ServiceImpl();
        Service proxyImpl = (Service) CacheProxyImpl.newInstance(service, CacheType.MEMORY, "C:\\JavaSchoolSber\\lesson8_Serialization\\src\\main\\resources\\");
        proxyImpl.calc(897, 587);
    }
}
