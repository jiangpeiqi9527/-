package union;

/**
 * quick find
 */
public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     * 通过parent链条不断向上找
     * @param v
     * @return
     */
    public int find (int v) {
        rangeCheck(v);
        return parents[v];
    }



    /**
     * 将v1集合的所有元素嫁接到v2的根节点
     * @param v1
     * @param v2
     */
    public void union (int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }
}
