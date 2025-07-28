#!/bin/bash

# Create output directory if it doesn't exist
mkdir -p out

# Compile all .java files and place class files in ./out
javac -d out *.java

# Run the program from the compiled classes directory
cd out
java Main
cd ..
