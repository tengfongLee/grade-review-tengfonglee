To run ListTester individually, download ListExamples.java and StringChecker.java with ListTester.java into the same folder, and also put the lib folder into that folder.
 Open a terminal in VSCode ->new terminal, then type 

cd (your dir where all three folders are)
javac -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" ListTester.java ListExamples.java StringChecker.java
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore ListTester
echo $LASTEXITCODE
And it's supposed to return 0 on terminal since the ListExamples.java should solve all the problems correctly
