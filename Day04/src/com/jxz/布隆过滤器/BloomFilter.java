package com.jxz.布隆过滤器;

public  class BloomFilter<T> {

    /**
     * 二进制向量的长度（一共有多少位二进制数）
     */
    private int bitSize;

    /**
     * 二进制向量
     */
    private long[] bits;

    /**
     * 哈希函数的个数
     */
    private int hashSize;
    /**
     * 数据规模n, 误判率p
     * @param n
     * @param p
     */
    public BloomFilter (int n, double p) {
        if (n <= 0 || p <= 0 || p >= 1) {
            throw new IllegalArgumentException("wrong p or n");
        }
        double ln2 = Math.log(2);
        // 求出二进制向量的长度
        this.bitSize = (int) (-(n * Math.log(p)) / (ln2 * ln2));
        // 求出哈希函数的个数
        this.hashSize = (int) (bitSize * ln2 / n);
        // bits数组的长度
        this.bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
    }
    /**
     * 添加元素
     * @param value
     */
     public void put (T value) {
        nullCheck(value);
        // 利用value生成两个整数
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;

         for (int i = 1; i <= hashSize; i++) {
             int combinedHash = hash1 + (i * hash2);
             if (combinedHash < 0) {
                 combinedHash = ~combinedHash;
             }
             // 生成一个二进制位的索引
             int index = combinedHash % bitSize;
             // 设置index位置的二进制位为1
             set(index);
         }
     }

    /**
     * 设置index位置的二进制为1
     * @param index
     */
    private void set(int index) {
        // 找到对应的long值
        long value = bits[index / Long.SIZE];
        bits[index / Long.SIZE] = value | (1 << (index % Long.SIZE));

    }

    /**
     * 查看index位置的二进制位的值
     * @param index
     * @return true代表1，false代表0
     */
    public boolean get (int index) {
        long value = bits[index / Long.SIZE];
        return (value | (1 << (index % Long.SIZE))) != 0;
    }
    /**
     * 判断一个元素是否存在
     * @param value
     * @return
     */
     public boolean contains (T value) {
        nullCheck(value);
         // 利用value生成两个整数
         int hash1 = value.hashCode();
         int hash2 = hash1 >>> 16;

         for (int i = 1; i <= hashSize; i++) {
             int combinedHash = hash1 + (i * hash2);
             if (combinedHash < 0) {
                 combinedHash = ~combinedHash;
             }
             // 生成一个二进制位的索引
             int index = combinedHash % bitSize;
             // 查询index位置的二进制位是否为0
             if (!get(index)) return false;
         }
        return true;
     }

     private void nullCheck (T value) {
         if (value == null) {
             throw new IllegalArgumentException("Value must not be null");
         }
     }
}
