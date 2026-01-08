# quarkus-elasticsearch Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-elasticsearch-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Elasticsearch REST client ([guide](https://quarkus.io/guides/elasticsearch)): Connect to an Elasticsearch cluster using the REST low level client

Tranche #1: Following Services to be modified to use Envoy Gateway instead of DataPower
1 AccountInquiryRequest Envoy Gateway Migration
2 AnalyseTransactionLimitRequest Envoy Gateway Migration
3 CustomerProfileRequest Envoy Gateway Migration
4 OfferDecisionRequest Envoy Gateway Migration
5 ProductServiceDispositionRequest Envoy Gateway Migration

Tranche #2: Following Services to be modified to use Envoy Gateway instead of DataPower and modernized to use
ATM 2.0 Framework
1 MortgageAccountInquiry Envoy Gateway Migration and ATM 2.0 Modernization
2 CreditCardInquiryRequest3.0 Envoy Gateway Migration and ATM 2.0 Modernization
3 RelatedCustomerSearchRequest2.0 Envoy Gateway Migration and ATM 2.0 Modernization
4 RetrieveChannelDetails Envoy Gateway Migration and ATM 2.0 Modernization
5 TransactionHistorySearchRequest3.0 Envoy Gateway Migration and ATM 2.0 Modernization
6 CustomerDocumentLoadRequest1.0 Envoy Gateway Migration and ATM 2.0 Modernization

Tranche #3: Development of Single Page UI Application with below Functionalities/Services
1 Release Versioning - Service Header based routing functionality (version-based client software download)
2 Local Native System Services - Libraries for file system access, executing Windows commands, and OS interactions Microservice
3 Component Configuration Management Services - Configuring the ATM with information from remote service
4 Command Handling Services - Capability to handle supported commands
5 Offline Message Handling - Store-and-forward mechanism when network connectivity fails
6 Hardware & Software Status Reporting - Collect status of hardware components and software components
7 Component Status Aggregation - Aggregate hardware and software status
8 Build UI Page - Build the integrated UI Page for above services


FE+BE 
-------------------------------------------------------------------------------------------------------------------------------
Actual
M1 - Nov 30, 2025 - Design Completion for Services inTranche #1, Trance #2 and Tranche #3
                    Development Completion: 1 of 19 Services
                        Tranche #1: Completed Development for 1 of 5 Services
M2 - Dec 30, 2025 - Development Completion: 5 Services (Cumulative 6 of 19)
                        Tranche #1: Completed Development  for 3 of 5 Services
                        Tranche #2: Completed Development  for 2 of 6 Services
                        Tranche #3: Completed Development  for 1 of 8 UI Services/features
M3 - Jan 30, 2026 - Development Completion: 6 Services (Cumulative 12 of 19)
                    Tranche #1: Completed Development for 5 of 5 Services
                    Tranche #2: Completed Development for 4 of 6 Services
                    Tranche #3: Completed Development for 3 of 8 UI Services/features
                    UAT Support: 5 Services (Cumulative 5 of 19)
                    Tranche #1: Completed UAT
                    Support for 5 of 5 Services
Amended
M3 - Jan 30, 2026 - UAT Support: 3 Services (Cumulative 3 of 19)
                    Tranche #1: Completed UAT
                        Production Readiness: 3 Services (Cumulative 3 of 19)
                    Tranche #1: Complete Production
                    Deployment for 3 of 5 Services

M4 - Feb 20, 2026 - Development Completion: 7 Services (Cumulative 10 of 19)
                    Tranche #1: Completed Development for 5 of 5 Services
                    Tranche #2: Completed Development for 4 of 6 Services
                    Tranche #3: Completed Development for 1 of 8 UI Services/features

                    UAT Support: 5 Services (Cumulative 5 of 19)
                    Tranche #1: Completed UAT Support for 5 of 5 services

M5 - Mar 20, 2026 - Development Completion: 5 Services (Cumulative 15 of 19)
                    Tranche #2: Completed Development for 6 of 6 Services
                    Tranche #3: Completed Development for 4 of 8 UI Services/features

                    UAT Support: 6 Services (Cumulative 11 of 19)
                    Tranche #2: Completed UAT
                    Support for 6 of 6 Services
                    Production Deployment: 5 Services (Cumulative 5 of 15)

M6 - April 20, 2026 -   Development Completion: 4 Services (Cumulative 19 of   19)
                        Tranche #3: Completed Development for 8 of 8 UI Services/features

                        UAT Support: 8 Services (Cumulative 19 of 19)
                        Tranche #3: Completed UAT
                        Support for 8 of 8 Services

                        Production Deployment: 14 Services (Cumulative 19 of 19)
                        Tranche #2: Complete Production
                        Deployment for 6 of 6 Services
                        Tranche #3: Complete Production
                        Deployment for 8 of 8 Services 

M7 - May 28, 2026 - Post Deployment Support & Defect Fix as needed Documentation and Hand Over Warranty Support

