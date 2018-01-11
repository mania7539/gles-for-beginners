#include <jni.h>
#include <string>
#include <GLES3/gl3.h>


extern "C" {
    jstring Java_tw_ray_gles_1workshop_1kai_1niklas_JNIManager_stringFromJNI(
        JNIEnv *env, jobject /* this */);
    int Java_tw_ray_gles_1workshop_1kai_1niklas_JNIManager_main(
        JNIEnv *env, jobject /* this */, int argc, jstring argv);

}

/**
 * Everytime you resize the window, it will tell how to draw the frame to it.
 *
 * @param w
 * @param h
 */
void reshape(int w, int h) {
    glViewport(0, 0, w, h);
}

/**
 * This function tells OpenGL to draw the color
 */
void display() {
    glClear(GL_COLOR_BUFFER_BIT);





//    glutSwapBuffers();
    // glutSwapBuffers() is for double buffering
    // When OpenGL sets to double buffering, it means swap the back buffer to front
}

/**
 * Everytime that it's done with one frame, OpenGL should redraw everything,
 *  It tells what color should it use. But it only sets the color, NOT use it yet.
 */
void initOpenGL() {
    glClearColor(0, 0, 0, 1);
    // alpha could be 0 or 1, there are all the same
}

JNIEXPORT int JNICALL
Java_tw_ray_gles_1workshop_1kai_1niklas_JNIManager_main(
        JNIEnv *env,
        jobject /* this */, int argc, jstring argv)
{
//     glutInit(&argc, argv);
//     glutInitDisplayMode(GLUT_DOUBLE);
//     glutInitWindowSize(500, 500);
//     glutInitWindowPosition(100, 100);
//     glutCreateWindow("first opengl app");
//     glutMainLoop();
    //
    // The code above is unnecessary for GLES
    // GLUT doesn't ship with Android
    //  but it has 3rd party supports: http://freeglut.sourceforge.net/docs/android.php

    initOpenGL();
    display();


//    glutDisplayFunc(display);
//    glutIdleFunc(display);
//    glutReshapeFunc(reshape);
//    glutMainLoop();
    //
    // GLUT doesn't ship with Android
    // It passes callback functions "display" and "reshape"

    return 0;
}

JNIEXPORT jstring JNICALL
Java_tw_ray_gles_1workshop_1kai_1niklas_JNIManager_stringFromJNI(
        JNIEnv *env,
        jobject /* this */)
{
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


