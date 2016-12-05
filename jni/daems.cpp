#include <jni.h>
extern "C"
jstring Java_net_fai_daems_MainActivity_NDKTestFromJNI(JNIEnv* env,
		jobject thiz) {
	jclass cls = env->GetObjectClass(thiz);
	jmethodID callback = env->GetMethodID(cls,"callback","(Ljava/lang/String;)V");
	env->CallVoidMethod(thiz,callback,env->NewStringUTF("Callback from C++"));
	return env->NewStringUTF("Return from C++");
}
