# justinpoonjj - Project Portfolio Page

## Overview

**ResuMake CLI** is a desktop command-line application that helps users manage and structure resume content such as projects, experiences, CCAs, and bullet points. The user interacts with it through CLI commands, and the application is written in Java.

Given below are my contributions to the project.

---

## New Feature: Parser for Command Interpretation

**What it does:**  
Parses raw user input into executable commands by identifying the command keyword and extracting relevant fields such as title, role, tech stack, and dates.

**Justification:**  
This feature is essential because it acts as the bridge between user input and application logic. Without a robust parser, commands cannot be interpreted correctly, making the application difficult to use.

**Highlights:**
- Designed a structured parsing flow to handle multiple command types, including add, edit, delete, and bullet commands.
- Implemented validation for input formats such as required fields, field order, date format, and invalid command flags.
- Refactored parsing logic to use a consistent exception-based approach through `ResumakeException` instead of returning `null`.
- Handled more complex parsing cases such as optional edit fields and command flags (`/role`, `/tech`, `/from`, `/to`).

---

## New Feature: Add Command

**What it does:**  
Allows users to add new records such as projects, experiences, and CCAs into the system.

**Justification:**  
This is a core feature because it enables users to build and store their resume content.

**Highlights:**
- Integrated `project`, `experience`, and `cca` parsing with the shared `Record` abstraction.
- Used the `Record` hierarchy (`Project`, `Experience`, `Cca`) so add-record commands can share common parsing and validation logic.
- Returned an `AddCommand` with the parsed `Record`, keeping command creation consistent across record types.
- Added duplicate record checks to prevent identical records from being added.

---

## New Feature: AddBullet Command

**What it does:**  
Allows users to add bullet points to a specific record.

**Justification:**  
Bullet points are essential for detailing achievements and responsibilities in a resume. This feature improves usability by allowing users to update records incrementally.

**Highlights:**
- Added indexed access to records for bullet insertion.
- Validated record indices and bullet content.
- Prevented blank and duplicate bullet points from being added.
- Improved error handling so invalid bullet input is surfaced cleanly instead of crashing the application.

---

## Enhancement: Add Bullets During Add-Record Flow

**What it does:**  
After a user adds a record, the app can prompt them to add bullet points immediately without requiring a separate `addbullet` command.

**Justification:**  
Users often think of resume bullets while creating the record itself. This improves the add-record workflow by making record creation and bullet entry feel more connected.

**Highlights:**
- Extended `AddCommand` so users can choose whether to enter bullets after adding a record.
- Allowed repeated bullet entry until the user exits the prompt.
- Added test coverage for declining bullet entry, adding multiple bullets, blank bullet handling, duplicate bullet handling, and immediate exit.

---

## Summary of Contributions

### Code Contributed

- Functional code and tests: [RepoSense link](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2026-02-20T00%3A00%3A00&filteredFileName=)

### Enhancements Implemented

1. **Improved parser robustness**
   - Refactored parser errors to use `ResumakeException` consistently.
   - Added validation for malformed command formats, missing fields, invalid fields, invalid indices, and invalid dates.
   - Benefit: users receive clearer error messages and the app avoids silent parser failures.

2. **Improved add-record and record abstraction integration**
   - Integrated add-record parsing with the `Record` hierarchy (`Project`, `Experience`, `Cca`).
   - Extracted shared fields such as title, role, tech stack, start date, and end date before constructing the correct record subclass.
   - Benefit: add-record commands follow one consistent parsing and execution flow.

3. **Improved duplicate and invalid input handling**
   - Added duplicate record protection.
   - Prevented duplicate bullets and blank bullets from being added.
   - Fixed cases where invalid bullet input could crash or prematurely terminate the command flow.
   - Benefit: resume data remains cleaner and invalid input is handled more safely.

4. **Improved test coverage and regression confidence**
   - Added and expanded tests for `AddCommand`, `AddBulletCommand`, `Record`, `Parser`, and `Resumake`.
   - Added regression tests for duplicate records, duplicate bullets, blank bullet input, and the add-record flow.
   - Updated text UI tests to reflect expected command behavior and outputs.

5. **Code quality and maintainability**
   - Added Javadocs for newly introduced public APIs where needed.
   - Reformatted parser code to satisfy checkstyle line-length and indentation rules.
   - Used Java logging (`Logger`) to trace parser and command execution paths during debugging.

### Contributions to the User Guide (UG)

- Documented command formats for adding records and bullet points.
- Clarified required input structure, field order, and date format expectations.
- Updated user-facing examples for commands I worked on.

### Contributions to the Developer Guide (DG)

- Added implementation details for the `Parser` component.
- Explained the command parsing workflow and design decisions.
- Documented how parser output connects to command execution and the record model.

### Contributions to Team-Based Tasks

- Helped structure the core application flow: `Parser -> Command -> Execution -> Storage`.
- Contributed to discussions on exception handling, command consistency, and parser behavior.
- Reviewed teammates' code and provided feedback on command structure and parsing logic.

### Tools

- Used JUnit to test parser and command functionality.
- Used Gradle (`test`, `checkstyleMain`, `checkstyleTest`) for verification.
- Used Java logging (`Logger`) for debugging and tracing command execution.

---
