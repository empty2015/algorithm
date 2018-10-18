package empty.github.com.algorithm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created at 10/18/18
 *
 * @author Empty
 */
public abstract class AlgorithmActivity extends Activity {
    EditText editText;
    ScrollView scrollView;
    LinearLayout container;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        editText = findViewById(R.id.edit);
        scrollView = findViewById(R.id.scrollView);
        container = findViewById(R.id.container);
        findViewById(R.id.btn_quick_sort).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = editText.getText().toString();
                int[] arr = getInputNumbers(inputStr);
                if(arr == null || arr.length == 0){
                    Toast.makeText(AlgorithmActivity.this,"输入内容有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                container.removeAllViews();
                sort(arr);
            }
        });
    }

    private int[] getInputNumbers(String inputStr){
        if(TextUtils.isEmpty(inputStr)){
            return null;
        }
        if(inputStr.contains(" ")){
            inputStr = inputStr.replaceAll(" ",",");
        }
        if(inputStr.contains("，")){
            inputStr = inputStr.replaceAll("，",",");
        }
        String[] buf = inputStr.split(",");
        int[] arr = new int[buf.length];
        for(int i=0;i<buf.length;i++){
            try {
                arr[i] = Integer.parseInt(buf[i]);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        return arr;
    }

    public abstract void sort(int[] arr);

    protected void printArr(int[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            stringBuilder.append(arr[i]);
            stringBuilder.append(",");
        }
        Log.e("sort==========>",stringBuilder.toString());
        TextView textView = new TextView(this);
        textView.setText(stringBuilder.toString());
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        container.addView(textView);
    }
}
