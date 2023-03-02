CPATH='".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar"'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

cd student-submission/
if [[ -f ListExamples.java ]]
then
    echo "File found"
else
    echo "File not found"
    exit 1
fi

cd ../
cp grade.sh TestListExamples.java student-submission/
cd student-submission/

javac -cp ".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar" ListExamples.java TestListExamples.java
java -cp ".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples.java
if [[ $? != 0 ]]
then
    echo "Runtime error. Test failed!"
else
    echo "Tests Passed"
fi
