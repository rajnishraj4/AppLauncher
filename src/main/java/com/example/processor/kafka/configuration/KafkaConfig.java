package com.example.processor.kafka.configuration;

import com.example.processor.common.iface.IBindable;
import com.example.processor.kafka.constants.KafkaConstants;
import com.example.processor.kafka.model.KafkaConfigData;
import com.example.processor.utils.ConfigReaderUtils;

public class KafkaConfig implements IBindable {

    private KafkaConfigData configData;

    public KafkaConfig() {
        this.configData = ConfigReaderUtils.yamlReader(KafkaConfigData.class, KafkaConstants.KAFKA_CONFIG_FILE);
    }

    public KafkaConfigData getKafkaConfig(){
        return configData;
    }
}
