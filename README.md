#树莓-Android-第二次作业
=====================
level-1 自己定义的AraayList
-------------------------
<br>

##功能简介
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

<br>

构造方法
-------

* 初始化容量构造<br>


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
* public <T> T[] toArray(T[] a)将<br>
* public E get(int index)<br>
* public void add(int index, E element)<br>
* public E remove(int index)<br>
* public ListIterator<E> listIterator(int index)<br>
  
  详情请见源码注释。<br>
<br>
  
  
内部类
------

  <br>
  
```
private class Itr implements Iterator<E>
```
<br>
照写了原Arraylist在AbstractList.listitr的优化版本
