import java.util.*

enum class BroadcastType {
    BROADCAST_DEFAULT,
    BROADCAST_HD
}

data class TariffPlan(
    private var name: String,
    private var broadcastType: BroadcastType,
    private var publicity: Boolean
    ) : Entity() {
    fun getName() = name
    private fun setName(newName: String) {
        name = newName
    }
    fun getBroadcastType() = broadcastType
    private fun setBroadcastType(broadCastNew: BroadcastType) {
        broadcastType = broadCastNew
    }
    fun getPublicity() = publicity
    private fun setPublicity(publicityNew: Boolean) {
        publicity = publicityNew
    }
    fun setFromOther(other: TariffPlan)
    {
        setName(other.name)
        setPublicity(other.publicity)
        setBroadcastType(other.broadcastType)
    }
}


class EditTariffPlan : IFEdit<TariffPlan>
{
    override fun edit(id: UUID, toEdit: TariffPlan, list: MutableList<TariffPlan>) {
        list.find { it.ID == id }?.setFromOther(toEdit)
    }

}

class AddTariffPlan : IFAdd<TariffPlan>
{
    override fun add(entity: TariffPlan, list: MutableList<TariffPlan>) {
        list.add(entity)
    }
}

class DeleteTariffPlan : IFDelete<TariffPlan>
{
    override fun delete(id: UUID, list: MutableList<TariffPlan>) {
        list.removeIf { it.ID == id }
    }
}

abstract class TariffPlanListHolder {
    var list: MutableList<TariffPlan> = mutableListOf()
}

class TariffPlans(add:IFAdd<TariffPlan>, edit:IFEdit<TariffPlan>, delete:IFDelete<TariffPlan>, output:IFOutput<TariffPlan>): TariffPlanListHolder() {
    var add = { obj: TariffPlan -> add.add(obj, list) }
    var edit = { id: UUID, toEdit: TariffPlan -> edit.edit(id, toEdit, list) }
    var delete = { id: UUID ->
        delete.delete(id, list)
    }
    var output = {output.output(list)}
}
class TariffPlanOutput : IFOutput<TariffPlan> {
    override fun output(list: MutableList<TariffPlan>) {
        for (i in list) {
            println("${i.getName()} with broadcastType: ${i.getBroadcastType()} and publicity: ${i.getPublicity()}")
        }
    }
}