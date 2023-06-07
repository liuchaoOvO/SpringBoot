# Nacos  Config Example

## 项目说明

本项目演示如何使用 Nacos Config Starter 完成 Spring Cloud 应用的配置管理。

[Nacos](https://github.com/alibaba/Nacos) 是阿里巴巴开源的一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
## 示例

### 如何接入

1. 首先，修改 pom.xml 文件，引入 Nacos Config Starter。

       <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>

2. 在应用的 /src/main/resources/bootstrap.properties 配置文件中配置 Nacos Config 元数据

        spring.application.name=nacos-config-example
        spring.cloud.nacos.config.server-addr=127.0.0.1:8848

3. 完成上述两步后，应用会从 Nacos Config 中获取相应的配置，并添加在 Spring Environment 的 PropertySources 中。假设我们通过 Nacos 配置中心保存 Nacos 的部分配置,有以下四种例子:
- BeanAutoRefreshConfigExample:  通过将配置信息配置为bean，支持配置变自动刷新的例子
- ConfigListenerExample:         监听配置信息的例子
- DockingInterfaceExample:       对接 nacos 接口，通过接口完成对配置信息增删改查的例子
- ValueAnnotationExample:        通过 @Value 注解进行配置信息获取的例子
- SharedConfigExample:           共享配置的例子
- ExtensionConfigExample:        扩展配置的例子