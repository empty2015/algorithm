package empty.github.com.algorithm;

/**
 * Created at 10/18/18
 *
 * @author Empty
 */
public class HeapSortActivity extends AlgorithmActivity {
    @Override
    public void sort(int[] arr) {
        int len = arr.length - 1;
        for (int i = len / 2 - 1; i >= 0; i--) { //堆构造
            adjustHeap(arr, i, len);
        }
        while (len >=0){
            swap(arr,0,len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            adjustHeap(arr,0,len);    //再次对堆进行调整
        }
    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param len
     */
    private void swap(int[] arr,int i,int len){
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
        printArr(arr);
    }

    /**
     * 初始化大堆
     *
     * @param arr
     * @param i
     * @param len
     */
    private void adjustHeap(int[] arr, int i, int len) {
        int left, right, index;
        while ((left = 2 * i + 1) <= len) {
            right = left + 1;
            index = left;
            //求左右子节点中最大值
            int max = arr[left];
            if (right <= len && arr[right] > max) {
                max = arr[right];
                index = right;
            }
            //子节点比父节点大  交换值
            if (max > arr[i]) {
                int tmp =arr[i];
                arr[i] = max;
                arr[index] = tmp;
                i = index;
            }else{
                break;
            }
            printArr(arr);
        }
    }
}
