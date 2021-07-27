# Pattern

Exercise and demo for design pattern training.

## alarm

It's a project for alerting. 
The system needs to send out different kinds of messages through different kinds of devices, such as email, phone, fax.
When message sends out failed, the system needs to retry for at least three times.

The original source code was messy, how to refactor it to pattern? 

__Step 1: Extract timeFormat as a global property - git checkout alarm.1__

*When extracting methods, variables which are used by many method should be escalate as a global property.*

__Step 2: Extract timeFormat as a global property__


After refactoring, the following patterns will be used to improve the quality:
* Command Pattern
* Bridge Pattern

## ferry

__Step 1: Use chain of responsibility to separate DefaultExportProcessor's reponsibility__

1. In DefaultExportProcessor, the instance of DataEncryptor has a close relationship with method encrypt(); the instance of PartitionWorker has a close relationship with method partition(). These property won't be used in other method, so they should be extracted as a independent class.
2. DefaultExportProcessor has too many responsibility, which violates SRP.
3. Making the whole process like a pipeline, that will make it easier to add extra steps to the whole process.
