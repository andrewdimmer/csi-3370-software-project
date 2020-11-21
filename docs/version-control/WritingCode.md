# Version Control Documentation - Writing Code and Pull Requests (PRs)

[<-- Return to Version Control Documentation Hub](README.md)

Below, we'll go over the steps that you need to do to write and save code to GitHub!

## How do I get the code to my computer?

1. To download the code to your computer, you must first install a git client. In most cases, if you are new to GitHub and Git, it's easiest to start with [GitHub Desktop](https://desktop.github.com/). You can also use the git CLI (Mac and Linux), git bash (windows), or [GitKraken](https://www.gitkraken.com/) (for more advanced GUI features).

2. "Clone" this repository from your preferred git client to whatever directory you are going to work out of.

Want a video tutorial? Check out [GitHub Crash Course: Cloning a GitHub Repository](https://youtu.be/VPSPYHuahvY)!

## How do I write new code?

Prerequsites: Make sure you are on the `main` branch of the repository, then right before starting this process be sure you "Pull" the `main` branch to get any new updates!

1. Create a new branch from your preferred git client. This basically creating a new copy of the code that is yours to use. This means that if anyone else changes code, it won't break what your making while you're still writing your code. (Note: it may still break your code later, but we'll fix this later on).

2. Open the code repository in your preferred development environment (i.e. JEdit for this class).

3. Make your code changes, and save any file's you've changed when you're done.

4. "Pull" the branch of the code repository via your preferred git client. This checks if there are any files that have been updated on the branch since you last got the source code. If you know that you are the only person who is working on the branch, you can technically skip this step, but it's still recommended just in case. If both you and your partner for the programming pairs are both writing code back and forth, this is required (or you'll get error later on; we can fix it, but it's more difficult).

5. "Stage" the files that you want to upload to GitHub in your preferred git client. This basically tells Git that you're going to save these files soon (think of it like opening the Save As menu on something like a Word document for a whole bunch of files at once). Note that you can change files but NOT save them to GitHub if you're just making something like a temporary change to a variable in another class to test your own.

6. "Commit" your changes to the "Git Tree" (i.e. the version history of something like a Google Doc) via your preferred git client. In our example of the Word documents above, this is when you actually click the save button. Be sure to give it a descriptive commit title, and a description if required! Note that only you and your teammates will see these commits, so there is no "required" naming convention, but I would recommend [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0-beta.4/) if you're team wants to use a naming convention. This makes tracking what was changed when for code reviews (to be explained later) and when looking back at the repository history much easier!

7. "Push" your new commit(s) to GitHub via your preferred git client. This is the equivalent of uploading your newly changed code (or Word document in our running example) to the server. Before you "Push" the changes are saved, but ONLY exist on your local machine. It's best practice to "Push" after EVERY commit, although if you forget you can just multiple at once later without an error.

8. [RECOMMENDED]: [Create a "Pull Request (PR)" via GitHub.com](#how-do-i-create-a-pull-request-pr). Note that while this is technically not required YET, by creating a "Pull Request" now, it automatically adds that your task is "In Progress" on the STSB. This allows you automatically keep your Team SCRUM manager up to date with your progress, as well as your teammates and other teams that may depend on your code.

9. Repeat steps 3-7 until you're done working on your current feature or bug fix. This should be repeated until your code is the point that you're ready to "Ship" your feature, so you shouldn't stop until the code is building and passing all unit test.

Once your code is ready to "Ship", the next step is to [Create a "Pull Request (PR)" via GitHub.com](#how-do-i-create-a-pull-request-pr) if you have not already done so, or [Request "Code Reviews (CRs) via GitHub.com"](#how-do-i-request-code-reviews-crs).

Want a video tutorial? Check out [GitHub Crash Course: Writing Code to GitHub](https://youtu.be/M_O4TRYA8FU)!

### How often should I "Commit"?

Just like you want to save any changes to a document frequently, you want to "Commit" frequently as well. The unofficial phrase you'll find online is "Commit Early, Commit Often" (great advice for Git, but unadvisable for dating :) ).

Why should you "Commit Early, Commit Often"? There are a number of reasons but the top 3 are:

1. Make small, bit-sized backups in case something breaks or you decide to redesign something: Git only saves your work when you commit, so if you write 300 lines of the code, then find a bug and need to go back to what you had, you are out all 300 lines of code. If you make 10 smaller commits, then you can just roll back to the last point you had good code without losing all of your progress.

2. Increased clarity for code reviews and repository history: Just saying "I edited a class and fixed a bug" doesn't mean anything to anyone but you. If you go through and say "Updated variable x datatype", "Added new helper method y", "Refactored and updated documentation for z", everyone reading that can understand your thought process, what changes you made, and why you made them.

3. Increase transparency for your work progress: by committing and pushing your code frequently, it lets you start it, take a break, come back to it later, and then take another break without the rest of your team wonder what is happening. It also means that your teammates which may depend on your code can see drafts while you're still writing it.

Because we're using Test Driven Development (TDD), I would recommend AT LEAST 2-4 commits for each time you make a new test:

1. The test itself

2. The bare minimum code to pass that test

3. A refactor to reduce code duplication

4. Any documentation updates

Want a video explanation? Check out [GitHub Crash Course: Is There Such Thing as Too Many Commits?](https://youtu.be/fN5Yq_pVl5w)!

### Can I "Commit" too often?

No! One of the reasons that we're requiring pull requests in this repository is that we use a tool called "Squash and Merge", which means that no matter how many commits you make internally, there is only one that moves into the `main` branch.

This effectively means that with each commit you are making the CHANGELOG of what you've worked on. For example, if you have three commits "Added a unit test for task x", "Wrote method y to pass test x", "Refactored method z into y", the final commit on the `main` branch will read:

- Added a unit test for task x
- Wrote method y to pass test x
- Refactored method z into y

This means that anyone who sees your new code on the `main` branch can see exactly what you did without even looking at their code, so they can know if it impacts them! This is even more helpful when you are working on multiple methods and classes to complete a single change.

Want a video explanation? Check out [GitHub Crash Course: Is There Such Thing as Too Many Commits?](https://youtu.be/fN5Yq_pVl5w)!

## How do I ship what I'm working on so my teammates and other teams can use it?

When we talked about creating a branch, we mentioned that by working on a separate branch other people's changes can't break your code. But by that same token, they can't access your changes in their code either. So how do you make your code accessible to everyone else? The end goal is to "Merge" in into the `main` branch of the repository, which is all the code that is done and in production. To do that, we have a 3.5 step process:

1. Create a "Pull Request (PR)"

2. Request "Code Reviews (CRs)" (and step 2.5 verify that all "Checks" pass)

3. "Merge" your code into the `main` branch

In this section, we'll focus on creating a "Pull Request (PR)", and will come back to the rest a little later.

### What is a "Pull Request (PR)"?

A "Pull Request (PR)" is essentially a process to formally declare that you want to release your code to the `main` branch (or another branch).

It serves as a central place to track all of the individual commits that make up a single change in one place, a place to have conversations about how things are implemented and what is in progress, and a "complete version" of code to have others review and run though testing.

Last but not least, it a way to document what is in progress and what the status is for a particular task. Everything on the PR automatically syncs to the STSB, so if you do your pull request well, this does all the tracking tasks that you need to do for you!

### How do I create a "Pull Request (PR)"?

1. Open the repository at GitHub.com.

2. Click on the "Pull requests" tab in the **menu bar directly below the repository name (black text on a grey background)**! DO NOT click the "Pull requests" tab in the top menu bar (grey text on a black background); this is for all of the pull requests that you have open in all repos, we just need the PRs for this repo.

3. Click the green "New pull request" in the top-right corner of the screen.

4. Check that the "base" is set to `main` (unless you are merging into another branch, but this is really rare).

5. Select the name of your branch in the "compare" dropdown menu.

6. Click the green "Create pull request" button.

7. Give your PR a name. This should start with [Your_Team] (ex. [Middleware_01]), then have a descriptive name for what you are changing (this is just like a commit title from when you were writing code).

8. In the first line of the description (where it says "Leave a comment"), explain what you were working on. If you are working in a sprint task, this should be in the form "Working on #X - Y" where X is the issue number of the sprint task, and Y is the specific subtask(s) this pull request works on or completes. If you're working on a bug fix, the first line of the description should simply read "Fixed #X" where X is the issue with the bug (this will automatically link the bug to the PR for you!). If you are fixing multiple bugs or features at once, add them on additional lines with the same format as above. This syncs up what you are working on with the issue that lives in the "To Do" swimlane of the STSB.

9. Add any extra description about what you changed or did. Note that in most cases if you "Commit Early, Commit Often", you probably won't need to add anything else here because your commits (which you can see below the description box) will already include all the information that you need.

10. Click the gear icon next to "Assignees" in the right column, and select everyone who is assigned to write the code for this PR. This will at least include you, and may also include your programming partner if both of you are pushing code. Note that only one of you needs to create the PR, even if both of you are pushing code.

11. Click the gear icon next to "Labels" in the right column, and select the appropriate labels for the PR. For our project, this will be the name of your team (ex. "Middleware_01"), and at least one "type" label (bug, enhancement, or documentation). Note that if you are making a bug fix, select "bug". If you are working on code for a sprint item, select "enhancement". If you are working on documentation, select "documentation". If your task does multiple of these, feel free to select all of them that apply!

12. Click the gear icon next to "Projects" in the right column, and select the "Sprint Task Status Board (STSB)".

13. Click the gear icon next to "Milestone" in the right column, and select the correct sprint that it is due in. (In the very rare chance that it isn't due, select the "Miscellaneous" milestone, but that should really only be if we don't need to show it in the project demo, and if that's the case, why do it at all?)

14. Click the dropdown arrow to the right of "Create pull request".

15. Select "Draft pull request" from the dropdown menu.

16. Click the green "Draft pull request" button.

You've now published your PR! You can either keep coding if you're still working on your task(s) that you need to do before you can merge, or [Request "Code Reviews (CRs)"](#how-do-i-request-code-reviews-crs).

Note, if you want to come back to your pull request and edit it later, or even just check back on its status, you can do so by completing steps 1 and 2 above, then selecting your pull request from the list. You can [use filters](Issues.md#im-trying-to-find-an-issue-or-pr-how-can-i-filter-and-search-for-it) to help find your PR in the list.

Want a video tutorial? Check out [GitHub Crash Course: Creating Pull Requests](https://youtu.be/3Q1MZjAVIiE)!

## How do I check my code is ready to "Merge"?

As mentioned earlier, you need to get "Code Reviews (CRs)" and pass all the "Checks" in order to merge your code to the `main` branch.

### What are "Checks"?

"Checks" are automated workflows that GitHub runs to validate that your PR is in good shape to merge. The main one will be a build test via Gradle: if the code builds and passes unit tests, the check approves the PR; otherwise, it blocks it from being merged.

### What do I do if a "Check" failed?

From your PR:

1. Click on the "Checks" tab below the PR title

2. View the checks that failed, and each task should be a description of what the check verifies

3. Fix the issue (either in the Code and push it to the PR, or within the PR itself)

Want a video tutorial? Check out [GitHub Crash Course: Checks and Bots](https://youtu.be/rLciVQY9ejI)!

### What are "Code Reviews (CRs)"?

They are exactly what the name says: someone goes through and reviews the code that you've written in a PR, and either Approves, Comments on, or Requests changes.

During the code review, reviewer look to make sure that everything looks correct syntactically, that the code follows the style guide, and there aren't any bugs in it that they can see.

### Who do I need to review my code?

You need at least to CR approvals before you can "Merge" your code. These are intended to be your programming partner and either your Team SCRUM Master or Team Assistant SCRUM Master.

Note: by default, GitHub should automatically add both your Team SCRUM Master and Team Assistant SCRUM Master as reviewers when you publish your PR. You'll only need one of their approvals to merge, but if one of them requests changes, then you must gain their approval to merge.

### What happens if one of my reviewers requests changes?

That's totally fine, and happens all the time in industry. If they request changes, it just means you need to make some changes then they will review it again.

If you do have changes requested, the reviewer should have left you either global comments or comments on specific parts of your code that you need to take another look at. Once you fix those changes, and push the code up, just let your reviewers know and they'll give it another look.

Want extra tips to make resolving requested changes even easier? Take a look at the ["Help! Changes were requested on my PR! What do I do?"](CodeReviews.md#help-changes-were-requested-on-my-pr-what-do-i-do) section of the Code Reviews documentation.

### How do I request "Code Reviews (CRs)"?

From your PR:

1. Click the gear icon next to "Reviewers" in the right column, and select the appropriate reviewers for the PR. In most cases, this will be your programming partner, and either your Team SCRUM Master or Team Assistant SCRUM Master.

2. At the bottom of your PR, click the grey "Ready for review" next to the line that says "This pull request is still a work in progress".

It's that easy! Now you just need to wait for your reviews to review your code, and you can either "Merge" it if they approve, or go back and make changes if they didn't.

Want a video tutorial? Check out [GitHub Crash Course: Requesting Code Reviews](https://youtu.be/FjrDgBOS_20)!

## How do I "Merge" my code?

Finally, it's time to "Merge" your code into the `main` branch so that everyone else can use it, and it can be deployed to production.

Once all of your CRs are in the approval state, and all your checks pass, from your PR:

1. At the bottom of your PR, click the green "Squash and Merge" button.

2. Review the merge commit (it should be good if your PR was filled out correctly).

3. Click the green "Confirm squash and merge".

Want a video tutorial? Check out [GitHub Crash Course: Merging Pull Requests](https://youtu.be/6Kbly2r-g60)!

There you go! You're codes now in production! If you were working off of a subtask for an issue, you can now [check that off](Issues.md#im-working-on-a-sprint-task-how-do-i-track-it)! If you were fixing a bug, the issue should have automatically closed when the PR was merged because we linked the issue to the PR!

Finally, be sure to switch back to the `main` branch again before starting this process again!

## What's next?

| Previous                                           |                                     Next |
| :------------------------------------------------- | ---------------------------------------: |
| [<-- Version Control Documentation Hub](README.md) | [Code Reviews (CRs) -->](CodeReviews.md) |
