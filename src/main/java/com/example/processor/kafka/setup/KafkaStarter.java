package com.example.processor.kafka.setup;

import com.example.processor.common.iface.IStarter;
import com.example.processor.common.runner.CommandRunner;
import com.example.processor.kafka.configuration.KafkaConfig;
import com.example.processor.kafka.model.KafkaConfigData;
import com.example.processor.utils.FileUtils;

import javax.inject.Inject;
import java.io.File;

public class KafkaStarter implements IStarter {

    private KafkaConfigData kafkaConfigData;
    private CommandRunner commandRunner;

    @Inject
    public KafkaStarter(KafkaConfig config, CommandRunner commandRunner)
    {
        this.kafkaConfigData = config.getKafkaConfig();
        this.commandRunner = commandRunner;
    }

    public void setup()
    {
        try{
            FileUtils.replace(kafkaConfigData.getErrorLogFile(),"Shivam","Aditi");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
//        commandRunner.exec("cmd","/c","dir");
    }
}
