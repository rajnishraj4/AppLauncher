package com.example.processor.common.loader;

import com.example.processor.common.iface.IStarter;
import com.example.processor.common.runner.CommandRunner;
import com.example.processor.common.iface.IBindable;
import com.example.processor.common.iface.ICommandRunner;
import com.example.processor.kafka.configuration.KafkaConfig;
import com.example.processor.kafka.setup.KafkaStarter;
import com.google.inject.AbstractModule;

public class AppModuleLoader extends AbstractModule{

    @Override
    protected void configure() {
        bind(IBindable.class).to(KafkaConfig.class);
        bind(ICommandRunner.class).to(CommandRunner.class);
        bind(IStarter.class).to(KafkaStarter.class);
    }
}
