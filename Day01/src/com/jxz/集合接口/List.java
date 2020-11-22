package com.jxz.集合接口;

public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;
    // 查看动态数组内元素个数
    public int size() ;

    // 是否为空
    public boolean isEmpty();

    // 获取索引位置的元素
    public E get(int index) ;

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素
     */
    public E set(int index, E element) ;

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(E element);
    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element);
    /**
     * 实际上只是把size置位0，这样get(index),如果index大于0，会直接报错，不会访问到原来的数据
     */
    public void clear() ;

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) ;
    /**
     * 在index位置上插入元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) ;

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return 删除的元素值
     */
    public E remove(int index) ;




}
