package info.arimateia.androidmvm.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by felipearimateia on 7/19/16.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private Context context;
    private List<T> itens;

    public BaseAdapter(Context context, List<T> itens) {
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public T getItem(int position) {
        return itens.get(position);
    }

    private int getPosition(final T item) {
        return itens.indexOf(item);
    }

    public void addAll(final List<T> objects) {
        itens.addAll(objects);
        notifyDataSetChanged();
    }

    public void add(final T object) {
        if (contains(object)) {
            int index = getPosition(object);
            itens.add(index, object);
            notifyItemChanged(index);
        }else {
            itens.add(object);
            notifyItemInserted(getItemCount() - 1);
        }
    }

    public void insert(final T object, int index) {
        itens.add(index, object);
        notifyItemInserted(index);
    }

    public void remove(int possition) {
        itens.remove(possition);
    }

    public void remove(T item) {
        final int position = getPosition(item);
        itens.remove(item);
        notifyItemRemoved(position);
    }

    public void clear() {
        itens.clear();
        notifyDataSetChanged();
    }

    private boolean contains(T item) {
        return itens.contains(item);
    }

    public Context getContext() {
        return context;
    }

    public List<T> getItens() {
        return itens;
    }
}