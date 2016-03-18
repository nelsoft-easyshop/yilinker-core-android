package com.yilinker.core.v2.interfaces;

/**
 * Created by Adur Urbano on 3/18/2016.
 */
public interface RecyclerViewClickListener<T> {

    /**
     * Use this interface every time you click an item on recyclerView
     * @param position
     * @param object
     */
    void onItemClick(int position, T object);

}
