package tw.ray.gles_workshop_kai_niklas;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
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
        setEGLContextClientVersion(3);
        setRenderer(workshopGLRenderer);

    }

    public static class WorkshopGLRenderer implements GLSurfaceView.Renderer {
        Context context;

        public WorkshopGLRenderer(Context context) {
            this.context = context;
        }

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES30.glClearColor(0f, 0f, 1f, 1f);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES30.glViewport(0, 0, width, height);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);
            // Without the code ```GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT)```,
            //  GLES30.glClearColor(0f, 0f, 1f, 1f) in onSurfaceCreated() won't work correctly

        }
    }
}
