#include <jni.h>
extern "C"

JNIEXPORT void JNICALL Java_net_fai_daems_BoundaryReceiver_register(JNIEnv* env,
		jobject thiz) {
	jclass cls = env->GetObjectClass(thiz);
	jmethodID callback = env->GetMethodID(cls,"onReceive","(Ljava/lang/String;)V");
	env->CallVoidMethod(thiz,callback,env->NewStringUTF("Callback 从 C++"));
}
