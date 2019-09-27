package craicoverflow89.romannumerals

fun main(args: Array<String>) {

    // Test: Int to Numerals
    val inputInt = 1984
    println("int = $inputInt")
    println(RomanNumerals.parseInt(inputInt))
    // NOTE: missing logic for when 19xx should be MCM (currently results in MDCCCC)

    // Test: Numerals to Int
    //val inputNumerals = "MMMCDXXLV"
    //println("RomanNumerals = $inputNumerals")
    //println(RomanNumerals.parseNumeral(inputNumerals))

}