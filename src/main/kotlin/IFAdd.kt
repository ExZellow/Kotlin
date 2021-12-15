interface IFAdd<T> where T:Entity {
    fun add(entity: T, list: MutableList<TariffPlan>)
}