package woowacourse.movie

import woowacourse.movie.ticket.Position
import woowacourse.movie.ticket.Seat
import woowacourse.movie.ticket.SeatRank

data class Theater(
    val id: Long,
    val rowSize: Int,
    val columnSize: Int,
    val sRankRange: List<IntRange>,
    val aRankRange: List<IntRange>,
    val bRankRange: List<IntRange>,
) {
    private val rankMap: Map<SeatRank, List<IntRange>>
        get() = mapOf(
            SeatRank.S to sRankRange,
            SeatRank.A to aRankRange,
            SeatRank.B to bRankRange,
        )

    fun selectSeat(position: Position): Seat {
        return Seat(getSeatRank(position.row), position)
    }

    private fun getSeatRank(row: Int): SeatRank {
        rankMap.entries.forEach { return it.matchedKey(row) }
        throw IllegalArgumentException()
    }

    private fun Map.Entry<SeatRank, List<IntRange>>.matchedKey(row: Int): SeatRank {
        if (value.any { range -> row in range }) {
            return key
        }
        throw IllegalArgumentException()
    }
}
