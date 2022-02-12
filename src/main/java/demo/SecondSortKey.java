package demo;

import java.io.Serializable;

public class SecondSortKey implements Serializable,Comparable<SecondSortKey> {
//    两个成员属性
    private int first;
    private int second;

    public SecondSortKey(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    /** 具体的比较方法
     * 先比较第一个成员属性，如果相同再去比较第二个的大小
     * @param o
     * @return
     */
    @Override
    public int compareTo(SecondSortKey other) {
        if (first - other.getFirst() == 0){
            return second - other.getSecond();
        }else {
            return first - other.getFirst();
        }

    }
}
