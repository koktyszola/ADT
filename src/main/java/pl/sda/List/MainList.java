package pl.sda.List;

public class MainList<T> {

    public void main(String[] args) {
        IList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

       T[] tab = (T[]) list.getHolderView();

        for (T val:tab)
            System.out.print(val + " ");
    }
}
