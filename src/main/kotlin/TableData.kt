enum class BroadcastType {
    BROADCAST_DEFAULT,
    BROADCAST_HD
}

data class TariffPlanDataRow(
    private var name: String,
    private var broadcastType: BroadcastType,
    private var publicity: Boolean
    )

class TableData