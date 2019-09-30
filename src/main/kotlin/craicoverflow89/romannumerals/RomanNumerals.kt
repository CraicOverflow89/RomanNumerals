package craicoverflow89.romannumerals

class RomanNumerals {

    companion object {

        /**
         * Creates a Roman Numeral representation of an integer
         *
         * @param input the integer to convert
         * @return string representation
         * @throws IllegalArgumentException if input is not a positive integer
         */
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

        /**
         * Determines an integer from a Roman Numeral representation
         *
         * @param input the string to convert
         * @return integer result
         * @throws IllegalArgumentException if input contains invalid tokens or structures
         */
        fun parseNumeral(input: String): Int {

            // Validate Tokens
            requireNotNull("^[MDCLXVI]+\$".toRegex().find(input)) {"Input char string contains an invalid token!"}

            // Validate Structure
            listOf("CM+C", "[XVI]+D").forEach {
                require(it.toRegex().find(input) == null) {"Input char string contains an invalid structure!"}
            }
            // NOTE: could improve Regex to check stuff like C not appearing before and after M and suchlike
            // NOTE: could improve Regex to check stuff like D not appearing after CLXVI or before M and suchlike

            // Handle Thousands
            // NOTE: if C+M+ then M * 1000 - C * 100
            //       else if M+C+ then M * 1000 + C * 100
            //       else M+ then M * 1000
            //       also need to do the same with D

            // TEMP
            return 0
        }

    }

}