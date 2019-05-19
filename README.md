
#树莓-Android-第三次作业RecyclerViewTestDEMO
=====================
自己定义的图片浏览器(该版本在Anroid Studio3.4版本开发，依赖语法已更改,测试用DEMO，具有无效依赖（导致总容量过大）或无效函数)
-------------------------
<br>

##功能简介(背景)
---------

* 实现瀑布流水式基本预览图布局<br>
* 可以解析JSON接口并取得所需要的信息<br>
* 利用dialog和开源库subsampling-scale-image-view实现点击放大图片<br>


>* 查看图片分为网络（并可下载）查看，和本地SDCard（可删除）查看，两者可相互协同实现缓存<br>
>* 可以左右滑动那个并支持多指放大<br>

* 不美观的UI<br>
* 尚在高版本不兼容的下拉刷新，上拉加载功能<br>


所需相关库的依赖
--------

* 大图查看器的最核心功能，展示图片以及手势操控我们使用了一个开源库来完成，这个开源库叫做subsampling-scale-image-view，sciv非常靠谱，使用也非常简单，我记得知乎的Android app也是使用了它。<br>
* 利用了Glind作为其大图的下载工具而不是OkHttp.<br>

LayOut
-------

* 主页面利用的是最基本的recyelerview布局。<br>
* 供recyelerview使用的单个子fruit_item布局。<br>
* 查看大图核心布局dialog_View布局，采用的RelativeLayout实现。<br>
* 供dialog_view使用的单个子beauties_item布局，采用FrameLayout实现。<br>

<br>

Drawble
--------

<br>
* 关于下载、删除和回撤的3种PNG图片，其余图片来自网络或SDCard。<br>
<br>

功能的具体实现类
--------

<br>

```
public class Fruit
```
* 就是图片类（你知道为什么叫Fruit），存有每张图片属性 _id url Bitmap<br>
```
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>
```
* 水果类的适配器，注意在该适配器的onCreateViewHolder（）中指加入了从网络加载大图功能，若想实现从FILE中加载则可更改为<br>
```
ScaleImageView scaleImageView = new ScaleImageView((Activity) context);
                scaleImageView.setFiles(files, position);
                scaleImageView.setOnDeleteItemListener(deletePosition -> adapter.removeItem(deletePosition));
                scaleImageView.create();
```
```
public class ScaleImageView
```
* 图片加载器的核心(属性和方法忘记加注释了)<br>
>* private void init()初始化，根据subsampling-scale-image-view配置相关默认属性。<br>
>* public void create()使dialong实现在主布局上。<br>
>* public void setUrls(List<String> urls, int startPosition)从网络查看大图。<br>
>* public void setFiles(List<File> files, int startPosition) 从文件中查看。<br>
>* private static class MyPagerAdapter extends PagerAdapter封装的内部类适配器。<br>
>* public interface OnDeleteItemListener {
        void onDelete(int position);
    }封装的内部接口，一半用于覆写删除本地图片操作。<br>
* 其他类可以无视。<br>
  
  详情请见源码注释。<br>
<br>
  


#构建思路过程
--------

>编写MyArrayList类时与编写MyString类时候不太相同，首先从ArrayList原本功能分析。<br>
>* 有类集框架的基本内容：增、删、改、查以及迭代。<br>
>* 以及其最大的优点动态分配内存。<br>
>* 只能接受整型数和浮点数。<br>

>实现增删改查的同时要保证内存不会分配过少导致数组越界，不会分配太多导致占用内存。<br>
>得出结论：重点在于如何实现动态内存分配。具体实现参照以下以及grow（）函数。

```
* public void ensureCapacity(int minCapacity)
ElementData = (size == 0)? EMPTY_ELEMENTDATA: Arrays.copyOf(elementData, size);
```

>* 以及其它的三个判断函数，运用system.arraycopy（）函数来实现精准分配。<br>
>* 根据动态分配实现增、删、改、查。<br>
>* 迭代的方法则参考原ArrayList的内部类。<br>


**大多数功能参考自ArrayList**<br>

作业2 具有完整功能的多媒体播放器
--------------------------------

进度还是没赶上，日后补。<br>

#当前进度
--------
* JAVA看到数据库的内容。<br>
* 第一行代码在看数据库。<br>
