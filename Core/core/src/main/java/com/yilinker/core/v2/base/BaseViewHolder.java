package com.yilinker.core.v2.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yilinker.core.v2.interfaces.RecyclerViewClickListener;

/**
 * Created by Adur Urbano on 1/14/2016.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private RecyclerViewClickListener<T> listener;

    public BaseViewHolder(View view){
        super(view);

        view.setOnClickListener(this);

    }

    public BaseViewHolder(View view, RecyclerViewClickListener<T> listener){
        super(view);

        if (listener != null) {

            this.listener = listener;
            view.setOnClickListener(this);

        }

    }


    @Override
    public void onClick(View v) {

        this.listener.onItemClick(getAdapterPosition(), getObject());

    }

    /**
     * Gets object that will be passed on onItemClick
     * @return generic object
     */
    public abstract T getObject();

    /**
     * Binds an object with the ViewHolder
     * @param object
     */
    public abstract void setViews(T object);

}
