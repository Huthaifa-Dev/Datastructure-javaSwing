/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

/**
 *
 * @author Huthaifa J Salman
 * @param <E>
 */
public class MyArrayList<E> {

    int SIZE = 0;
    E elemnts[];

    public MyArrayList() {
        elemnts = (E[]) new Object[10];
    }

    public void add(E value) {
        if (SIZE == elemnts.length) {
            ensureCap();
        }
        elemnts[SIZE] = value;
        SIZE++;
    }

    public void add(E value, int index) {
        if (SIZE == elemnts.length - 1) {
            ensureCap();
        }

        for (int i = SIZE - 1; i >= index; i--) {

            elemnts[i + 1] = elemnts[i];
        }
        elemnts[index] = value;
        SIZE++;

    }

    public void add(int index, E data) {
        if (index > SIZE || index < 0) {
            Exception e = new IllegalArgumentException("Not a valid index!" + index);
            System.out.println(e);
        } else {
            if (SIZE == elemnts.length) {
                ensureCap();
            }
            for (int i = SIZE - 1; i >= index; i--) {

                elemnts[i + 1] = elemnts[i];
            }
            elemnts[index] = data;
            SIZE++;
        }
    }

    private void ensureCap() {

        E[] arrNew = (E[]) new Object[SIZE * 2];
        System.arraycopy(elemnts, 0, arrNew, 0, SIZE);
        elemnts = arrNew;
    }

    public E remove(int index) {
        E value;

        value = elemnts[index];
        for (int i = index; i < SIZE - 1; i++) {
            swap(i, i + 1);

        }
        elemnts[SIZE - 1] = null;
        SIZE--;
        return value;
    }

    public E remove(E value, int index) {
        value = elemnts[index];
        for (int i = index; i < SIZE - 1; i++) {
            swap(i, i + 1);

        }
        elemnts[SIZE - 1] = null;
        SIZE--;
        return value;
    }

    public E remove(E value) {
        for (int i = 0; i < SIZE; i++) {
            if (value.equals(elemnts[i])) {
                remove(i);
                break;
            }
        }
        return value;
    }

    public void clear() {
        elemnts = (E[]) new Object[10];
        SIZE = 0;
    }

    public E get(int index) {
        return elemnts[index];
    }

    public void swap(E element, E element0) {
        if (findIndex(element) != -1 && findIndex(element0) != -1) {
            E temp = elemnts[findIndex(element)];
            elemnts[findIndex(element)] = elemnts[findIndex(element0)];
            elemnts[findIndex(element0)] = temp;
        }
    }

    public void swap(int element, int element0) {
        E temp = elemnts[element0];
        elemnts[element0] = elemnts[element];
        elemnts[element] = temp;
    }

    void swap(int element, E value) {
        E temp = elemnts[element];
        if (findIndex(value) != -1) {
            elemnts[element] = elemnts[findIndex(value)];
            elemnts[findIndex(value)] = temp;
        }
    }

    void removeDup(){
        for(int i=0;i<SIZE-1;i++){
            E comp=elemnts[i];
            for(int j=0;j<SIZE;j++){
                if(comp.equals(elemnts[j])&&i!=j){
                    remove(j);
                }
            }
        }
    }
    int findIndex(Object value) {
        int index;
        for (index = 0; index < SIZE; index++) {
            if (elemnts[index].equals(value)) {
                return index;
            }
        }
        return -1;
    }

    public void reverse() {
        E newElements[] = (E[]) new Object[elemnts.length];
        for (int i = 0; i < SIZE; i++) {
            newElements[i] = elemnts[SIZE - 1 - i];
        }
        elemnts = newElements;
    }

    public int size() {
        return SIZE;
    }

    public String generic() {
        if (SIZE > 0) {
            E s = elemnts[0];
            return s.getClass() + "";
        }

        return "";
    }

    private MyArrayList copy(MyArrayList list) {
        for (int i = 0; i < SIZE; i++) {
            list.add(elemnts[i]);
        }
        return list;
    }

    public void stringSort() {
        MyArrayList<String> sort = new MyArrayList<>();
        sort = copy(sort);

        for (int lastUnsortedIndex = SIZE - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 0; i <= lastUnsortedIndex; i++) {
                if (sort.get(i).length() > (sort.get(largest).length())) {
                    largest = i;
                }
            }
            swap(largest, lastUnsortedIndex);
        }

    }

}
