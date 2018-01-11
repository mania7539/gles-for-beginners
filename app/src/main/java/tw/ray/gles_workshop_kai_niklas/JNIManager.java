package tw.ray.gles_workshop_kai_niklas;
/**
 * Created by manina7539 on 10/01/2018.
 */

public class JNIManager {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    public static native String main(int argc, String argv);
    public static native String stringFromJNI();
}
