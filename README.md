# d4-android
Android app for the D4 Community that helps in keeping engagement with members and keeps them updated for the latest community updates/events.

## Installation

1. Fork the repo
2. Import the fork into your Android studio.
3. Build the project.
4. Wait for the gradle build...
5. Keep waiting...
6. Launch the project

## Tools/Libraries used:

1. [Appwrite](https://cloud.appwrite.io/) for backend requirements.
2. [Jetpack compose](https://developer.android.com/jetpack/compose) for UI.
3. [Material 3](https://m3.material.io/) for design system.
4. [Single activity pattern](https://youtu.be/2k8x8V77CrU?si=j_bh1ZDtkdsz8Vi-)
5. [Multi-Module](https://developer.android.com/topic/modularization)
6. [MVVM](https://developer.android.com/topic/architecture) architecture
7. [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for DI.
8. [ProtoDatastore](https://developer.android.com/codelabs/android-proto-datastore#0)

## Modularization Guide

![1_sample_dep_graph](https://github.com/D4Community/d4-android/assets/85388413/e0097aba-113e-4972-9622-f7fd6af339f4)

1. The app module should only interact with feature modules
2. The feature modules should ONLY interact with required data modules, use HILT for injections.
3. The data modules can use any core module for their requirements.
4. The feature modules can use any core module instead of the Datastore module which should be integrated with the data layer only.


## Contributing
Please go through the [Contribution guidelines](/CONTRIBUTING.md) file before starting to add anything to the project.


## Roadmap
[Link](https://docs.google.com/spreadsheets/d/1uD93oYKea3MFwNi3qm5N93Nz9slwvXI-Hta9WFbYSwk/edit?usp=sharing)

## Contributors
Thanks to all these amazing contributors for providing value to this project.

<img src="https://contrib.rocks/image?repo=D4Community/d4-android"/>

Show your support by giving a Star🌟
