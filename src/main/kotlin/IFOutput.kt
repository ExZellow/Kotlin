interface IFOutput<T>where T: Entity {
    fun output(list:MutableList<T>)
}