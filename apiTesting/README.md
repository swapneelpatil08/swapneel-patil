# apiTesting
This API automation project uses RestAssured and Java, to automate given problem.

# Pre-requisites
- Java _v8_
- IntelliJ IDEA _v2021.3.1_
- [Maven](https://maven.apache.org/download.cgi "Maven – Download Apache Maven") _v3.8.2_

# Installation
1. Clone repository by executing below command <br />
   `git clone https://github.com/swapneelpatil08/swapneel-patil.git`
2. Open `apiTesting` project from cloned repository in IntelliJ IDEA. <br />
3. From command window go to `apiTesting` directory.
4. Download dependencies by running below command <br /> `mvn install`

# Project Structure
### Tests
Tests files are available in directory `src/test/java/`.
Below Tests are covered in this framework:
1. shouldGetPetList
2. shouldBeAbleToAddNewPet

### Models
Entity models are available in `src/main/java/Models`.

### Utils
Common methods are present in `src/main/java/Utils`.

## Configuration
This framework uses Maven for build and run tests. You can see them `pom.xml`.

### Libraries
1. RestAssured
2. JUnit
3. Maven surefire plugin

## Reporting
Test reports will be generated in `Target` directory in same project directory using `maven-surefire-plugin` .

## Run tests
Go to IntelliJ and Open `PetTest` from `src/test/java`. 
![Run Tests](https://i.imgur.com/t97rHnK_d.webp?maxwidth=760)

### Issue:
Unable to run tests from command line. Basically, maven is unable to identify the tests. I will fix it if I get sometime.

> Note: I have submitted the code, as much as I could complete in given time.