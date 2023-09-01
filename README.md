# Issue with Axon 4.8.2 with OTEL

This example illustrates a class cast exception when using Axon 4.8.2 with `axon-tracing-opentelemetry`.  This app doesn't do anything at all except configure an OpenTelemetrySpanFactory bean.

*Note: This app uses spring-boot-docker-compose, the axon-server will startup upon starting the application automatically.* 

When running this app it will fail with the following exception:

```
Caused by: java.lang.ClassCastException: class io.opentelemetry.sdk.trace.TracerSdkProvider cannot be cast to class io.opentelemetry.api.trace.TracerProvider (io.opentelemetry.sdk.trace.TracerSdkProvider and io.opentelemetry.api.trace.TracerProvider are in unnamed module of loader 'app')
    at org.axonframework.tracing.opentelemetry.OpenTelemetrySpanFactory.<init>(OpenTelemetrySpanFactory.java:38) ~[axon-tracing-opentelemetry-4.8.2.jar:4.8.2]
    at org.axonframework.tracing.opentelemetry.OpenTelemetryAutoConfiguration.openTelemetrySpanFactory(OpenTelemetryAutoConfiguration.java:37) ~[axon-tracing-opentelemetry-4.8.2.jar:4.8.2]
    at org.axonframework.tracing.opentelemetry.OpenTelemetryAutoConfiguration$$EnhancerBySpringCGLIB$$b0f0b0e8.CGLIB$openTelemetrySpanFactory$0(<generated>) ~[axon-tracing-opentelemetry-4.8.2.jar:4.8.2]
    at org.axonframework.tracing.opentelemetry.OpenTelemetryAutoConfiguration$$EnhancerBySpringCGLIB$$b0f0b0e8$$FastClassBySpringCGLIB$$e0f0b0e5.invoke(<generated>) ~[axon-tracing-opentelemetry-4.8.2.jar:4.8.2]
    at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:244) ~[spring-core-5.3.9.jar:5.3.9]
    at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[spring-context-5.3.9.jar:5.3.9]
    at org.axonframework.tracing.opentelemetry.OpenTelemetryAutoConfiguration$$EnhancerBySpringCGLIB$$b0f0b0e8.openTelemetrySpanFactory(<generated>) ~[axon-tracing-opentelemetry-4.8.2.jar:4.8.2]
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:78) ~[na:na]
    at java.base/j
```

