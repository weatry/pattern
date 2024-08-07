# Pattern with Refactor

Examples and exercises for design pattern and refactor. 
If you want me to help you refactor your code, please fork this repository, add your source code as a submodule and create pull request. 
It's better to add a README file to help me understand your code.

## Prerequisite
Please install the following software if you want to run or practice this project.
### JDK
The project is based on Java, so JDK is mandatory.
- Download and install either [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java8) or 
[OpenJDK](https://www.openlogic.com/openjdk-downloads), JDK 1.8 is preferred.
- Set up 'JAVA_HOME' environment variable to the JDK path

### Git
We commited each refactor step and tagged them by git. So it will be easier to see the steps if git is installed.
Download git from [here](https://git-scm.com/download/) and add its binary to PATH. I assume you are familiar with Git.

### IDE(Optional)
An IDE is a good plus to help you understand the source code. Choose one of your favorite IDE and install it:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=windows), community version is enough
- [Eclipse](https://www.eclipse.org/downloads/)

### Maven(Optional)
The project is managed by Maven, so it's good to install Maven also, but it's not mandatory.
- [Download Apache Maven](https://maven.apache.org/download.cgi), choose the latest binary package, unzip it to a specific directory.
- Add Maven '/bin' to the environment variable 'PATH'.
- Configure it following the [instruction](https://maven.apache.org/configure.html) (Normally, it's not required).

To summary, [JDK](https://www.oracle.com/java/technologies/downloads/#java8) and [GIT](https://git-scm.com/download/) is required if you want to run/practice the examples/exercises by yourself.
An IDE that supports Java is a good plus, such as [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/?section=windows).

## Refactor Examples
The main src folder contains basic 23 patterns according to GOF. Other submodules are refactor examples and exercises.

### alarm

It's a project for alerting. 
The system needs to send out different kinds of messages through different kinds of devices, such as email, phone, fax.
When message sends out failed, the system needs to retry for at least three times.

The original source code was messy, how to refactor it to pattern? 

__Step 1: Extract timeFormat as a global property - git checkout alarm.1__

*When extracting methods, variables used by many method should be escalated as a global property.*

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
* Template Pattern

### ferry

It's a system which is used to transport data from secure realm to unsecured realm and vice versa. 
During the transportation, the system needs to collect data first, validate and encrypt them next, and transport them to unsecured realm finally.  

__Step 1: Use chain of responsibility to separate DefaultExportProcessor's responsibility. - git checkout ferry.1__

1. In DefaultExportProcessor, the instance of DataEncryptor has a close relationship with method encrypt(); the instance of PartitionWorker has a close relationship with method partition(). These property won't be used in other method, so they should be extracted as a independent class.
2. DefaultExportProcessor has too many responsibility, which violates SRP.
3. Making the whole process like a pipeline, that will make it easier to add extra steps to the whole process.

__Step 2: Decoupling FerryRequest and FerryRequestService by Observer pattern. - git checkout ferry.2__

1. Observer pattern is a good way to decouple components.
2. Be aware of synchronized problem under multiple thread situation.

__Step 3: Solve FerryStatus sharing issue by Flyweight pattern. - git checkout ferry.3__

1. FerryStatus instance is created frequently, here and there.
2. Why don't use singleton for each instance?

__Step 4: Decorator pattern is used to add additional functionality. - git checkout ferry.4__

1. Add trivial function to a component.
2. Why don't use chain pattern?

__Step 5: Protect burning files by clone them before return to users. - git checkout ferry.5__

__Step 6: Null Object is used to remove null check in DataEncryptor. - git checkout ferry.6__

Patterns used in this project:

1. Chain of Responsibility
2. Observer
3. Flyweight
4. Decorator
5. Prototype
6. Factory
7. Null Object

### octree

Scenario tree is used to render 3D scenes. It usually has 8 sub-tree, and it is a complex data structure to operate.
How to change the node in the tree?

__Step 1: Add iterator based on pre-order traversal - git checkout octree.1.__

*Even when you get all the nodes, node must exposes method to allow the users to operate.*
*That means if you want a new operation on nodes, nodes must add a new method exposed to you.*

__Step 2: Protect burning files by clone them before return to users. - git checkout octree.2__

Patterns used in this projects:

1. Iterator
2. Visitor

They are common patterns that are commonly used in complex data structure process.

### rental

This module is from Martin Flowler's book 'Refactoring: Improving the Design of Existing Code'. It's a very good example to illustrate the power of refactoring. 
It shows how to import patterns to your project during refactoring.
It also shows the difference between inheritance and strategy pattern. 

I added some improvement, so it's not exactly as same as in the book.

__Step 1: Add unit test - git checkout rental.1.__

*Unit test can make you more confident to refactor. In most of the cases that you are unwilling to refactor, you are afraid of breaking the system after your refactor.*

__Step 2: Rename local variable 'each' to 'rental' - git checkout rental.2.__

*A meaningful variable name can be helpful to refactor*

__Step 3: Extract amountFor method from statement - git checkout rental.3.__

*All too often a statement block should be extract as a independent method*

__Step 4: Move amountFor to Rental and rename it to getCharge - git checkout rental.4.__

*Feature Envy or information expert.*

__Step 5: Extract and move getFrequentRenterPoints - git checkout rental.5.__

*Same as what has been done with rental.getCharge.*

__Step 6: Remove local variable 'thisAmount' by inlining it - git checkout rental.5.__

1. Local variable may be harmful to extracting method
2. Inlining variable may impact performance. Refactor it first, and see whether it has impact finally. 
All too often you can find better way to reduce this kind of impact. And it will benefit the whole program.

__Step 7: Extract getTotalCharges & getTotalFrequentRenterPoints - git checkout rental.7.__

1. A loop should only have one responsibility.
2. It may impact performance too, refactor it first and see.

__Step 8: Inline local variable 'totalAmount' and 'totalFrequentRenterPoints' - git checkout rental.8.__

__Step 9: Move getCharge and getFrequentRenterPoints to Movie - git checkout rental.9.__

1. A method uses too many properties of other class, but it ought to be a member of current class logically.
2. Middleman can be used here to be a mediator, just like Rental keeps the method but has no content.

__Step 10: Remove switch statement by strategy pattern. - git checkout rental.10.__

__Step 11: Remove priceCode£¬move constant to Price  - git checkout rental.11.__

__Step 12: Change constant to sub class of Price - git checkout rental.12.__

### stock

This project is used to illustrate visitor pattern as well as PAC, HMVC.

__Step 1: Move handleEvent to AppEvent - git checkout stock.1.__

*handleEvent in XXXController is still kept, but it just invokes AppEvent.handleEvent*

__Step 2: Pull up handleEvent in XXXController to super class Controller - git checkout stock.2.__

*handleEvents in XXXController are all same after moving logical to AppEvent.*

__Step 3: Merge handleEvent in AppEvent - git checkout stock.3.__

__Step 4: Remove branch in AppEvent by different sub-class - implement yourself__

### weather

It's a shipping system. It has a service to determine whether it is suitable for sailing based on the weather condition.
It's a very simple example to illustrate refactor and feature envy, information expert in GRASP.

### sequence

It's an exercise for refactoring. This project provides a service to generate sequence id.

### monitor

It's an exercise for refactoring.

