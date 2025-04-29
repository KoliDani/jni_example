# JNI Example - Java/C++ Interface

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This repository demonstrates how to create a Java-C++ interface using Java Native Interface (JNI).

## Table of Contents
- [Overview](#-overview)
- [Prerequisites](#-prerequisites)
- [Setup & Build](#-setup--build)
- [Project Structure](#-project-structure)
- [License](#-license)

## Overview
This example shows:
- How to generate JNI headers from a Java class
- How to compile a C++ shared library (DLL/SO) for JNI
- How to load and use the native library in a Java project

## Prerequisites
- **Java JDK** (with `JAVA_HOME` environment variable set)
- **C++ Compiler** (Tested with `g++` via MSYS2 on Windows)
- **MSYS2** (for Windows users)

Install the MSYS2 compiler, I used the following: 
```bash
pacman -Syu
pacman -S mingw-w64-ucrt-x86_64-gcc
```

## Setup & Build

### 1. Create the java wrapper class with native method declarations and static library setup.
### 2. Run the following command from cmd in the path, where your *.java wrapper is defined:
```bash
javac -h . *.java
```
### 3. Copy the generated header file next to the c++ source file
### 4. Compile the c++ source file
```bash
export JAVA_INCLUDES="%JAVA_HOME%\include"
export JAVA_WIN32_INCLUDES="%JAVA_HOME%\include\win32"
g++ -static -static-libgcc -static-libstdc++ -I"$JAVA_INCLUDES" -I"$JAVA_WIN32_INCLUDES" -shared -o "*.dll" "*.cpp" -Wl,--add-stdcall-alias
```
### 5. Create a folder structure in the root of the java project as following:
````markdown
jni_example/
├── src/
│   └── # Java class with native methods
├── native/
│   ├── # C++ implementation
│   └── # JNI-generated header
├── native_libs/
│   ├── windows     # Windows library
│   ├── linux       # Linux library
│   └── mac         # Mac library
└── README.md
````
### 6. Run the code and enjoy!