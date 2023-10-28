## PEAR STORE - BE
### Prerequisites
- Clone and run [Message Broker](https://github.com/thomasdang1996/message-broker.git) before you run this application
- Install [Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac)
### How to run Application
With IDE
1) Clone project: `git clone https://github.com/thomasdang1996/pear-store-be.git`
2) Run `mvn compile -U` to download and generate `CreateAccountPayload` message schema for messaging via message bus
3) Run pear-store-be.
4) Address: http://localhost:8080

Without IDE using command line
1) `git clone https://github.com/thomasdang1996/pear-store-be.git`
2) `mvn spring-boot:run -U`
### Swagger
Link: http://localhost:8080/swagger-ui/index.html

### Other Apps 
Run [AccountManager BE](https://github.com/thomasdang1996/account-manager-be.git) for receiving `CreateAccountPayload` from PearStore BE


