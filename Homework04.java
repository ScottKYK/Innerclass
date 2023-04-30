package Homework_;

public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        //使用匿名內部類
        cellphone.testWork(new Calu() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 10, 8);
        //若想改成 相乘 , 匿名內部類可以一次完成
        //不像傳統方法要從Cellphone 內部修改 如同 Homework04_內一樣
        cellphone.testWork(new Calu() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 10, 8);
    }
}

interface Calu {
    double work(double n1, double n2);
}

class Cellphone {

    public void testWork(Calu calu, double n1, double n2) {
        double result = calu.work(n1, n2);
        System.out.println(result);
    }
}