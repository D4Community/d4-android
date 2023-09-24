
<h1>Contributing!</h1>

Thank you for your interest in contributing to **D4-android** To ensure a positive and inclusive community and make this project a huge success, we follow these guidelines and adhere to a code of conduct.

<h3>Coding Guidelines</h3>

While starting to work on a new functionality or improving an existing one, make sure to follow these rules...
1. Check the D4-android roadmap if you want to start working on a new functionality.
2. We are using AppWrite as our one and only BaaS, so before starting to work on a new functionality make sure you discuss with maintainers regarding the data present in AppWrite.
3. You should follow the [recommended](https://developer.android.com/topic/modularization) Android App modularization guidelines with MVVM architecture.
![1_sample_dep_graph](https://github.com/D4Community/d4-android/assets/85388413/41079fed-cc97-43a8-82b5-754d131f7d53)
4. The UI feature module should not directly interact with other feature modules. Instead, they should expose a navigateToX() method and all interactions should happen in the app module.
5. No ViewModel instance should be passed in compose screens. Pass states and Events only(For easier testing purposes).
6. No context reference should be passed in ViewModel(For easier testing purposes).
7. App Resources(drawable/strings/etc) should be present in core:common module.
8. Shoulde use only Hilt for DI.

<h3>Commit Guidelines</h3>

While creating a commit make sure to follow these guidelines...
1. Write a logical name related to the functionality it contains.
2. One commit should only contain one feature/bug fix.
3. If fixing a bug use the format Fix #ISSUE_NUMBER : [human readable message(Optional)]

<h3>Pull request guidelines</h3>
1. Make sure to use PR template available.
2. Must follow other guidelines before making a PR.
3. Make sure the app builds successfully.

<h3>Issue Guidelines</h3>
1. Must use the Issue template.

<h3>Suggestions Guidelines</h3>

1. If you have a new Idea regarding features, Improvements, or any practices/tools integration for the D4-android app, then hop into the discussions forum or reach out at help.d4community@gmail.com

<h3>Code of Conduct</h3>

Our community is committed to providing a **welcoming** and **harassment-free** environment for **everyone**, regardless of background, identity, or beliefs. By participating in this project, you are expected to uphold this **code of conduct**.

If you encounter any unacceptable behavior, please report it to help.d4community@gmail.com.

<h3>Have Questions?</h3>

If you have questions or need assistance, start by filing an **issue**. Our committers work to reach a consensus on project direction and issue solutions within issue threads.

<h3>Code Reviews</h3>

We welcome submissions in the form of **pull requests**. All contributions should be reviewed by project committers. Refer to GitHub's pull request documentation for details on sending pull requests.

Please use the provided **pull request template** when submitting your pull request!

<h3>From Contributor to Committer</h3>

We value contributions from our community. If you aspire to become a **committer** with **full write access** and a say in the project's direction, you must be **invited** to the project. The existing committers employ an internal nomination process that requires **lazy consensus** (silence as approval) before issuing invitations. If you're interested in deeper involvement, reach out to existing committers for a discussion.

<h3>Security Issues</h3>

For **security-related matters**, please do not report them on this issue tracker. Instead, file an issue with our **security experts**.
