#include <jni.h>
#include <string>

#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GLES/gl.h>
#endif

#include <stdio.h>


extern "C" {
    jstring Java_tw_ray_gles_1workshop_1kai_1niklas_MainActivity_stringFromJNI(
        JNIEnv *env, jobject /* this */);
    int Java_tw_ray_gles_1workshop_1kai_1niklas_MainActivity_main(
        JNIEnv *env, jobject /* this */);

}

JNIEXPORT int JNICALL
Java_tw_ray_gles_1workshop_1kai_1niklas_MainActivity_main(
        JNIEnv *env,
        jobject /* this */, int argc, char **argv)
{


    return 0;
}

JNIEXPORT jstring JNICALL
Java_tw_ray_gles_1workshop_1kai_1niklas_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */)
{
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


