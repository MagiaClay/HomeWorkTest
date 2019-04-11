import javax.print.DocFlavor;

//该类主要是利用StringBuffer类的一些函数，其优点为：
//1.可利用构造传入更多数据类型(限定Number和String的子类) 2.可以进行对象或者其他字符串比较
//3.有增、删、查和查看长度的功能
public class MyString {
    private StringBuffer MyStr;

    public MyString(Object myStr) {//可转入整形、字符串、浮点型等数据并转换为StringBuffer类
        if (myStr instanceof Number||myStr instanceof String)//判断输入是否合法
            MyStr = new StringBuffer(myStr.toString());
        else{
            System.out.println("输入数据不符合类型");
            System.exit(0);

        }
    }

    public MyString(StringBuffer myStr) {
        MyStr = myStr;
    }

    public StringBuffer getMyStr() {
        return MyStr;
    }

    public void setMyStr(StringBuffer myStr) {
        MyStr = myStr;
    }
    public int mySize(){//求出数组长度
        return this.MyStr.length();
    }
    public boolean myEquals(MyString MS){//用于判断两个对象是否相等
        if (this==MS){
            return true;
        }else if (this.MyStr.toString().equals(MS.MyStr.toString())){
            return true;
        }else {
            return false;
        }
    }
    public void myAdd(MyString MS){
        this.MyStr.append(MS.MyStr);
    }
    public void myAdd(String str){
        this.MyStr.append(str);
    }
    public  void myAdd(char c){
        this.MyStr.append(c);
    }
    public String toString(){//覆写打印方法
        return this.MyStr.toString();
    }
    public StringBuffer myDelete(int start,int end){//在指点位置删除字符串
        return this.MyStr.delete(start,end);
    }
    public boolean myIndexOf(String str){//查找字符串是否存在，有则返回位置
        if (this.MyStr.indexOf(str)!=0){
            System.out.println("找到"+str+"字符串，它的位置时在该对象的第"+this.MyStr.indexOf(str)+"位");
            return true;
        }
        else
            return false;
    }

}

