#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_tw_ray_gles_1workshop_1kai_1niklas_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
