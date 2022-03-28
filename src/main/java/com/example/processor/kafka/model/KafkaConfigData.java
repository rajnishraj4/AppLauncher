package com.example.processor.kafka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class KafkaConfigData {
    private String installationDir;
    private String version;
    private String port;
    private String setupLogDir;
    private String outputLogFileName;
    private String errorLogFileName;

    public String getOutputLogFile()
    {
        return setupLogDir+outputLogFileName;
    }
    public String getErrorLogFile()
    {
        return setupLogDir+errorLogFileName;
    }
}
