package empty.github.com.algorithm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created at 10/18/18
 *
 * @author Empty
 */
public class QuickSortActivity extends AlgorithmActivity {
    @Override
    public void sort(int[] arr) {
        quickSort(arr,0,arr.length - 1);
    }

    private void quickSort(int[]arr, int start, int end){
        if(arr == null||arr.length == 0){
            return;
        }
        if(start >= end){
            return;
        }
        int base = arr[start];
        int i = start;
        int j = end;
        while(i!=j){
            while(arr[j]<=base && i<j){
                j--;
            }
            while(arr[i]>=base && i<j){
                i++;
            }
            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                printArr(arr);
            }
        }

        arr[start] = arr[i];
        arr[i] = base;
        printArr(arr);
        quickSort(arr,start,i-1);//左边
        quickSort(arr,i+1,end);//右边
    }
}
