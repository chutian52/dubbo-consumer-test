package com.fft.dubbo.consumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Bean(ReferenceAnnotationBeanPostProcessor.BEAN_NAME)
    public ReferenceAnnotationBeanPostProcessor referenceAnnotationBeanPostProcessor(){
        return new ReferenceAnnotationBeanPostProcessor();
    }


    @ConditionalOnMissingBean
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-consumer-test");
        applicationConfig.setId("dubbo-consumer-test");
        applicationConfig.setDefault(true);
        return applicationConfig;
    }

    @ConditionalOnMissingBean
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
        protocolConfig.setId("dubbo");
        protocolConfig.setClient("netty4");
        protocolConfig.setServer("netty4");
        protocolConfig.setDefault(true);
        return protocolConfig;
    }

    @ConditionalOnMissingBean
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig("localhost:2181");
        registryConfig.setId("zookeeper");
        registryConfig.setDefault(true);
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }
}
