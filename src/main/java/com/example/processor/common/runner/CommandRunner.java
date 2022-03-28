package com.example.processor.common.runner;

import com.example.processor.common.iface.ICommandRunner;
import com.example.processor.kafka.configuration.KafkaConfig;
import com.example.processor.kafka.model.KafkaConfigData;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandRunner implements ICommandRunner {

    private KafkaConfigData configData;

    @Inject
    public CommandRunner(KafkaConfig config)
    {
        this.configData = config.getKafkaConfig();
    }

    public void exec(File execFilePath, String ... args){
        try{
            File error = new File(configData.getErrorLogFile());
            File output = new File(configData.getOutputLogFile());

            ProcessBuilder builder = new ProcessBuilder(args);
            builder.directory(execFilePath);
            builder.redirectOutput(output);
            builder.redirectError(error);
            builder.start();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exec(String ... args) {
        exec(new File(configData.getSetupLogDir()),args);
    }

    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
