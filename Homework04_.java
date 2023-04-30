package Homework_;

public class Homework04_ {
    public static void main(String[] args) {
        Cellphone_ cellphone = new Cellphone_();
        System.out.println(cellphone.work(10 , 8));
    }
}

interface Calu_ {
    double work(double n1, double n2);
}

class Cellphone_ implements Calu_{
    //若今天要從加法改成乘法,程式設計就不彈性
    //所以可以使用匿名內部類 重新修改
    @Override
    public double work(double n1, double n2) {
        return n1 + n2;
    }



}
