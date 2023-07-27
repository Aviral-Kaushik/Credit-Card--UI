package com.aviral.creditcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final ArrayList<ContactDomain> contactDomainArrayList;

    public ContactAdapter(ArrayList<ContactDomain> contactDomainArrayList) {
        this.contactDomainArrayList = contactDomainArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_snippet_recycler_view,
                parent, false
        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(contactDomainArrayList.get(position).getName());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(
                contactDomainArrayList.get(position).getPicAddress(),
                "drawable",
                holder.itemView.getContext().getPackageName()
        );

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return contactDomainArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pic;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pic = itemView.findViewById(R.id.user_image);
            title = itemView.findViewById(R.id.user_name);
        }
    }

}
