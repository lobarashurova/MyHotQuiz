package uz.mlsoft.myhotquiz.presentation.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import uz.mlsoft.myhotquiz.databinding.DialogFinishBinding;

public class FinishDialog extends DialogFragment {
    private DialogFinishBinding binding;
    private Runnable finishListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogFinishBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.finishBtn.setOnClickListener(v -> {
            if (finishListener != null) {
                finishListener.run();
            }
        });

        binding.cancelBtn.setOnClickListener(v -> {
            if (getDialog() != null) {
                getDialog().dismiss();
            }
        });
    }

    public void setFinishListener(Runnable block) {
        this.finishListener = block;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            getDialog().setCancelable(false);
        }
    }
}