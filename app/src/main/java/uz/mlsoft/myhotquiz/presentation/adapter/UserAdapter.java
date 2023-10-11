package uz.mlsoft.myhotquiz.presentation.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import uz.mlsoft.myhotquiz.data.room.UserEntity;
import uz.mlsoft.myhotquiz.databinding.ItemUserBinding;

public class UserAdapter extends ListAdapter<UserEntity, UserAdapter.UserViewHolder> {
    private ItemUserBinding binding2;

    public UserAdapter() {
        super(UserAdapter.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        public UserViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            binding2 = binding;
        }

        public void bind() {
            Log.d("TTT", "" + getItem(getAdapterPosition()).getCorrectAnswer());
            binding2.userName.setText(getItem(getAdapterPosition()).getName());
            binding2.correctCount.setText(String.valueOf(getItem(getAdapterPosition()).getCorrectAnswer()));
            binding2.subjectName.setText(getItem(getAdapterPosition()).getSubject_name());
            binding2.userImage.setImageResource(getItem(getAdapterPosition()).getImage());
            binding2.incorrectCount.setText(String.valueOf(20 - (getItem(getAdapterPosition()).getCorrectAnswer())));
        }
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind();
    }

    public static final DiffUtil.ItemCallback<UserEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<UserEntity>() {
        @Override
        public boolean areItemsTheSame(@NonNull UserEntity oldUserEntity, @NonNull UserEntity newUserEntity) {
            return oldUserEntity.getId() == newUserEntity.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull UserEntity oldItem, @NonNull UserEntity newItem) {
            return oldItem.equals(newItem);
        }
    };
}
