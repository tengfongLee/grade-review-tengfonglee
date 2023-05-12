CPATH='../lib/junit-4.13.2.jar:../lib/hamcrest-core-1.3.jar:.'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

if [-z "$1"]
then
    echo "Usage: $0 <github URL>"
    exit 1
fi

git clone $1 student-submission
echo 'Finished cloning'
cp -r student-submission/ grading-area/
cd grading-area


javac CPATH ListTests.java
echo $?

java -cp CPATHorg.junit.runner.JUnitCore ListTests > output.txt
cat output.txt
echo $?

#calculate grade, report specifi tests

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
