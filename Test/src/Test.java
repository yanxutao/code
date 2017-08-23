import java.util.Scanner;

/**
 * Created by yanxutao on 4/23/17.
 */
public class Test {

    public <W> void method(W w) {
        System.out.println("method: " + w);
    }

    public static <Q> void function(Q t) {
        System.out.println("function: " + t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double h = sc.nextDouble();
//        System.out.println(h);
//        System.out.println(1 + 4 * h);
//        System.out.println(Math.sqrt(1 + 4 * h));
//        double d =  (Math.sqrt(1 + 4 * h) - 1) / 2;
//        System.out.println(d);
//        int res = (int) Math.floor(d);
//        System.out.println(res);


    }
}

class Tool<Q> {

    private Q obj;

    public void setObject(Q obj) {
        this.obj = obj;
    }

    public Q getObject() {
        return obj;
    }
}

interface Inter<T> {
    void show(T t);
}

class InterImpl<R> implements Inter<R> {
    public void show(R r) {
        System.out.println("show: " + r);
    }
}