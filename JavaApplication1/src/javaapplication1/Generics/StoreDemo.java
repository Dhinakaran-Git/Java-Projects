package javaapplication1.Generics;

class Store<T> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Store{" + "item=" + item + '}';
    }
}

public class StoreDemo {

    public static void main(String[] args) {
        Store s = new Store();
        s.setItem("Moosa");

        //any values to send
        Object item = s.getItem();
        System.out.println(item);
    }
}
