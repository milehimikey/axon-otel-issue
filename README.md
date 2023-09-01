# Issue with Axon 4.8.2 with OTEL

This example illustrates a class cast exception when using Axon 4.8.2 with `axon-tracing-opentelemetry`.  This app doesn't do anything at all except configure an OpenTelemetrySpanFactory bean.

*Note: This app uses spring-boot-docker-compose, the axon-server will startup upon starting the application automatically.* 

When running this app it will fail with the following exception:

```
Caused by: java.lang.ClassCastException: class org.axonframework.tracing.opentelemetry.OpenTelemetrySpanFactory cannot be cast to class org.axonframework.tracing.SpanFactory (org.axonframework.tracing.opentelemetry.OpenTelemetrySpanFactory is in unnamed module of loader 'app'; org.axonframework.tracing.SpanFactory is in unnamed module of loader org.springframework.boot.devtools.restart.classloader.RestartClassLoader @46cde206)
	at java.base/java.util.Collections$SingletonList.forEach(Collections.java:4966) ~[na:na]
	at org.axonframework.tracing.MultiSpanFactory.registerSpanAttributeProvider(MultiSpanFactory.java:100) ~[axon-messaging-4.8.1.jar:4.8.1]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
	at org.axonframework.springboot.autoconfig.AxonTracingAutoConfiguration.lambda$null$0(AxonTracingAutoConfiguration.java:76) ~[axon-spring-boot-autoconfigure-4.8.1.jar:4.8.1]
	at org.axonframework.config.DefaultConfigurer.lambda$invokeInitHandlers$48(DefaultConfigurer.java:819) ~[axon-configuration-4.8.1.jar:4.8.1]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
	at org.axonframework.config.DefaultConfigurer.invokeInitHandlers(DefaultConfigurer.java:819) ~[axon-configuration-4.8.1.jar:4.8.1]
	at org.axonframework.config.DefaultConfigurer.buildConfiguration(DefaultConfigurer.java:780) ~[axon-configuration-4.8.1.jar:4.8.1]
	at org.axonframework.spring.config.SpringAxonConfiguration.getObject(SpringAxonConfiguration.java:64) ~[axon-spring-4.8.1.jar:4.8.1]
	at org.axonframework.spring.config.SpringAxonConfiguration.getObject(SpringAxonConfiguration.java:41) ~[axon-spring-4.8.1.jar:4.8.1]
	at org.springframework.beans.factory.support.FactoryBeanRegistrySupport.doGetObjectFromFactoryBean(FactoryBeanRegistrySupport.java:148) ~[spring-beans-6.0.11.jar:6.0.11]
	... 48 common frames omitted
```

