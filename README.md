# Scheduling Thesis Defenses Using OptaPlanner

## How to use?

* For Linux users, execute the file start_app.sh
* For Windows users, execure the file start_app.bat

## Where are certain parts of the application?

* Domain model to contain plan data is found in directory:
    * src/main/java/thesistimetableplanning/domain
* Configuration constraints are found in file:
    * src/main/java/thesistimetableplanning/domain/TimetableConstraintConfiguration.java
* Servlet files are found in directory:
    * src/main/java/thesistimetableplanning/servlet
* Files that read or write JSON data are found in directory:
    * src/main/java/thesistimetableplanning/json
* Drools rules are written in the file:
    * src/main/resources/thesistimetableplanning/solver/DefenseTimetableScoreRules.drl
* Planner configuration files for different algorithms are found in files:
    * src/main/resources/thesistimetableplanning/solver/DefenseTimetableSolverFirstFitConfig.xml
    * src/main/resources/thesistimetableplanning/solver/DefenseTimetableSolverHillClimbingConfig.xml
    * src/main/resources/thesistimetableplanning/solver/DefenseTimetableSolverTabuSearchConfig.xml
* Planner test files are found in directory:
    * src/test/java/thesistimetableplanning
* JSON data that is transferred between web interface and Java backend is located in directory:
    * src/main/webapp/json
* Web interface files are found in directory:
    * src/main/webapp

