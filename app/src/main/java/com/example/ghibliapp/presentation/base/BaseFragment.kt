package com.example.ghibliapp.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupRequests()
        setupObserves()
        setupSubscribe()
    }

    protected open fun initialize() {
    }

    protected open fun setupListeners() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupObserves() {
    }

    protected open fun setupSubscribe() {
    }

}