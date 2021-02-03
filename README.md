# Chapter 13: Searching and Sorting

Please complete the following programming exercises. You may assist your fellow students but do **NOT** share answers/code.

- Write an iterative version of BinarySearch that returns true if the given element exists within the given list.
- Write a version of BubbleSort that sorts in descending order as opposed to ascending order.
- Write a version of SelectionSort that finds the max on each iteration of the loop but still gives ascending order.
- Write a version of QuickSort that uses a random index to pivot.

This repo contains starter JUnit code and a current JUnit java archive. Your code must pass all the JUnit test cases in the given code.
You may add additional test cases. If you are using an IDE other than Geany, you must ensure that your code still passes when run via GitHub Actions. 
The following commands can be used to compile and test the junit code for various platforms.

## Linux and Mac

Geany --- > Build commands

    junitc --- > javac -cp .:junit.jar "%f"
    junit  --- > java -jar junit.jar -cp . --scan-classpath

From bash when in your local repo

    To compile  ---> javac -cp .:junit.jar *.java
    To test     ---> java -jar junit.jar -cp . --scan-classpath

## Windows

Geany --- > Set Build Commands

    junitc  ---> javac -cp .;junit.jar "%f"
    junit   ---> java -jar "%d"\junit.jar -cp . --scan-classpath

From cmd when in your local repo

    To compile ---> javac -cp junit.jar *.java
    To test    ---> java -jar junit.jar -cp . --scan-classpath


Be sure to document your source code and update this README. Please contact me if you need assistance.
