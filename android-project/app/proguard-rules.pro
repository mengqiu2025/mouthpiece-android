# 原 release 包由 R8 全量混淆（应用自身包名也被重写），此处按常规 Android 应用配置保留。
# 如需与原始 release 行为一致，可放开更激进的收缩/混淆选项。

# WorkManager 反射实例化 Worker，必须保留
-keep class * extends androidx.work.ListenableWorker { <init>(...); }

# 保留 Application / Activity 入口
-keep class com.mouthpiece.app.MouthpieceApp { *; }
-keep class com.mouthpiece.app.MainActivity { *; }
