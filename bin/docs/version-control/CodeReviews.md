# Version Control Documentation - Code Reviews (CRs)

[<-- Return to Version Control Documentation Hub](README.md)

We talked about requesting a "Code Review (CR)" in our documentation on [Writing Code and Pull Requests (PRs)](WritingCode.md), but how do you give a CR? Below, we'll go over the steps that you need to give awesome CRs!

## What are "Code Reviews (CRs)"?

They are exactly what the name says: someone goes through and reviews the code that has been added to a "Pull Request (PR)", and either Approves, Comments on, or Requests changes.

During the CR, reviewer look to make sure that everything looks correct syntactically, that the code follows the style guide, and there aren't any bugs in it that they can see.

## What should I look for as a code reviewer?

Your job is to basically fine tooth comb the whole PR, and basically make sure that it is "high quality" code going into production. Things to look for include:

- Syntax errors
- Logical errors
- Style issues
- Data type issues (ex. variable x is an int, but maybe it should be a float?)
- Typos
- Out of date documentation (like comments)
- Bad permissions (ex. attribute X should be private and use getters and setters instead of being public)
- Places to reduce code duplication
- Places to improve efficiency
- Places to maybe use a better code pattern
- etc.

For this project as well, it might also be worth checking some of the PR content, like:

- Does the PR name start with [TEAM_NAME]?
- Does the description link to the feature request or bug report issue(s)?
- Are the correct assignees on the PR?
- Are the correct labels added?
- Is the PR added to the STSB and the correct milestone?
- etc.

## How do I make a "Code Review (CR)"?

1. Open the repository at GitHub.com.

2. Click on the "Pull requests" tab in the **menu bar directly below the repository name (black text on a grey background)**! DO NOT click the "Pull requests" tab in the top menu bar (grey text on a black background); this is for all of the pull requests that you have open in all repos, we just need the PRs for this repo.

3. Select the PR you want to add a CR to from the list. Note: you can [use filters](Issues.md#im-trying-to-find-an-issue-or-pr-how-can-i-filter-and-search-for-it) to help find the PR you're looking for in the list.

4. If you are marked as a reviewer, then there is usually a yellow banner above the PR title that says "This pull request is waiting on your review." If that bar is there, you can click on the green "Add your review" button, and it will take you directly to the "Files changed" page. If you are not a reviewer, you can still add a review by clicking on the "Files changed" tab directly below the PR title. Note: If the PR is still in a draft status (the oval below the title is grey and says "Draft" instead of being green and saying "Open"), you can still add a review (they system doesn't stop you), but just know the changes are not final yet and are likely still under development.

5. Add your comments and suggestions to the code directly (see below for different options). You can also mark the files as viewed, to help keep track of what you've seen, even if you didn't need to leave any comments on it (see below for how to do this). Note: for some files, you may need to click the "Load diff" button to view the changes.

6. Once you've added all of your comments and viewed all of your files, it's time to officially create your review! At the top right corner of the "Files changed", click the green "Review changes" button. That will bring up a box where you can enter a final comment, and select either "Approve", "Comment", or "Request changes".

7. While not required, most people do leave a final comment on the review, typically regarding the final status (anything from "Looks good, ship it!" to "Good start, but I've left some comments of things to take care of before we can merge.").

8. Then, select the "approval level". If you approve it, then once all the other required reviews are approved the PR is good to merge! If you just comment, it doesn't block a merge if other people approve it, but it also doesn't count towards having reviewer approvals. Finally, if you request changes, then the PR cannot be merged until the assignee makes changes and you approve the PR.

9. Finally, click the green "Submit review" button.

You've now added a CR to a PR! Once the rest of the reviewers approve it, the assignee can merge it to `main` and send the code into production!

The below sections provide more detail about step 5 above, and the different ways you can do this.

Want a video tutorial? Check out [GitHub Crash Course: Creating Code Reviews](https://youtu.be/GbjI2x0dMK0)!

### How can I create a comment?

From the "Files changed" tab:

1. Hover over a line of code (you may need to click the "Load diff" button to view the changes).

2. Click the blue "+" that occurs on the left side of the by the line number.

3. Add your comment to the text box.

4. Click the green "Start a review" or "Add review comment" button. You CAN create a comment directly by clicking "Add single comment", but it's really, really rare that there is only 1 single comment on the whole PR, AND you don't care if it gets resolved or not, AND you aren't required as a reviewer anyways. Unless all of those conditions are true, it's better to just create a review (even if it is just a "Comment" review), as it reduces the notifications sent to the assignee makes everything a bit easier.

Want a video tutorial? Check out [GitHub Crash Course: Creating Code Reviews](https://youtu.be/GbjI2x0dMK0)!

### Can I create a single comment about multiple lines of code?

Yes, you can! To do so from the "Files changed" tab:

1. Hover over a line of code (you may need to click the "Load diff" button to view the changes).

2. Click AND HOLD the blue "+" that occurs on the left side of the by the line number.

3. Press the "Shift" key

4. Click and drag the mouse until all of the lines you want to comment on are highlighted

5. Release the left mouse button.

6. Add your comment to the text box.

7. Click the green "Start a review" or "Add review comment" button. You CAN create a comment directly by clicking "Add single comment", but it's really, really rare that there is only 1 single comment on the whole PR, AND you don't care if it gets resolved or not, AND you aren't required as a reviewer anyways. Unless all of those conditions are true, it's better to just create a review (even if it is just a "Comment" review), as it reduces the notifications sent to the assignee makes everything a bit easier.

Want a video tutorial? Check out [GitHub Crash Course: Creating Code Reviews](https://youtu.be/GbjI2x0dMK0)!

### Can I make suggestions directly?

Feel that there is a change that it would be faster for you just to implement than it would be to explain it? You can add it as a suggestion! To add a suggestion to a comment (either single or multiline):

1. Make sure the comment is on a green line of code (you can't add suggestions to code that is being deleted).

2. Press the little page icon with a "+" and a "-" in it on the far-left side of the edit menu (just to the left of heading, bold, and italics).

3. Make your proposed code change.

4. Continue adding content to the comment around the "suggestion block" that was just added.

5. Post the comment, and the suggestion will then allow the assigning to merge it directly!

Want a video tutorial? Check out [GitHub Crash Course: Creating Code Reviews](https://youtu.be/GbjI2x0dMK0)!

### How can I keep track of files I've seen?

Code reviews can be long! Fortunately, you can mark which files you've seen by clicking the "Viewed" checkbox on the far-right side of the file name bar for each file in the "Files changed" tab.

Want a video tutorial? Check out [GitHub Crash Course: Creating Code Reviews](https://youtu.be/GbjI2x0dMK0)!

## Help! Changes were requested on my PR! What do I do?

At its simplest: follow the directions given to you in the comments, make/"Push" the changes to the PR or Code, and send it back for review.

That being said, there are a number of helpful techniques you can use to help keep track of everything as you're making changes:

1. Reply to comments as you go. It's much easier to write and commit chucks of code at once, but post as soon as you've made a change so you don't need to keep going back to the change and see what the next steps are. This is especially great if you disagree with the comment; this is your chance to start a conversation and figure out the best path forward!

2. Resolve conversions once you've made a change. This collapses them down so they don't create as much cluttering.

3. View your comments with more context in the "Files changed" tab (found right below PR title).

4. Once you've finished updating a file, or if there were no comments on file, you can mark it as "Viewed" on the "Files changed" tab to hide the whole file from view (you can maximize it again later if you want by either expanding it on the left, or unchecking viewed.) To mark a file as viewed, click the "Viewed" checkbox on the far-right side of the file name bar for each file in the "Files changed" tab.

5. "Commit" suggestions. Suggestions are great because the reviewer already did your work for you! Just click the "Add suggestion to batch" button! Then once all of the suggestions you want to accept have been added to the batch, you can click the "Commit suggestions" button, give your commit a descriptive tile and description, then click the green "Commit" button. It's that easy!

Final note regarding making changes to a PR based on a CR: it's usually helpful to reach out to the reviewers again after you make the changes, just so they know that you're ready to go for another round of reviews!

Want a video tutorial? Check out [GitHub Crash Course: Responding to Code Reviews](https://youtu.be/vSsUO_OP-f8)!

## What's next?

| Previous                                                   |                                                      Next |
| :--------------------------------------------------------- | --------------------------------------------------------: |
| [<-- Writing Code and Pull Requests (PRs)](WritingCode.md) | [Issues: Bug Reports and Feature Requests -->](Issues.md) |
