#!/bin/bash

# Create output directory if it doesn't exist
mkdir -p out

# Compile all Java files into 'out'
javac -d out *.java

# Run the main class
java -cp out PlatformAnalytics
