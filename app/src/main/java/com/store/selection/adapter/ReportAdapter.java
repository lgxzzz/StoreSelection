package com.store.selection.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.store.selection.R;
import com.store.selection.ReportDescribeActivity;
import com.store.selection.StoreDescribeActivity;
import com.store.selection.bean.Evaluate;
import com.store.selection.bean.Report;
import com.store.selection.data.DBManger;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends BaseAdapter {

    Context mContext;
    List<Report> mReports = new ArrayList<>();

    private OnShowItemClickListener onShowItemClickListener;

    boolean isSelect = false;

    public ReportAdapter(Context mContext, List<Report> mReports){
        this.mContext = mContext;
        this.mReports = mReports;
    }

    public void setSelect(boolean select) {
        isSelect = select;
        notifyDataSetChanged();
    }

    public boolean isSelect() {
        return isSelect;
    }

    @Override
    public int getCount() {
        return mReports.size();
    }

    @Override
    public Object getItem(int i) {
        return mReports.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Report report = mReports.get(i);
        ReportAdapter.ViewHoler holer = null;
        if (view == null){
            holer = new ReportAdapter.ViewHoler();
            view = LayoutInflater.from(mContext).inflate(R.layout.report_item,null);
            holer.mVillageNameTv = (TextView) view.findViewById(R.id.village_name);
            holer.mReportFinalTv = (TextView) view.findViewById(R.id.report_final_tv);
            holer.mStoreInfoTv = (TextView) view.findViewById(R.id.store_name);
            holer.mReportTimeTv = (TextView) view.findViewById(R.id.report_time_tv);
            holer.mDeleteBtn = (Button) view.findViewById(R.id.report_delete_btn);
            holer.mSelectCB = (CheckBox) view.findViewById(R.id.report_select_cb);
            view.setTag(holer);
        }else{
            holer = (ReportAdapter.ViewHoler) view.getTag();
        }
        holer.mVillageNameTv.setText(report.getVillage().getVillage_Name());
        holer.mReportFinalTv.setText(report.getFinal());
        holer.mStoreInfoTv.setText(report.getStoreInfo());
        holer.mReportTimeTv.setText(report.getReport_Time());
        holer.mDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"删除成功",Toast.LENGTH_LONG).show();
                DBManger.getInstance(mContext).deleteReport(report);
                mReports.remove(report);
                notifyDataSetChanged();
            }
        });
        if (isSelect){
            holer.mSelectCB.setVisibility(View.VISIBLE);
            holer.mDeleteBtn.setVisibility(View.GONE);
        }else {
            holer.mSelectCB.setVisibility(View.GONE);
            holer.mDeleteBtn.setVisibility(View.VISIBLE);
        }
        holer.mSelectCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 回调方法，将Item加入已选
                if (onShowItemClickListener!=null)
                onShowItemClickListener.onShowItemClick(report);
            }
        });



//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(mContext, ReportDescribeActivity.class);
//                Bundle b = new Bundle();
//                b.putSerializable("report",report);
//                intent.putExtras(b);
//                mContext.startActivity(intent);
//            }
//        });
        return view;
    }

    public interface OnShowItemClickListener {
        public void onShowItemClick(Report bean);
    }

    public void setOnShowItemClickListener(OnShowItemClickListener onShowItemClickListener) {
        this.onShowItemClickListener = onShowItemClickListener;
    }

    class ViewHoler{
        TextView mVillageNameTv;
        TextView mReportFinalTv;
        TextView mStoreInfoTv;
        TextView mReportTimeTv;
        Button mDeleteBtn;
        CheckBox mSelectCB;
    }
}
