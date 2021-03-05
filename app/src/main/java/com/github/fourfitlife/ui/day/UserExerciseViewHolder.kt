package com.github.fourfitlife.ui.day

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.github.fourfitlife.R
import com.github.fourfitlife.databinding.UserExerciseItemBinding

class UserExerciseViewHolder(val viewDataBinding: UserExerciseItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.user_exercise_item
        }
}
