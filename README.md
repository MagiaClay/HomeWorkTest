#树莓-Android-第三次作业
=====================
自己定义的图片浏览器(该版本在Anroid Studio3.4版本开发，依赖语法已更改,测试用DEMO，具有无效依赖或无效函数)
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


```
public MyArrayList(int initialCapacity)
```
<br>

* 传入对象构造，关于Number类的子类
```
public MyArrayList(Collection<? extends Number> c)
```
<br>
* 用于反射的空构造<br>
<br>

属性
--------

<br>
*     详情见代码注释。<br>
<br>

一般方法
--------

<br>

* public void trimToSize()主要用来在数组元素有更改后进行数组容量最小化，清除多余的空间<br>
* public void ensureCapacity(int minCapacity)确保有足够的空间分配新内存，若不够则扩大容量（所需要内存的最低容量）<br>
* public int indexOf(Object o)索引内容返回其指针<br>
* public <T> T[] toArray(T[] a)返回一个指定泛型的特定元素<br>
* public E get(int index)得到索引目标处的元素内容<br>
* public void add(int index, E element)指定位置内添加元素<br>
* public E remove(int index)指定位置内移除元素<br>
* public ListIterator<E> listIterator(int index)迭代方法<br>
  
  详情请见源码注释。<br>
<br>
  
  
内部类
------

  <br>
  
```
private class Itr implements Iterator<E>
```
<br>
照写了原Arraylist在AbstractList.listitr的优化版本。<br>

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

Level-2 具有完整登陆、注册功能的APP
--------------------------------

>当前进度主要还在第一行代码的活动生命周期处。还没看数据库，日后补。<br>

#当前进度
--------
* JAVA看到数据库的内容。<br>
* 第一行代码在看活动的生命周期。<br>
