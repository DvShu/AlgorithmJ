package algorithm.j.data_structure.heap;

/**
 * 最大堆：父节点的元素值必须大于子节点的元素值
 * @param <T>  要求存放的节点的元素值必须实现 Comparable 接口
 */
public class MaxHeap<T extends Comparable> extends Heap<T> {

    /**
     * 检查堆的属性是否正确；如果是最大堆，则父节点的元素值必须大于子节点的元素值；如果是最小堆，则父节点的元素值必须小于子节点的元素值
     * @param parent 父节点
     * @param child  子节点
     * @return 如果堆属性正确返回true，否则返回false
     */
    @Override
    boolean pairIsCorrect(T parent, T child) {
        return parent.compareTo(child) >= 0;
    }
}
