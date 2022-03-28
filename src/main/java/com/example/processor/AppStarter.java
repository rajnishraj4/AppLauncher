package com.example.processor;

import com.example.processor.common.loader.AppModuleLoader;
import com.example.processor.kafka.setup.KafkaStarter;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class AppStarter {
    public static void main(String ...args) {
        Injector injector = Guice.createInjector(new AppModuleLoader());
        KafkaStarter starter = injector.getInstance(KafkaStarter.class);
        starter.setup();
    }
}
