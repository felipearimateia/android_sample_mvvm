package info.arimateia.androidmvm.view;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by felipearimateia on 7/19/16.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private Context context;
    private List<T> items;

    public BaseAdapter(Context context, Collection<T> items) {
        this.context = context;
        this.items = new ArrayList<T>(items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int position) {
        return items.get(position);
    }

    private int getPosition(final T item) {
        return items.indexOf(item);
    }

    public void addAll(final Collection<T> objects) {
        items.addAll(objects);
        notifyDataSetChanged();
    }

    public void add(final T object) {
        if (contains(object)) {
            int index = getPosition(object);
            items.add(index, object);
            notifyItemChanged(index);
        }else {
            items.add(object);
            notifyItemInserted(getItemCount() - 1);
        }
    }

    public void insert(final T object, int index) {
        items.add(index, object);
        notifyItemInserted(index);
    }

    public void set(@Nullable Collection<T> items) {

        if (this.items == items) {
            notifyDataSetChanged();
            return;
        }

        if (this.items != null) {
            notifyItemRangeRemoved(0, this.items.size());
        }

        if (items instanceof ObservableList) {
            this.items = (ObservableList<T>) items;
            notifyItemRangeInserted(0, this.items.size());

        } else if (items != null) {
            this.items = new ObservableArrayList<>();
            this.items.addAll(items);

        } else  {
            this.items = null;
        }
    }

    public void remove(int possition) {
        items.remove(possition);
    }

    public void remove(T item) {
        final int position = getPosition(item);
        items.remove(item);
        notifyItemRemoved(position);
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    private boolean contains(T item) {
        return items.contains(item);
    }

    public Context getContext() {
        return context;
    }

    public List<T> getItems() {
        return items;
    }
}