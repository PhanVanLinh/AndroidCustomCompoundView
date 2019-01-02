package com.example.toong.androidcustomagroupview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.content.res.AppCompatResources
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.custom_layout.view.*

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        View.inflate(context, R.layout.custom_layout, this)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        try {
            val text = ta.getString(R.styleable.CustomView_text)
            val drawableId = ta.getResourceId(R.styleable.CustomView_image, 0)
            if (drawableId != 0) {
                val drawable = AppCompatResources.getDrawable(context, drawableId)
                image_thumb.setImageDrawable(drawable)
            }
            text_title.text = text
        } finally {
            ta.recycle()
        }
    }
}
