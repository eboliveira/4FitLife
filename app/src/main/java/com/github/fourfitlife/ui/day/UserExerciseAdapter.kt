package com.github.fourfitlife.ui.day

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.fourfitlife.data.models.UserExercise
import com.github.fourfitlife.databinding.UserExerciseItemBinding

class UserExerciseAdapter : RecyclerView.Adapter<UserExerciseViewHolder>() {
    var userExercises = emptyList<UserExercise>()
        set(value) {
            field = value

            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserExerciseViewHolder {
        val withDataBinding: UserExerciseItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            UserExerciseViewHolder.LAYOUT,
            parent,
            false)
        return UserExerciseViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: UserExerciseViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.userExercise = userExercises[position]
        }
    }

    override fun getItemCount(): Int = userExercises.size
}
