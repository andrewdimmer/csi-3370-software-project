# Version Control Documentation - Issues: Bug Reports and Feature Requests

[<-- Return to Version Control Documentation Hub](README.md)

We briefly mentioned issues when talking about [Writing Code and Pull Requests (PRs)](WritingCode.md), but what are they, and how do we use them? Below, we'll go over all of this, as well as how we'll be using them!

## What are "Issues"?

At their simplest, they are simply a "post" (for lack of a better word) on a GitHub repository. In terms of what they are physically, they are a block of text that we can reply to in comments, add labels to, and mark them open or closed. Unlike PRs and CRs, Issues don't directly relate to any code that we've written (unless someone copies and pastes in a code snippet to a comment or the description).

Where issues become powerful though is in the fact we can use them as a centralizing "thread" for all the work that is going on regarding a certain topic. In large, open source repositories, they can host anything and everything to do with a project, from a feature roadmap, to a deprecation notice and sunset plan, to support tickets.

What they're most known for (and what we'll use them for), however, is being able to have end users report bugs and make feature requests, then automatically update interested users when a developer starts working on a resolution for the issue. Remember when we mentioned that PRs should have a description containing "Working on #X..." where X was the issue number of the sprint story? By doing so, it means that any time a developer creates a PR and links the issue like that, or pushes a commit with the issue number, GitHub tracks it to the issue thread so you can see all of those as a timeline at once.

We'll also be using Issues because they automatically integrate with GitHub Projects, which we can use to automate our Sprint Task Status Board (SPSB).

That said, there are four main use cases for how we'll be using issues (and one extra piece of helpful info):

1. ["Help! I found a bug or missing documentation! How can I report it to the team that needs to fix it?"](#help-i-found-a-bug-or-missing-documentation-how-can-i-report-it-to-the-team-that-needs-to-fix-it)

2. ["I'm fixing a bug or missing documentation. How do I track my progress?"](#im-fixing-a-bug-or-missing-documentation-how-do-i-track-my-progress)

3. ["I need to add a Product Backlog Item (PBI) to the SPSB. How do I do this?"](#i-need-to-add-a-product-backlog-item-pbi-to-the-spsb-how-do-i-do-this)

4. ["I'm working on a sprint task. How do I track it?"](#im-working-on-a-sprint-task-how-do-i-track-it)

5. ["I'm trying to find an Issue or PR. How can I filter and search for it?"](#im-trying-to-find-an-issue-or-pr-how-can-i-filter-and-search-for-it)

## "Help! I found a bug or missing documentation! How can I report it to the team that needs to fix it?"

1. Open the repository at GitHub.com.

2. Click on the "Issues" tab in the **menu bar directly below the repository name (black text on a grey background)**! DO NOT click the "Issues" tab in the top menu bar (grey text on a black background); this is for all of the issues that you have open in all repos, we just need the issues for this repo.

3. Click the green "New issue" in the top-right corner of the screen.

4. Find the template that best fits your need. It will most likely be "[TEAM_NAME] Bug Report" or "[TEAM_NAME] Documentation Request". Then click the green "Get started" button.

5. Give the issue a descriptive title after the "[TEAM_NAME]". For example, if you were asking for more documentation on issues, you could create an issue called "[Admin] Clarify documentation on GitHub issues".

6. Complete each section of the description to the best of your ability.

7. Click the gear icon next to "Projects" in the right column, and select the "Sprint Task Status Board (STSB)".

8. Click the gear icon next to "Milestone" in the right column, and select the correct sprint that it is due in. (In the very rare chance that it isn't due, select the "Miscellaneous" milestone, but that should really only be if we don't need to show it in the project demo, and if that's the case, why do it at all?)

9. Click the green "Submit new issue" button at the bottom of the description box.

You've now submitted an issue to that team! It's now up to them to assign it out and prioritize it with their other work. When in doubt, feel free to conversations about the issue in the issue comments.

Note: this is great to not only report issues for other teams, but also self-report issues. Found a bug in code that someone else wrote? Create an issue for it, then just add them as the assignee and let them know. The issue will do the rest of the tracking for you regarding progress.

Want a video tutorial? Check out [GitHub Crash Course: Issues (Feature Request and Bug Reports)](https://youtu.be/j1-xU6bmZZg)!

## "I'm fixing a bug or missing documentation. How do I track my progress?"

If you're just "claiming" the issue, then all you need to do is make sure that you are the assignee, and remove any old assignees on the issue. You can also add a comment on the issue saying that you're working on it, but depending on the urgency of the issue that may or may not be required.

Then, you can make all of the changes, following the instructions given on [Writing Code and Pull Requests (PRs)](WritingCode.md). Once again, feel free to add any comments to the issue if required as your working, but for most issues it should just be a simple matter of resolving it by fixing the bug or adding the documentation.

Finally, so long as you include "Fixed #X" where X is the issue number, once the PR is merged, the issue will automatically close.

Want a video tutorial? Check out [GitHub Crash Course: Issues (Feature Request and Bug Reports)](https://youtu.be/j1-xU6bmZZg)!

## "I need to add a Product Backlog Item (PBI) to the SPSB. How do I do this?"

1. Open the repository at GitHub.com.

2. Click on the "Issues" tab in the **menu bar directly below the repository name (black text on a grey background)**! DO NOT click the "Issues" tab in the top menu bar (grey text on a black background); this is for all of the issues that you have open in all repos, we just need the issues for this repo.

3. Click the green "New issue" in the top-right corner of the screen.

4. Find the template that best fits your need. It will most likely be "[TEAM_NAME] Project Backlog Item". Then click the green "Get started" button.

5. Give the issue a descriptive title after the "[TEAM_NAME]". For example, if you were asking for more documentation on issues, you could create an issue called "[Admin] Clarify documentation on GitHub issues".

6. Complete each section of the description to the best of your ability. Note that for the tasks, those will become checkboxes that you can actually check, uncheck, and reorder once the issue is created!

7. Click the gear icon next to "Projects" in the right column, and select the "Sprint Task Status Board (STSB)".

8. Click the gear icon next to "Milestone" in the right column, and select the correct sprint that it is due in. (In the very rare chance that it isn't due, select the "Miscellaneous" milestone, but that should really only be if we don't need to show it in the project demo, and if that's the case, why do it at all?)

9. Click the green "Submit new issue" button at the bottom of the description box.

You've now recorded your PBI, and can start working on those tasks!

Want a video tutorial? Check out [GitHub Crash Course: Issues (Feature Request and Bug Reports)](https://youtu.be/j1-xU6bmZZg)!

## "I'm working on a sprint task. How do I track it?"

First, you make all of the changes you need to for a task (or part of a task), following the instructions given on [Writing Code and Pull Requests (PRs)](WritingCode.md). Feel free to add any comments to the issue if required as your working, but for most issues it should just be a simple matter of just doing the task.

Then, so long as you include "Working on #X - Y" where X is the issue number and Y is the task your working on, once the PR is merged, the issue will add the PR to the worklog. If you include the specific task Y you're working on, you shouldn't need any comments at this stage either.

Finally, once you are done with your task, check the box saying it is done in the issue description. If you're completing the last task of the issue, you can also click the "Close issue" button at the bottom of the issue, and you're all set!

Want a video tutorial? Check out [GitHub Crash Course: Issues (Feature Request and Bug Reports)](https://youtu.be/j1-xU6bmZZg)!

## "I'm trying to find an Issue or PR. How can I filter and search for it?"

1. Open the repository at GitHub.com.

2. Click on the "Issues" or "Pull requests" tab in the **menu bar directly below the repository name (black text on a grey background)**! DO NOT click the "Issues" or "Pull requests" tab in the top menu bar (grey text on a black background); this is for all of the issues or pull requests that you have open in all repos, we just need the issues for this repo.

3. Add your filters via the filters bar and the bar directly above the issues or pull requests list. These include but are not limited to:

- From the "Filters" dropdown: "Your pull requests" --> All open pull requests that you created
- From the "Filters" dropdown: "Everything assigned to you" --> All open issues and pull request where you are an assignee (this would be your team's issues and your personal PRs for the most part)
- From the "Filters" dropdown: "Everything mentioning you" --> All open issues and pull request for all users in the repo where you are included as an assignee, code reviewer, commenter, etc.
- From the "Label" dropdown: You can select your team's label to see all open issues or pull requests belonging to your team
- From the "Milestones" dropdown: You can filter by task due date (so only show me those due next sprint)
- From the "Reviewers" dropdown: You can select all open pull requests where you are a reviewer
- From the search bar next to the "Filters" dropdown: You can flat out search for an issue or pull request

You can also use the "Open" and "Closed" toggle to switch between viewing open and closed issues and pull requests.

## What's next?

| Previous                                 |                                                                   Next |
| :--------------------------------------- | ---------------------------------------------------------------------: |
| [<-- Code Reviews (CRs)](CodeReviews.md) | [GitHub Projects: The Sprint Task Status Board -->](GitHubProjects.md) |
