package woowacourse.movie.advertisement

import woowacourse.movie.advertisement.Advertisement.Companion.CYCLE

object AdvertisementPolicy {

    fun <T> mergeAdvertisement(data: List<T>, ads: List<T>): List<T> {
        val newList = mutableListOf<T>()
        var adsIndex = 0
        data.forEachIndexed { index, it ->
            newList.add(it)
            if ((index % CYCLE) == (CYCLE - 1)) {
                if (adsIndex == ads.size) adsIndex = 0
                newList.add(ads[adsIndex])
                adsIndex++
            }
        }
        return newList
    }
}