fun main() {
    val number1 = readln().toUInt()
    val number2 = readln().toUInt()
    val number3 = readln().toUInt()

    val class1 = number1 / 2u + number1 % 2u
    val class2 = number2 / 2u + number2 % 2u
    val class3 = number3 / 2u + number3 % 2u

    val sum = class1 + class2 + class3

    println(sum)
}
