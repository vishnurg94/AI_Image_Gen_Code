#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_text2image_MainActivity_getSecretKey(JNIEnv* env, jobject /* this */) {
    const char* part1 = "c0957e34a11786192e8819a7d4faef72";
    const char* part2 = "5c3a0becf05716823b30e37111196e92";
    const char* part3 = "ba1953a695dddd761cce8abbffefce40";
    const char* part4 = "da8059d06aa651a02f9cc3322a7d1e0b";

    std::string full = std::string(part1) + part2 + part3 + part4;
    return env->NewStringUTF(full.c_str());
}