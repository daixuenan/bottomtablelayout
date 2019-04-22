# BottomTableLayout

#### 介绍
区别于Android自带的TabLayout，区别是支持添加网络url按钮图标。

#### 安装教程

项目的root Gradle下添加 maven { url 'https://jitpack.io' }，如下

```markdown
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }

    allprojects {
        repositories {
            google()
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }
```
modle 的Gradle添加

```markdown
implementation 'com.github.daixuenan:bottomtablelayout:v1.0.0'
```

#### 使用说明

1. 用法与TableLayout基本一致。
activity_main.xml
```aidl
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <!--添加一个ViewPager方便看效果-->
        <android.support.v4.view.ViewPager
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1" />

        <!--分割线 好看-->
        <View
            android:layout_width="match_parent"
            android:layout_height="0.5dp"
            android:background="#AAAAAA" />

        <!--TableLayout-->
        <com.dai.plugin.bottomtablelayout.BottomTabLayout
            android:id="@+id/tabLayout"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            android:background="#FFFFFF"
            android:elevation="10dp"
            app:tabBackground="@android:color/transparent"
            app:tabGravity="fill"
            app:tabIndicatorHeight="0dp"
            app:tabMode="fixed"
            app:tabSelectedTextColor="#FF6C3B" />
    </LinearLayout>
</RelativeLayout>
```
2. xxxx
3. xxxx

#### 参与贡献


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)