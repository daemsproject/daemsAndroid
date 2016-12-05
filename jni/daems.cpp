#include <jni.h>
extern "C"
jstring Java_net_fai_daems_MainActivity_NDKTestFromJNI(JNIEnv* env,
		jobject thiz) {
	jclass cls = env->GetObjectClass(thiz);
	jmethodID callback = env->GetMethodID(cls,"callback","(II)V");
	env->CallVoidMethod(thiz,callback,5,10);
	return env->NewStringUTF("Hello from C++");
}
