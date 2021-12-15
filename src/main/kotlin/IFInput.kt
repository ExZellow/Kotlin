interface IFInput<T>where T: Entity {
    fun input(msg: String): String
}