package woowacourse.movie.ui.main.adapter

import android.content.Intent
import android.view.View
import android.widget.ImageView
import woowacourse.movie.R
import woowacourse.movie.model.main.AdvertisementUiModel
import woowacourse.movie.model.main.MainData
import woowacourse.movie.model.main.MainViewType

class AdvertisementViewHolder(view: View) : MainViewHolder(view) {
    private val poster: ImageView = view.findViewById(R.id.imageAdvertisement)

    override val mainViewType: MainViewType = MainViewType.ADVERTISEMENT
    private lateinit var advertisement: AdvertisementUiModel

    override fun onBind(data: MainData) {
        advertisement = data as AdvertisementUiModel
        poster.setImageResource(advertisement.image)
    }

    fun clickAdvertisement(clickAd: (Intent) -> Unit) {
        view.setOnClickListener {
            clickAd(advertisement.getIntent())
        }
    }
}
