package com.bruis.algorithminjava.datastructures;

/**
 * @author LuoHaiYang
 */
public class MyArray<E> {
    //存储的数据
    private E[] data;
    //数组大小，数组容量大小不一定等于数组实际大小
    private int size;

    //设置数组大小
    public MyArray(int capacity) {
        data = (E[])new Object[capacity];
        this.size = capacity;
    }

    public MyArray() {
        this(10);
    }

    //数组容量大小
    public int getCapacity() {
        return this.data.length;
    }

    //数组元素大小
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在index索引位置插入新元素
    public void insert(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，数组索引越界!");
        }

        //如果数组容量不足，则扩容两倍
        if (size == data.length) {
            resize(2 * size);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = value;
        size ++;
    }

    public E delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，数组索引越界!");
        }

        E delValue = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i +1];
        }
        size --;
        //gc
        data[size] = null;
        return delValue;
    }

    public void update(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，数组索引越界!");
        }
        data[index] = value;
    }

    // 向所有元素后添加一个元素
    public void addLast(E e) {
        insert(size, e);
    }

    // 向所有元素前添加一个元素
    public void addFirst(E e) {
        insert(0, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，数组索引越界!");
        }
        return data[index];
    }

    // 获取末尾元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取首部元素
    public E getFirst() {
        return get(0);
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查看数组中元素e所在的索引，如果不存在则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，数组索引越界!");
        }
        E del = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return del;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public void resize(int newSize) {
        E[] newData = (E[])new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void printData(E[] data, int size) {
        System.out.println();
        for (int j = 0; j < size; j++) {
            System.out.print(data[j]);
            if (j != size) {
                System.out.print(",");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int size = 5;
        MyArray myArray = new MyArray(size);

        //增加
        for (int i = 0; i < 3; i++) {
            myArray.insert(i, i);
        }
        myArray.printData(myArray.data, myArray.size);

        //删除
        System.out.println(myArray.delete(1));
        myArray.printData(myArray.data, myArray.size);

        //修改
        myArray.update(1, 666);
        myArray.printData(myArray.data, myArray.size);
    }
}