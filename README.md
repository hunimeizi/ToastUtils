# 吐司框架

#### 集成步骤

* 如果你的项目 Gradle 配置是在 `7.0 以下`，需要在 `build.gradle` 文件中加入

```groovy
allprojects {
    repositories {
        // JitPack 远程仓库：https://jitpack.io
        maven { url 'https://jitpack.io' }
    }
}
```

* 如果你的 Gradle 配置是 `7.0 及以上`，则需要在 `settings.gradle` 文件中加入

```groovy
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

* 配置完远程仓库后，在项目 app 模块下的 `build.gradle` 文件中加入远程依赖

```groovy
android {
    // 支持 JDK 1.8
    compileOptions {
        targetCompatibility JavaVersion.VERSION_1_8
        sourceCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation 'io.github.hunimeizi:haolinToastUtils:1.0.0'
}
```

#### 初始化框架

```java
public class XxxApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化 Toast 框架
        DoToast.init(this);
    }
}
```

#### 框架 API 介绍

```java
// 显示 Toast
ToastUtils.show(CharSequence text);
ToastUtils.show(int id);
ToastUtils.show(Object object);

// debug 模式下显示 Toast
ToastUtils.debugShow(CharSequence text);
ToastUtils.debugShow(int id);
ToastUtils.debugShow(Object object);

// 延迟显示 Toast
ToastUtils.delayedShow(CharSequence text, long delayMillis);
ToastUtils.delayedShow(int id, long delayMillis);
ToastUtils.delayedShow(Object object, long delayMillis);

// 显示短 Toast
ToastUtils.showShort(CharSequence text);
ToastUtils.showShort(int id);
ToastUtils.showShort(Object object);

// 显示长 Toast
ToastUtils.showLong(CharSequence text);
ToastUtils.showLong(int id);
ToastUtils.showLong(Object object);

// 自定义显示 Toast
ToastUtils.show(ToastParams params);

// 取消 Toast
ToastUtils.cancel();

// 设置 Toast 布局（全局生效）
ToastUtils.setView(int id);

// 设置 Toast 布局样式（全局生效）
ToastUtils.setStyle(IToastStyle<?> style);
// 获取 Toast 布局样式
ToastUtils.getStyle()

// 判断当前框架是否已经初始化
ToastUtils.isInit();

// 设置 Toast 策略（全局生效）
ToastUtils.setStrategy(IToastStrategy strategy);
// 获取 Toast 策略
ToastUtils.getStrategy();

// 设置 Toast 重心和偏移
ToastUtils.setGravity(int gravity);
ToastUtils.setGravity(int gravity, int xOffset, int yOffset);

// 设置 Toast 拦截器（全局生效）
ToastUtils.setInterceptor(IToastInterceptor interceptor);
// 获取 Toast 拦截器
ToastUtils.getInterceptor();
```

#### 框架亮点

* 一马当先：适配 Android 11 的吐司框架，使用者无需关心适配过程

* 无需权限：[不管有没有授予通知栏权限都不影响吐司的弹出](https://www.jianshu.com/p/1d64a5ccbc7c)

* 兼容性强：[处理原生 Toast 在 Android 7.1 产生崩溃的历史遗留问题](https://www.jianshu.com/p/437f473017d6)

* 功能强大：不分主次线程都可以弹出Toast，自动识别资源 id 和 int 类型

* 使用简单：只需传入文本，会自动根据文本长度决定吐司显示的时长

* 性能最佳：使用懒加载模式，只在显示时创建 Toast，不占用 Application 启动时间

* 体验最佳：显示下一个 Toast 会取消上一个 Toast 的显示，真正做到即显即示

* 全局统一：可以在 Application 中初始化 Toast 样式，达到一劳永逸的效果

#### 如何替换项目中已有的原生 Toast

* 在项目中右击弹出菜单，Replace in path，勾选 Regex 选项，点击替换

```text
Toast\.makeText\([^,]+,\s*(.+),\s*[^,]+\)\.show\(\)
```

```text
ToastUtils.show($1)
```