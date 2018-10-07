package zup.pocandroid.util

import android.databinding.BindingAdapter
import android.graphics.drawable.PictureDrawable
import android.support.annotation.DrawableRes

import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    Glide.with(this.context)
            .load(imageUrl)
            .into(this)
}

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}

@BindingAdapter("visible")
fun View.setVisible(show: Boolean) {
    visibility = if (show) VISIBLE else INVISIBLE
}

@BindingAdapter("backgroundDrawableRes")
fun View.setBackgroundDrawableResource(@DrawableRes resource: Int) {
    this.setBackgroundResource(resource)
}