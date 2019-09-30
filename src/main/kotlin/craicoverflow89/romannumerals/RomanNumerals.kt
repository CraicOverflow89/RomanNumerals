package craicoverflow89.romannumerals

class RomanNumerals {

    companion object {

        fun parseInt(input: Int): String = StringBuffer().apply {

            // Validate Input
            require(input >= 0) {"The input parameter must be a positive integer!"}

            // Split Digits
            input.toString().toList().reversed().let {

                // Ones
                val resultI = if(it.isNotEmpty()) it[0].toString().toInt() else 0

                // Tens
                val resultX = if(it.size > 1) it[1].toString().toInt() else 0

                // Hundreds
                val resultC = if(it.size > 2) it[2].toString().toInt() else 0

                // Thousands
                val resultM = if(it.size > 3) it.subList(3, it.size).reversed().joinToString("").toInt() else 0

                // Create Result
                append("M".repeat(resultM))
                with(fun(result: Int, a: Char, b: Char, c: Char) {
                    append(when(result) {
                        9 -> "$a$c"
                        8 -> "$b$a$a$a"
                        7 -> "$b$a$a"
                        6 -> "$b$a"
                        5 -> b
                        4 -> "$a$b"
                        3 -> "$a$a$a"
                        2 -> "$a$a"
                        1 -> a
                        else -> ""
                    })
                }) {
                    this(resultC, 'C', 'D', 'M')
                    this(resultX, 'X', 'L', 'C')
                    this(resultI, 'I', 'V', 'X')
                }
            }

        }.toString()

    }

    fun parseNumeral(input: String): Int {

        // Validate Tokens
        if("^[MDCLXVI]+\$".toRegex().find(input) == null) throw Exception("Input char string is invalid!")
        // NOTE: could improve Regex to check stuff like D not appearing after CLXVI and suchlike

        // TEMP
        return 0
    }

}