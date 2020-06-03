//package com.odin.analysis.demo.ui.dialog;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.widget.Button;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//
//import com.odin.analysis.demo.Constant;
//import com.odin.analysis.demo.R;
//import com.odin.analysis.demo.data.ErrorCategory;
//import com.odin.analysis.demo.data.ErrorType;
//import com.odin.analysis.demo.data.EventShowData;
//import com.odin.analysis.demo.data.InfoItem;
//import com.odin.analysis.demo.utils.EventApi;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ErrorEventDialog extends Dialog {
//
//    public ErrorEventDialog(@NonNull Context context) {
//        super(context, R.style.AppDialog);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_error_event);
//
//        ImageView mImgClose = findViewById(R.id.img_dialog_close);
//        mImgClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//
//        Button mBtnEnsure = findViewById(R.id.btn_dialog_ensure);
//        mBtnEnsure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String event_code = Constant.EVENT.EVENT_CODE_ERROR;
//                String title = "App异常";
//                String content = "";
//
//                ErrorCategory errorCategory = ErrorCategory.ERROR_DEFAULT;
//                ErrorType errorType = ErrorType.ERROR_TYPE_OTHER;
//                try {
//                    int num = Integer.parseInt("1001abc");
//                } catch (Exception e) {
//                    content = e.getMessage();
//                    errorCategory = ErrorCategory.ERROR_OTHERS;
//                    errorType = ErrorType.ERROR_TYPE_DATA_FORMAT;
//                }
//                EventApi.sendErrorEvent(event_code, title, content, ErrorCategory.getCategory(errorCategory), ErrorType.getType(errorType));
//                showEventInfo(event_code, title, content, ErrorCategory.getMsg(errorCategory), ErrorType.getMsg(errorType));
//                dismiss();
//            }
//        });
//
//        Window window = getWindow();
//        if (window != null) {
//            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//    }
//
//    private void showEventInfo(String event_code, String title, String content, String category, String type) {
//        EventShowData eventShowData = new EventShowData();
//        List<InfoItem> infoItemList = new ArrayList<>();
//        infoItemList.add(new InfoItem("事件code：", event_code));
//        infoItemList.add(new InfoItem("错误标题：", title));
//        infoItemList.add(new InfoItem("错误内容：", content));
//        infoItemList.add(new InfoItem("错误类别：", category));
//        infoItemList.add(new InfoItem("错误类型：", type));
//        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_ERROR);
//        eventShowData.setInfoItemList(infoItemList);
//
//        EventDialog eventDialog = new EventDialog(getContext(), eventShowData);
//        eventDialog.show();
//    }
//}
