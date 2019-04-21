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
* 可以动态的分配空间,并可以根据传入的对象的大小分配最小的需求空间。<br>
* 可以进行迭代输出。<br>
* 可以进行索引，在指定位置添加/删除元素。<br>
<br>

功能详解
---------

<br>

继承与实现接口
--------
继承
```
AbstractList<E>
```
实现接口
```
List<E>
```

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

**大多数功能参考自ArrayList**

#Level-2 具有完整登陆、注册功能的APP
--------------------------------

>当前进度主要还在第一行代码的活动生命周期处。还没看数据库，日后补。<br>

#当前进度
--------
