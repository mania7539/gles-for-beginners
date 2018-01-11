package tw.ray.gles_workshop_kai_niklas;
import android.content.Context;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.AttributeSet;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by manina7539 on 10/01/2018.
 */

public class WorkshopGLSurfaceView extends GLSurfaceView {
    private WorkshopGLRenderer workshopGLRenderer;

    public WorkshopGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.workshopGLRenderer = new WorkshopGLRenderer(context);
//        setEGLContextClientVersion(3);
        setRenderer(workshopGLRenderer);

    }

    public static class WorkshopGLRenderer implements GLSurfaceView.Renderer {
        Context context;
        Triangle triangle;     // ( NEW )
        Square quad;           // ( NEW )

        public WorkshopGLRenderer(Context context) {
            this.context = context;

            triangle = new Triangle();   // ( NEW )
            quad = new Square();         // ( NEW )
        }


        /**
         * Called when the surface is first created or recreated.
         *      It can be used to perform one-time initialization tasks
         *      such as setting the clear-value for color and depth,
         *      enabling depth-test, etc.
         * @param gl
         * @param config
         */
        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES30.glClearColor(0f, 0f, 1f, 0f);
            // Set alpha to 0 or 1 will not affect the output result


            gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // Set color's clear-value to black
            gl.glClearDepthf(1.0f);            // Set depth's clear-value to farthest
            gl.glEnable(GL10.GL_DEPTH_TEST);   // Enables depth-buffer for hidden surface removal
            gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
            gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
            gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
            gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance


//            JNIManager.main(0, "");

        }

        /**
         * Called when the surface is first displayed and
         *      after window's size changes
         * @param gl
         * @param width
         * @param height
         */
        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            if (height == 0) height = 1;   // To prevent divide by zero
            float aspect = (float)width / height;

            // Set the viewport (display area) to cover the entire window
            gl.glViewport(0, 0, width, height);

            // Setup perspective projection, with aspect ratio matches viewport
            gl.glMatrixMode(GL10.GL_PROJECTION); // Select projection matrix
            gl.glLoadIdentity();                 // Reset projection matrix
            // Use perspective projection
            GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

            gl.glMatrixMode(GL10.GL_MODELVIEW);  // Select model-view matrix
            gl.glLoadIdentity();                 // Reset

            // You OpenGL|ES display re-sizing code here
            // ......

        }

        /**
         * Called to draw the current frame. You OpenGL rendering codes here.
         * In our OpenGL renderer, We clear the color and depth buffers
         *      (using the clear-values set via glClear* earlier).
         * @param gl
         */
        @Override
        public void onDrawFrame(GL10 gl) {
//            GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
            // Without the code ```GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT)```,
            //  GLES30.glClearColor(0f, 0f, 1f, 1f) in onSurfaceCreated() won't work correctly
            gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

            gl.glLoadIdentity();                            // Reset model-view matrix ( NEW )
            gl.glTranslatef(-1.5f, 0.0f, -6.0f);    // Translate left and into the screen ( NEW )
            triangle.draw(gl);                              // Draw triangle ( NEW )

            // Translate right, relative to the previous translation ( NEW )
            gl.glTranslatef(3.0f, 0.0f, 0.0f);
            quad.draw(gl);                                  // Draw quad ( NEW )

        }
    }
}
