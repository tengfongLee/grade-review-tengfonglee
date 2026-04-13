## Run `ListTester` Locally (Windows)

To run `ListTester.java` individually, make sure the following files are in the **same folder**:

- `ListTester.java`
- `ListExamples.java`
- `StringChecker.java`

Also include the `lib/` folder in that same directory.

Your folder should look like this:

```
your-folder/
├── ListTester.java
├── ListExamples.java
├── StringChecker.java
└── lib/
    ├── junit-4.13.2.jar
    └── hamcrest-core-1.3.jar
```

Step 1: Open Terminal in VSCode
Open the project folder in VSCode
Click Terminal → New Terminal

Step 2: Navigate to the folder
cd path\to\your-folder

Example:

cd C:\Users\YourName\Desktop\autograde_test

Step 3: Compile the files
javac -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" ListTester.java ListExamples.java StringChecker.java

Step 4: Run the tests
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore ListTester

Step 5: Check the exit code
echo $LASTEXITCODE


The terminal should return:

0

This means all tests passed successfully and ListExamples.java satisfies the test cases.
