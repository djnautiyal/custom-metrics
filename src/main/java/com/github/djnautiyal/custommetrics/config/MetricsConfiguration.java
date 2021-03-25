package com.github.djnautiyal.custommetrics.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.config.MeterFilterReply;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MetricsConfiguration {

    @Bean
    public MeterFilter meterFilter(){
        return new MeterFilter() {
            @Override
            public MeterFilterReply accept(Meter.Id id){
                if(id.getName().startsWith("jvm")
                        || id.getName().startsWith("logback")
                        || id.getName().startsWith("tomcat")
                        || id.getName().startsWith("process")
                || id.getName().startsWith("system")){
                    return MeterFilterReply.DENY;
                }
                return MeterFilterReply.NEUTRAL;
            }
        };
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry meterRegistry){
        return new TimedAspect(meterRegistry);
    }
}
