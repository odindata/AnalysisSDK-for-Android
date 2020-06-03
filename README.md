# 奥丁AnalysisSDK

- [奥丁AnalysisSDK官网](http://www.odinanalysis.com/analysis.html)

## 一、集成说明

### 配置build.gradle

- 项目根目录的build.gradle

```groovy
buildscript {

    repositories {
        ...
        maven {url "http://maven.odinlk.com:58080/repository/android/" }
    }
    dependencies {
       ...
    }
}
allprojects {
    repositories {
       ...
        maven {
            url "http://maven.odinlk.com:58080/repository/android/"
        }
    }
}
```

- module工程的build.gradle

```
implementation 'com.odin:analysis:1.0.14_beta'
```

### 权限申请

- 请在AndroidManifest中添加如下权限

```xml
<uses-permission android:name="android.permission.INTERNET" />  
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
```

### 混淆设置

- OdinAnalysisSDK已经做了混淆处理，再次混淆会导致不可预期的错误，请在您的混淆脚本中添加如下的配置，跳过对OdinAnalysisSDK的混淆操作

```groovy

-keep public class com.odin.analysis.db.base.EventData{
  *;
}
-keep public class com.odin.analysis.db.base.TerminalParameters{
  *;
}
-keep public class com.odin.analysis.jsonData.ConfigurationData$*{
  *;
}
-keep public class com.odin.analysis.jsonData.Channelparam$*{
  *;
}
```

## 二、**接口功能介绍**

### 初始化

- 初始化方法必须在宿主应用application.onCreate函数中调用基础组件包提供的初始化函数：

```Java
/**
*　appkey　大数据平台申请的对应应用的appkey
*　channel当前程序发布渠道    
*/
OdinAnalysis.init(Application application,String appkey,String channel)
```



### **页面追踪**

-  Activity根据生命周期的自动监控。

    如果需要对非Activity页面，如Fragment、自定义View等非标准页面进行统计。需要通过OdinAnalysis.onPageStart/OdinAnalysis.onPageEnd接口在合适的时机进行页面统计。

  一次成对的 onPageStart -> onPageEnd 调用，对应一次非Activity页面(如：Fragment　在onCreateView调用onPageStart  onStop调用onPageEnd） 生命周期统计

```java
/*** pagename 页面名称*/
OdinAnalysis.pageStart(String pagename)

OdinAnalysis.pageEnd(String pagename)
```

### **用户注册**

记录宿主app用户注册事件注册 开发者根据自身代码情况主动埋点收集 app用户注册事件

```java
/**
* username 用户注册标识
*/
OdinAnalysis.register(String username);
```

### **用户登录**

单纯记录宿主app用户登录结果，开发者主动埋点收集

```java
/**
*  username 用户登录标识  
*  stateCode 登录结果   true：成功 false：失败
*/  OdinAnalysis.login(String username,boolean stateCode);
```

### **泛事件**

用户通过大数据平台对自己的app 需要搜集的泛事件进行设置，将需要的泛事件开启后，然后开发者主动埋点收集

```java
/**
 * eventCode 泛事件的名称，在奥丁开发者中心AnalySDK的预置事件中查看
 * attribute 事件中产生的数据建值对，所有的属性信息在奥丁开发者中心AnalySDK的预置事件中查看
*/  
OdinAnalysis.trackEvent(String eventCode， Map<String, String> attribute）
```

例子：点击按钮收藏书籍

   事件：收藏书籍

   可记录数据 ： page_id：当前页id

​          event_name：事件名称

​          content_id：内容id

​          content_name：内容名称

​          favorite_type：收藏操作类型；1-收藏；0-取消收藏

​          content_category：内容类别

​          author：作者

```java
HashMap<String, Object> hashMap = new HashMap<>();
hashMap.put("page_id", "ReadActivity");
hashMap.put("event_name", "收藏");
hashMap.put("content_id", "西游记"); 
hashMap.put("content_name", "西游记");
hashMap.put("favorite_type", 1); 
hashMap.put("content_category", "中国四大名著"); 
hashMap.put("author", "吴承恩");
OdinAnalysis.trackEvent("favorite", hashMap);
```