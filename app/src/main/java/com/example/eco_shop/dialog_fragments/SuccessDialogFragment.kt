package com.example.eco_shop.dialog_fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.eco_shop.R

class SuccessDialogFragment: DialogFragment() {

    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.success_dialog_fragment, container, false)

        saveButton = rootView.findViewById(R.id.success_dialog_ok)

        saveButton.setOnClickListener {
            dismiss()
            requireActivity().finish()
        }

        return rootView
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        requireActivity().finish()
    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().finish()
    }

}