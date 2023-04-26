public class innerClass {
    /*
    關於內部類的知識
    Inner 就是一種內部類
    public class innerClass 算一種Other類
     */
    public static void main(String[] args) {
        //新建Inner物件 , 非靜態/靜態類別 , 三種方式創建內部類
        Outer.Inner inner = new Outer().new Inner(); //(1)
        //創建後即可調用內部方法 , 變量
        System.out.println(inner.y);
        inner.methodIn();

        Outer.InnerStatic innerStatic = new Outer.InnerStatic(); //(2)
        innerStatic.print();

        //新建外部類別 , 再使用裡面的創建內部類別的方法 (3)
        Outer outer = new Outer();
        outer.newInner().getZ(); // 接著使用內部類的變量/方法

        //匿名內部類 , 語法
        /*
        new 介面 / 類別 (參數){
        ... ...
        };
         */
        Interface A = new Interface() {
            @Override
            public void IFmethod() {
                System.out.println("匿名內部類");
            }
        };
        /*
        在某個介面 / 被繼承的子類只需使用一次的場合可以這樣使用
        tips:
        A的編譯看左邊 , Interface 介面可以編譯
        A的運行類型為 : innerClass$1 (底層code執行 , 由下面A.getClass()證明)
         */
        System.out.println("A的運行類型" + A.getClass());

    }

}


interface Interface {
    public void IFmethod();
}

class Outer {//外部類
    private int x = 0;
    public String name = "Tom";
    public static double PI = 3.14;

    public Outer() {

    }

    public void method() {//外部類別要使用內部類別的 變量/方法 需要新建一個物件
        Inner inner = new Inner();
        inner.getZ();
        System.out.println(inner.y);
    }

    public Inner newInner() {
        return new Inner();
    }


    class Inner {//內部類
        //本質還是一個類
        public String name = "Jerry";
        public int y = 10;
        private int z = 100;

        public int getZ() {
            return z;
        }


        public void methodIn() {
            //當變量名稱相同時 , 依照就近原則
            System.out.println("內部類的name" + name);
            //如要使用外部類的變量 , code : Classname.this.變量
            System.out.println("外部類的name" + Outer.this.name);
            System.out.println("使用同類別的變量" + x); //private 變量可以在同類別使用

        }
    }

    static class InnerStatic {//靜態內部類

        //只能使用靜態變量
        public static void print() {
            System.out.println(PI);
            //System.out.println(x); (出現錯誤 無法使用非靜態變量)
        }
    }
}
