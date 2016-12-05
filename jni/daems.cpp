#include <jni.h>
extern "C"
jstring Java_net_fai_daems_MainActivity_NDKTestFromJNI(JNIEnv* env,
		jobject thiz) {
	return env->NewStringUTF("Hello from JNI !");
}
