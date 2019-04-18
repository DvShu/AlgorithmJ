package algorithm.j.data_structure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆，通常用 ArrayList 来实现数据的存储
 * 堆具有一些如下的特定：
 *  1. 根据子节点index获取父节点的index：parent(i) = (i - 1) / 2
 *  2. 根据父节点index获取左边子节点的index: leftChild(i) = 2 * i + 1
 *  3. 根据父节点index获取右边子节点的index: rightChild(i) = 2 * i + 2
 * @param <T>
 */
public abstract class Heap<T> {

    private List<T> container;

    public Heap() {
        container = new ArrayList<>();
    }

    /**
     * 在堆的尾部插入元素同时向上整理堆元素，直至符合该堆的属性
     * @param item  待插入的元素
     */
    public void insert(T item) {
        container.add(item);
    }

    /**
     *  不删除节点并返回最大值（最大堆）或者最小值（最小堆）
     * @return 如果是最大堆返回最大值；如果是最小堆返回最小值
     */
    public T peek() {
        return container.get(0);
    }

    /**
     * 从末尾开始向上整理堆属性
     */
    private void shiftUp() {
        shiftUp(container.size() - 1);
    }

    /**
     * 从指定位置处开始向上整理堆
     *  1. 最大堆：如果父节点的元素值小于子节点的元素值，则交换数据，依次往上整理，直到符合最大堆属性为止。
     *  2. 最小堆：同理最大堆，
     * @param startIndex  指定的向上整理数据的index
     */
    private void shiftUp(int startIndex) {
        // 获取父节点的index
        int parentIndex = parentIndex(startIndex);
        while(startIndex > 0 && !pairIsCorrect(container.get(parentIndex), container.get(startIndex))) {
            swap(parentIndex, startIndex);
            startIndex = parentIndex;
            parentIndex = parentIndex(startIndex);
        };
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = container.get(index1);
        container.set(index1, container.get(index2));
        container.set(index2, temp);
    }

    /**
     * 检查堆的属性是否正确；如果是最大堆，则父节点的元素值必须大于子节点的元素值；如果是最小堆，则父节点的元素值必须小于子节点的元素值
     * @param parent 父节点
     * @param child  子节点
     * @return @{boolean}
     */
    public boolean pairIsCorrect(T parent, T child) {
        return false;
    }
}
