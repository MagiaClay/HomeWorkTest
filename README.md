#树莓-Android-第二次作业
=====================
level-1 自己定义的AraayList
-------------------------
<br>
功能简介
---------

只能接受
```
MyArrayList<E extends Number>
```
整形数和浮点数<br>
* 可以动态的分配空间。<br>
* 可以进行迭代输出。<br>
* 可以在指定位置添加/删除元素。<br>
<br>
功能详解
---------
构造方法
* 初始化容量构造
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
*     详情见代码注释。<br>
<br>
一般方法
--------

