class Input: IFInput {
    override fun input(msg: String): String {
        println(msg)
        return readLine() ?: "Некорректное значение!"
    }
}