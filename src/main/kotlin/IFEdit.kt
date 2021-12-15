import java.util.*

interface IFEdit<T>where T: Entity {
    fun edit(id: UUID, toEdit:T, list:MutableList<T>)
}