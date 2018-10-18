package empty.github.com.algorithm;

/**
 * Created at 10/18/18
 *
 * @author Empty
 */
public class BubbleSortActivity extends AlgorithmActivity {
    @Override
    public void sort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            for(int j = arr.length-1;j>i;j--){
                if(arr[j-1]>arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                    printArr(arr);
                }
            }
        }
    }

}
