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