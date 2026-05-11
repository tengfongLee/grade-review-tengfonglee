## Run the Autograder Locally

This project includes a simple Java/JUnit grading pipeline. The script clones a student submission, checks for `ListExamples.java`, compiles it with the tester, runs the tests, and maps the number of failed tests to a grade.

### Grader files

The autograder folder should contain:

```text
grade-review-tengfonglee-main/
├── grade.sh
├── ListTester.java
├── StringChecker.java
└── lib/
    ├── junit-4.13.2.jar
    └── hamcrest-core-1.3.jar
```

The student submission should contain:

```text
ListExamples.java
```

### Run the full grading script

For local testing, create a fake student repo next to the autograder folder:

```text
autograder-local-test/
├── grade-review-tengfonglee-main/
└── fake-student-good/
    └── ListExamples.java
```

Initialize the fake student repo:

```bash
cd fake-student-good
git init
git add ListExamples.java
git commit -m "add ListExamples"
```

Then run the grader from the autograder folder:

```bash
cd ../grade-review-tengfonglee-main
bash grade.sh ../fake-student-good
```

Expected output for a correct submission:

```text
Finished cloning
All tests passed. Grade: A
```

The exit code from `ListTester.java` represents the number of failed tests:

```text
0 = all tests passed
1 = one test failed
2 = two tests failed
3+ = multiple tests failed
```

### Notes

- `ListTester.java` contains the JUnit tests.
- `StringChecker.java` defines the interface used by `filter`.
- `grade.sh` automates clone, file check, compile, test, and grade mapping.
- `ListExamples.java` normally comes from the student submission.
- The script supports both Windows Git Bash and Unix-like systems by selecting the correct Java classpath separator.
