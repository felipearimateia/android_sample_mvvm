package info.arimateia.androidmvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.List;

import info.arimateia.androidmvm.R;
import info.arimateia.androidmvm.viewmodel.PersonViewModel;
import info.arimateia.androidmvm.databinding.ItemPersonBinding;

/**
 * Created by felipets on 8/23/16.
 */

public class PeopleAdapter extends BaseAdapter<PersonViewModel, PeopleAdapter.ViewHoler> {


    private final LayoutInflater inflater;

    public PeopleAdapter(Context context, Collection<PersonViewModel> itens) {
        super(context, itens);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPersonBinding personBinding = DataBindingUtil.inflate(inflater,
                R.layout.item_person, parent, false);
        return new ViewHoler(personBinding);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        PersonViewModel viewModel = getItem(position);
        holder.personBinding.setViewModel(viewModel);
    }

    class ViewHoler extends RecyclerView.ViewHolder {

        ItemPersonBinding personBinding;

        public ViewHoler(ItemPersonBinding personBinding) {
            super(personBinding.getRoot());
            this.personBinding = personBinding;
        }
    }
}
