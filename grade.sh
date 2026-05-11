# Auto-detect Java classpath separator
# Windows Java uses ;
# Mac/Linux Java uses :
case "$(uname -s)" in
    MINGW*|MSYS*|CYGWIN*)
        SEP=';'
        ;;
    *)
        SEP=':'
        ;;
esac

CPATH=".${SEP}../lib/hamcrest-core-1.3.jar${SEP}../lib/junit-4.13.2.jar" 

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

#check if argument exsit

if [ -z "$1" ]; then
    echo "Usage: $0 <github URL or local repo path>"
    exit 1
fi


git clone "$1" student-submission

if [ $? -ne 0 ]; then
    echo "Failed to clone student submission. Grade: D"
    exit 1
fi

echo 'Finished cloning'

if [ ! -f "student-submission/ListExamples.java" ] 
then
    echo "The student code is missing the ListExamples.java file."
    exit 1
fi


cp student-submission/ListExamples.java grading-area/
cp ListTester.java grading-area/
cp StringChecker.java grading-area/

cd grading-area


# Compile student code with tester
javac -cp "$CPATH" ListTester.java ListExamples.java StringChecker.java >> output.txt 2>> errorOutput.txt
#check if the ListExamples.java are the file we got
if [ $? -ne 0 ]
then
    echo "Compilation failed. Grade: D" | tee -a output.txt
    exit 1
fi

#do the test
java -cp "$CPATH" ListTester >> output.txt 2>> errorOutput.txt

#grade are return from .java
grade=$?

#check grade, grade are calculated in .java
if [ $grade -eq 0 ]
then 
    echo "All tests passed. Grade: A" | tee -a output.txt #output on terminal & into file
elif [ $grade -eq 1 ]
then
    echo "One test failed. Grade: B" | tee -a output.txt
elif [ $grade -eq 2 ] 
then
    echo "Two tests failed. Grade: C" | tee -a output.txt
else
    echo "Multiple tests failed. Grade: D" | tee -a output.txt
fi





   
