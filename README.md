# csi-3370-software-project

![build](https://github.com/andrewdimmer/csi-3370-software-project/workflows/Gradle%20Build%20and%20Test/badge.svg)
[![codecov](https://codecov.io/gh/andrewdimmer/csi-3370-software-project/branch/main/graph/badge.svg?token=HUNFF75C0R)](https://codecov.io/gh/andrewdimmer/csi-3370-software-project)

A project created for CSI 3370 Software Engineering Fall 2020 at Oakland University.

## Demoing This Project

### Downloading the Project

For the most recent, stable, demo version of this project, it is recommended that you get the most recent copy of the project binaries on the "[Releases](https://github.com/andrewdimmer/csi-3370-software-project/releases)" section of this repository. From there, you can extract the files from the zipped folder, and execute the correct file from the bin depending on your operating system.

Note, you can also run it locally from the development environment, but that is prone to some issues with the Gradle runner eating your user input. If you want to run the project locally from the source code however, check out [Run Locally](#run-locally).

### Sample Run Commands

Below are some sample commands to run to demo the different parts of the project.

#### Setup

When you first set up the project, you'll be asked to configure the "System RFID Number" and the names of the GPS satellites. Below is a sample input you can use to do that:

```
1
3
GPS0
GPS1
GPS2
```

#### Verify that the System Does Not Respond to Other RFID Numbers

For part of Use Case 1, the system should only provide data about the System RFID Number set up in the [Setup](#setup) section. Below is a sample input you can use to demonstrate that:

```
1
2
```

#### Verify that the System Provides Track Data

For part of Use Case 1, the system should provide Track Data about the shipping container that it is attached to. Below is a sample input you can use to demonstrate that (run it multiple times to simulate multiple GPS pings):

```
1
1
```

#### Switch the System from Normal Mode to Degraded Mode

For part of Use Case 2, the system should switch from normal mode to degraded mode if it loses connection with enough GPS satellites such that it only has a lock on 1 satellite. Below is a sample input to set the system into degraded mode and verify that it now only returns historical data:

```
2
0
1
1
2
1
1
1
1
1
```

#### Switch the System from Degraded Mode to Standby Mode

For part of Use Case 2, the system should switch from degraded mode to standby mode if it loses connection with all GPS satellites. Below is a sample input to set the system into standby mode from degraded mode and verify that it now only returns historical data:

```
2
2
1
1
1
1
```

#### Switch the System from Standby Mode to Degraded Mode

For part of Use Case 2, the system should switch from standby mode to degraded mode if it regains connection with a GPS satellite. Below is a sample input to set the system into degraded mode from standby mode and verify that it now only returns historical data:

```
2
2
5
5
1
1
```

#### Switch the System from Degraded Mode to Normal Mode

For part of Use Case 2, the system should switch from degraded mode to normal mode if it regains connection with enough GPS satellites that it is connected to at least two satellites. Below is a sample input to set the system into normal mode from degraded mode and verify that it now returns new data again:

```
2
1
5
5
1
1
```

## Developing for This Project

### GitHub as Version Control

This project uses GitHub actions to enforce CI/CD and coding best practices like the Google Style Guide and requiring all test to pass and code reviews before merging to main.

For more information and trainings, check out the [version-control](docs/version-control/) docs.

### Running and Testing Locally

Once you have cloned the repo, (see the [version-control](docs/version-control/) docs for more info), you can use the Gradle wrapper to run Gradle commands directly from the root of this repository. This allows you to build and test the project locally.

#### Test Locally

To run the project tests locally, run the below command for your operating system from the root of this repository.

- Windows: `.\gradlew.bat test`
- Mac\Linux: `./gradlew test`

A full test report can also be seen in the `build/reports/test/test` directory.

#### Run Locally

To run the project locally from the development environment, run the below command for your operating system from the root of this repository.

- Windows: `.\gradlew.bat run`
- Mac\Linux: `./gradlew run`

#### Build Distributions Locally

To build distributions for this project locally from the development environment, run the below command for your operating system from the root of this repository.

- Windows: `.\gradlew.bat build`
- Mac\Linux: `./gradlew build`

The distributions themselves will be in the `build/distributions` directory.

### Test Driven Development and Code Coverage

This project is built using mostly Test Driven Development. To become acclimated with Test Driven Development, it is recommended that you watch ([@andrewdimmer](https://github.com/andrewdimmer/))'s [Test Driven Development Crash Course](https://youtu.be/eSc0aY4GhPs).

Note: there were some parts of this project (ex. The `TrackDataPlotter`) where Test Driven Development was difficult based on the requirements. Therefore, this project was integrated with Codecov, a code coverage validation tool to help ensure proper test coverage of all code committed to this repository.

Also note: the `Main` class has been excluded from Code Coverage reports, because the main method with the termination signal and `System.in` call could not be tested via the JUnit platform via Gradle.

#### Viewing Code Coverage via Codecov

To view the full project reports, check out [andrewdimmer/csi-3370-software-project on Codecov](https://codecov.io/gh/andrewdimmer/csi-3370-software-project).

#### Viewing Code Coverage Reports Locally

To run the code coverage reports locally from the development environment, run the below command for your operating system from the root of this repository.

- Windows: `.\gradlew.bat jacocoTestReport`
- Mac\Linux: `./gradlew jacocoTestReport`

A full code coverage report can be seen in the `build/reports/jacoco/test` directory.

## Credits

This project was the work of a massive number of students with different roles on different teams.

For a complete list of everyone involved, check out [Teams.md](Teams.md).
