import java.util.*

class Context {
    private val tariffPlan = TariffPlans(AddTariffPlan(), EditTariffPlan(), DeleteTariffPlan(), TariffPlanOutput())
    fun getPlans() = tariffPlan

    init {
        tariffPlan.add(TariffPlan("kek", BroadcastType.BROADCAST_DEFAULT, false))
        tariffPlan.add(TariffPlan("kek1", BroadcastType.BROADCAST_HD, false))
        tariffPlan.add(TariffPlan("kek2", BroadcastType.BROADCAST_DEFAULT, true))
        tariffPlan.add(TariffPlan("kek3", BroadcastType.BROADCAST_HD, false))
        tariffPlan.add(TariffPlan("kek4", BroadcastType.BROADCAST_DEFAULT, true))
        tariffPlan.add(TariffPlan("kek5", BroadcastType.BROADCAST_HD, true))
    }
}