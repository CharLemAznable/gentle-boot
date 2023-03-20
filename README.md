### gentle-boot

[![Build](https://github.com/CharLemAznable/gentle-boot/actions/workflows/build.yml/badge.svg)](https://github.com/CharLemAznable/gentle-boot/actions/workflows/build.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.charlemaznable/gentle-boot/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.charlemaznable/gentle-boot/)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
![GitHub code size](https://img.shields.io/github/languages/code-size/CharLemAznable/gentle-boot)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=alert_status)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)

[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=bugs)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=security_rating)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=sqale_index)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=code_smells)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=ncloc)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=coverage)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=CharLemAznable_gentle-boot&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=CharLemAznable_gentle-boot)

Some Spring Boot Plugins/Utils/Elves.

##### Maven Dependency

```xml
<dependency>
  <groupId>com.github.charlemaznable</groupId>
  <artifactId>gentle-boot</artifactId>
  <version>2022.0.7</version>
</dependency>
```

##### Maven Dependency SNAPSHOT

```xml
<dependency>
  <groupId>com.github.charlemaznable</groupId>
  <artifactId>gentle-boot</artifactId>
  <version>2022.0.8-SNAPSHOT</version>
</dependency>
```

#### 读取命令行参数

读取启动命令行参数, 使用```com.github.charlemaznable.core.config.Arguments```获取命令行参数.

```java
Arguments arguments = new Arguments();
// ...
```

#### 自定义方式配置```application.properties```

可使用ServiceLoader方式, 自定义```com.github.charlemaznable.gentle.spring.boot.GentleBootConfig```实现, 自行配置SpringBoot应用配置.

默认可在命令行参数中添加```--BootGroup=xxx```和```--BootId=yyy```参数, 指定配置服务坐标, 以使用Apollo/Diamond配置SpringBoot应用.

读取Apollo配置坐标: ```namespace:xxx propertyName:yyy```, 读取Diamond配置坐标: ```group:xxx dataId:yyy```.

依据添加的apollo-client/diamond-client依赖决定使用Apollo/Diamond配置.

如果同时依赖apollo-client&diamond-client, 则根据
* 类路径中添加的```configservice.env.props```文件中的配置```ConfigService=apollo|diamond```
* 命令行参数中添加的```--ConfigService=apollo|diamond```

(按优先级顺序从低到高)决定使用Apollo/Diamond配置.
