import java.util.*

interface IFDelete<T> where T: Entity {
    fun delete(id: UUID, list:MutableList<T>)
}