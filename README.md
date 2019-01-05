# DimensMake

该项目是用来批量生成屏幕分辨率限定符适配方案和最小宽度限定符适配方案中的dimens文件
使用者只需要设置基准分辨率或者最小宽度基准值，文件存放目录即可
文件生成后拷贝到对应的工程res目录下

使用步骤

* 在项目根目录下的build.gradle文件中添加如下代码

```Gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

* 在moudle下的build.gradle文件添加如下依赖

```Gradle
dependencies {
  compile 'com.github.Mangosir:DimensMake:1.0.2-dimens'
}
```

* 在工程中任何一个类添加如下代码，然后右键运行main方法即可

```Java
    public static void main(String[] args){

        //下面两种方法任选其一
        DimensBuild.buildDP();
        
        DimensBuild.buildPX();

    }
```

# 屏幕适配方案

## 屏幕分辨率限定符

我们知道市面上不同分辨率的手机太多太多了，而这种方案就是尽可能多的将其列举出来，在res目录下面创建与各种分辨率一一对应的values-xxx 文件夹；然后选定一种基准分辨率，然后其它分辨率以该分辨率做参考，生成对应的dimens文件

## 最小宽度限定符

顾名思义根据屏幕宽高中最小尺寸的dp值生成对应的values-swxxxdp目录

更详细的解析参考博客
https://blog.csdn.net/qq_30993595/article/details/85280936#_292
