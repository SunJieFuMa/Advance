package com.newsdemo.ui.vtex.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsdemo.R;
import com.newsdemo.app.Constants;
import com.newsdemo.component.GlidUtils;
import com.newsdemo.model.bean.NodeBean;
import com.newsdemo.model.bean.NodeListBean;
import com.newsdemo.presenter.vtex.VtexPresenter;
import com.newsdemo.ui.vtex.activity.RepliesActivity;
import com.newsdemo.util.DateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jianqiang.hu on 2017/5/31.
 */

public class NodeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private LayoutInflater inflater;
    private List<NodeListBean> mList;
    private NodeBean mTopBean;

    public NodeListAdapter(Context context,List<NodeListBean> mList){
        mContext=context;
        this.mList=mList;
        inflater=LayoutInflater.from(mContext);
    }


    public enum ITEM_TYPE{
        ITEM_TOP,       //节点信息
        ITEM_CONTENT    //节点列表
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ITEM_TYPE.ITEM_TOP.ordinal();
        }
        return  ITEM_TYPE.ITEM_CONTENT.ordinal();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ITEM_TYPE.ITEM_TOP.ordinal()){
            return new TopViewHolder(inflater.inflate(R.layout.item_node_top,parent,false));
        }
        return new ViewHolder(inflater.inflate(R.layout.item_vtex,parent,false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
         if (holder instanceof TopViewHolder){
             TopViewHolder topHolder = (TopViewHolder) holder;
             if (mTopBean==null)
                 return;
             GlidUtils.load(mContext, VtexPresenter.parseImg(mTopBean.getavatar_normal()),topHolder.ivNodeFace);
             topHolder.tvNodeContent.setText(mTopBean.getHeader());
             topHolder.tvNodeTips.setText(String.format("%d个主题\n%d次收藏",mTopBean.getTopics(),mTopBean.getStars()));
             topHolder.tvNodeName.setText(mTopBean.getTitle());
         }else{
             ViewHolder contentHolder = (ViewHolder) holder;
             NodeListBean bean = mList.get(position-1);
             GlidUtils.load(mContext, VtexPresenter.parseImg(bean.getMember().getavatar_normal()), contentHolder.ivTopicFace);
             contentHolder.tvTopicName.setText(bean.getMember().getUsername());
             contentHolder.tvTopicTips.setText(DateUtil.formatTime2String(bean.getCreated()));
             contentHolder.tvTopicComment.setText(String.valueOf(bean.getReplies()));
             contentHolder.tvTopicTitle.setText(bean.getTitle());
             contentHolder.tvTopicNode.setText(bean.getNode().getTitle());

             contentHolder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent();
                     intent.setClass(mContext, RepliesActivity.class);
                     if (holder.getAdapterPosition() - 1 < 0 || mList.get(holder.getAdapterPosition() - 1) == null)
                         return;

                     intent.putExtra(Constants.IT_VTEX_TOPIC_ID, mList.get(holder.getAdapterPosition() - 1).getId());
                     intent.putExtra(Constants.IT_VTEX_REPLIES_TOP, mList.get(holder.getAdapterPosition() - 1));
                     mContext.startActivity(intent);
                 }
             });
         }
    }

    @Override
    public int getItemCount() {
        if (mTopBean==null){
            return mList.size();
        }
        return mList.size()+1;
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_node_face)
        ImageView ivNodeFace;

        @BindView(R.id.tv_node_name)
        TextView tvNodeName;

        @BindView(R.id.tv_nodes_tips)
        TextView tvNodeTips;

        @BindView(R.id.tv_node_content)
        TextView tvNodeContent;

        public TopViewHolder(View itemView) {
            super(itemView);
                ButterKnife.bind(this,itemView);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_topic_face)
        ImageView ivTopicFace;

        @BindView(R.id.tv_topic_name)
        TextView tvTopicName;

        @BindView(R.id.tv_topic_tips)
        TextView tvTopicTips;

        @BindView(R.id.tv_topic_comment)
        TextView tvTopicComment;

        @BindView(R.id.tv_topic_node)
        TextView tvTopicNode;

        @BindView(R.id.tv_topic_title)
        TextView tvTopicTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void setTopData(NodeBean mTopBean){
        this.mTopBean=mTopBean;
        notifyItemChanged(0);
    }

    public void setContentData(List<NodeListBean> mList){
        this.mList=mList;
        notifyDataSetChanged();
    }

}
