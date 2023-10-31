## PEAR STORE - BE

### Prerequisites

- Clone and run [Message Broker](https://github.com/thomasdang1996/message-broker.git) before you run this application
- Install [Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac)

### Adding `settings.xml`
This steps enables `pear-store-be` to download its custom library `common-lib` for messaging.
1) Go to `C:\Users\<user-name>\.m2` and create `settings.xml`.
2) Paste following text:
```
 <?xml version="1.0" encoding="UTF-8"?>
 
 <settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
 
   <servers>
     <server>
       <id>github</id>
       <username>USERNAME</username>
       <password>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</password>
     </server>
   </servers>
 
   <activeProfiles>
     <activeProfile>github</activeProfile>
   </activeProfiles>
 
   <profiles>
     <profile>
       <id>github</id>
       <repositories>
         <repository>
           <id>central</id>
           <url>https://repo1.maven.org/maven2</url>
         </repository>
         <repository>
           <id>github</id>
           <url>https://maven.pkg.github.com/thomasdang1996/common-lib</url>
           <snapshots>
             <enabled>true</enabled>
           </snapshots>
         </repository>
       </repositories>
     </profile>
   </profiles>
 </settings>
```
3) Replace USERNAME with your GitHub username.

### Running `pear-store-be`

1) Clone project: `git clone https://github.com/thomasdang1996/pear-store-be.git`
2) Run `mvn compile -U` to download and generate `CreateAccountPayload` message schema for messaging via message bus
3) Run pear-store-be.
4) Address: http://localhost:8080

Or
1) `git clone https://github.com/thomasdang1996/pear-store-be.git`
2) `mvn spring-boot:run -U`

### Swagger

Link: http://localhost:8080/swagger-ui/index.html

### Other Apps

Run [AccountManager BE](https://github.com/thomasdang1996/account-manager-be.git) for receiving `CreateAccountPayload`
from PearStore BE


