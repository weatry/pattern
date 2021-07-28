# Pattern

Exercise and demo for design pattern training.

## alarm

It's a project for alerting. 
The system needs to send out different kinds of messages through different kinds of devices, such as email, phone, fax.
When message sends out failed, the system needs to retry for at least three times.

The original source code was messy, how to refactor it to pattern? 

__Step 1: Extract timeFormat as a global property - git checkout alarm.1__

*When extracting methods, variables used by many method should be escalate as a global property.*

__Step 2: Exact three send method, each method represents a kind of send measure - git checkout alarm.2__

*A long method may have logical clump. Developers can't know where to assign responsibilities util SRP methods are extracted based on their responsibility.*

__Step 3: Exact three build method, message building is separated from send method. - git checkout alarm.3__

*It's a refined refactor based on step 2.*

__Step 4: Exact a new class AlarmMessage. - git checkout alarm.4__

*A class is failed to be recognized when some properties/variable always appear together.*

__Step 5: Move buildXXXMessage to AlarmMessage. - git checkout alarm.5__

*If methods in a class don't use any properties of this class, that indicates this method has been put into a wrong class. It's called 'Data Envy' in refactor.*

__Step 6: Extract three sub-class of AlarmMessage, and move buildXXXMsg to corresponding sub-class. - git checkout alarm.6__

*If a method is only used by some of the client, it should be moved to sub-class.*

__Step 7: Move three sendXXXMsg to three sub-class respectively. - git checkout alarm.7__

*same as above, data envy.*

__Step 8: Extract a new class AlarmDevice. - git checkout alarm.8__

*AlarmMessage has two responsibility: send and build. It's a violation of SRP.*
*They should be defined in different class, and connected by Bridge pattern.*

__Step 9: Move class to different package. - git checkout alarm.9__

*Source code becomes more organized.*

__Step 10: Add a new class Alarm as a command. - git checkout alarm.10__

*retry,replay are typical scenario for command pattern.*

__Step 11: Add thread pool and retry ability. - git checkout alarm.11__

*Thread in Java is an example of command pattern.*

We didn't try to utilize patterns during refactoring, but patterns were utilized in the source code automatically. 
After refactoring, the following patterns will be used to improve the quality:
* Command Pattern
* Bridge Pattern
* Factory Pattern

## ferry

It's a system which is used to transport data from secure realm to unsecured realm and vice versa. 
During the transportation, the system needs to collect data first, validate and encrypt them next, and transport them to unsecured realm finally.  

__Step 1: Use chain of responsibility to separate DefaultExportProcessor's responsibility.__

1. In DefaultExportProcessor, the instance of DataEncryptor has a close relationship with method encrypt(); the instance of PartitionWorker has a close relationship with method partition(). These property won't be used in other method, so they should be extracted as a independent class.
2. DefaultExportProcessor has too many responsibility, which violates SRP.
3. Making the whole process like a pipeline, that will make it easier to add extra steps to the whole process.

__Step 2: Decoupling FerryRequest and FerryRequestService by Observer pattern.__

1. Observer pattern is a good way to decouple components.
2. Be aware of synchronized problem under multiple thread situation.

__Step 3: Solve FerryStatus sharing issue by Flyweight pattern.__

1. FerryStatus instance is created frequently, here and there.
2. Why don't use singleton for each instance?