public class MyStringTest {
    public static void main(String args[]){
        MyString my=new MyString("你好呀！！");
        my.myAdd("这个肮胀的世界！");
        my.myAdd(new MyString(233));
        System.out.println(my);
        System.out.println(my.myEquals(new MyString("你好呀！！这个肮胀的世界！233")));
        System.out.println(my.myEquals(my));
        my.myDelete(1,2);
        System.out.println(my);
    }
}
