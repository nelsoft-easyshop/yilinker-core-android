package com.yilinker.core.v2.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yilinker.core.v2.interfaces.RecyclerViewClickListener;

/**
 * Created by J.Bautista on 1/14/2016.
 */
public abstract class BaseViewHolder2<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private RecyclerViewClickListener<T> listener;
    private T object;

    public BaseViewHolder2(View view){
        super(view);


    }

    public BaseViewHolder2(View view, RecyclerViewClickListener<T> listener){
        super(view);


        if (listener != null) {

            this.listener = listener;
            view.setOnClickListener(this);

        }

    }


    @Override
    public void onClick(View v) {

        this.listener.onItemClick(getAdapterPosition(), object);

    }

    public void onBindModel(T object){

        this.object = object;
        onBind();
    }

    protected T getObject(){

        return this.object;
    }

    /**
     * Binds an object with the ViewHolder
     */
    protected abstract void onBind();

}
