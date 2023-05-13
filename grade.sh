CPATH=':../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar'      

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

#check if argument exsit

if [ -z "$1" ]; then
    echo "Usage: $0 <github URL>"
    exit 1
fi
echo $?

git clone $1 student-submission
echo 'Finished cloning'
if [ ! -f "student-submission/ListExamples.java" ] 
then
    echo "The student code is missing the ListExamples.java file."
    exit 1
fi
echo $?

cp -r student-submission/ grading-area/
cp ListTester.java grading-area/
cd grading-area


#test the file
javac -cp $CPATH:. ListTester.java ListExamples.java >> output.txt 2>> errorOutput.txt
#check if the ListExamples.java are the file we got
if [ $? -ne 0 ]
then
    echo "The file might be wrong, file name must be ListExamples.java" 1>&2 >> errorOutput.class
fi

#do the test
java -cp $CPATH:. org.junit.runner.JUnitCore ListTester >> output.txt

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
    echo "Multiple tests failed. Grade: D" | tee -a out.txt
fi





   