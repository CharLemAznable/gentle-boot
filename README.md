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
  <version>0.0.8</version>
</dependency>
```

##### Maven Dependency SNAPSHOT

```xml
<dependency>
  <groupId>com.github.charlemaznable</groupId>
  <artifactId>gentle-boot</artifactId>
  <version>0.0.9-SNAPSHOT</version>
</dependency>
```

#### ?????????????????????

???????????????????????????, ??????```com.github.charlemaznable.core.config.Arguments```?????????????????????.

```java
Arguments arguments = new Arguments();
// ...
```

#### ?????????????????????```application.properties```

?????????ServiceLoader??????, ?????????```com.github.charlemaznable.gentle.spring.boot.GentleBootConfig```??????, ????????????SpringBoot????????????.

????????????????????????????????????```--BootGroup=xxx```???```--BootId=yyy```??????, ????????????????????????, ?????????Apollo/Diamond??????SpringBoot??????.

????????????Diamond????????????: ```group:xxx dataId:yyy```.

???????????????```configservice.env.props```??????, ?????????????????????```ConfigService=apollo```, ?????????Apollo????????????: ```namespace:xxx propertyName:yyy```.
