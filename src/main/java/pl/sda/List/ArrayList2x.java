package pl.sda.List;

import java.util.Arrays;

public class ArrayList2x<T> implements IList<T> {

    private T[] holder;
    private int size = 0;
    private final int arraySizeMultipler = 2;

    public ArrayList2x() { holder = (T[]) new Object[arraySizeMultipler];
    }

    @Override
    public boolean isEmpty() {
        return size ==0 ? true : false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return holder[index];

    }

    @Override
    public void set(int index, T value) {
        checkBounds(index);
        holder[index] = value;


    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        for (int i = index; i< size-1; i++)
            holder[i] = holder[i+1];
        size--;

    }

    @Override
    public int firstIndexWith(T value) {
        for (int i = 0; i < size; i++) {
            if (value == holder[i]) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void add(int index, T value) {
        checkInsertBounds(index);
        if(holder.length == size)
            incrementHolderLenght();
        for (int i = size; i > index; i--) {
            holder[i] = holder[i - 1];
        }
        holder[index] = value;
        size++;
    }

    private void incrementHolderLenght() {
        int newHolderSize = holder.length * arraySizeMultipler;
        T[] newHolder = (T[]) new Object[newHolderSize];
        for(int i  = 0; i <size; i++)
            newHolder[i] = holder[i];
        holder = newHolder;
    }

    @Override
    public void add(T value) {
        if(holder.length == size)
            incrementHolderLenght();
        holder[size] = value;
        size++;
    }

    @Override
    //TODO - This should return copy of the filled part of the array
    public T[] getHolderView() {
        return Arrays.copyOfRange(holder, 0, size);

    }
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    //when inserting value you can add it between other or exactly at the end which is index = size
    private void checkInsertBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

}
