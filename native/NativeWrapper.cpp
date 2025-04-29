#include "NativeWrapper.h"
#include <string>
#include <iostream>

JNIEXPORT jint JNICALL Java_NativeWrapper_performCalculation(JNIEnv *env, jobject obj, jint a, jint b) {
    // Implement your calculation here
    return a + b; // Example implementation
}

JNIEXPORT jstring JNICALL Java_NativeWrapper_processString(JNIEnv *env, jobject obj, jstring input) {
    const char *nativeString = env->GetStringUTFChars(input, 0);
    
    // Process the string (example: convert to uppercase)
    std::string str(nativeString);
    for (auto &c : str) {
        c = toupper(c);
    }
    
    env->ReleaseStringUTFChars(input, nativeString);
    return env->NewStringUTF(str.c_str());
}

JNIEXPORT void JNICALL Java_NativeWrapper_initialize(JNIEnv *env, jobject obj) {
    // Initialization code
    std::cout << "Initializing native library" << std::endl;
}

JNIEXPORT void JNICALL Java_NativeWrapper_cleanup(JNIEnv *env, jobject obj) {
    // Cleanup code
    std::cout << "Cleaning up native library" << std::endl;
}