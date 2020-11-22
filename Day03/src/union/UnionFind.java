package union;

public abstract class UnionFind {
    protected int parents[];
    public UnionFind (int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("capacity must be >= 1");
        parents = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
        }
    }

    /**
     * 查看元素 v 是否属于 parents 中的元素
     * @param v
     */
    protected void rangeCheck (int v) {
        if (v < 0 || v >= parents.length) throw new IllegalArgumentException("v is out of bounds");
    }

    /**
     * 查找 v 所属的集合 （根节点）
     * @param v
     * @return
     */
    public abstract int find (int v);

    public boolean isSame (int v1, int v2) {
        return parents[v1] == parents[v2];
    }

    /**
     * 合并v1,v2所在的集合
     */
    public abstract void union (int v1, int v2);
}
