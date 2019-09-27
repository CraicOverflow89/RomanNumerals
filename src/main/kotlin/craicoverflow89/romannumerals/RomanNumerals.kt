package craicoverflow89.romannumerals

class RomanNumerals {

    companion object {

        fun parseInt(input: Int): String = StringBuffer().apply {

            // Define Remainder
            var remainder = input

            // Handle Thousands
            append("M".repeat((
                if(remainder >= 1000) {
                    (remainder / 1000).apply {
                        remainder -= this * 1000
                    }
                }
                else 0
            )))

            // Handle Hundreds
            (
                if(remainder >= 100) {
                    (remainder / 100).apply {
                        remainder -= this * 100
                    }
                }
                else 0
            ).let {

                // Remainder 100
                var resultC = it

                // Prepend 500
                var prependD = if(it >= 5) {
                    val result = resultC / 5
                    resultC -= result * 5
                    result
                } else 0

                // Append Chars
                append("D".repeat(prependD))
                append("C".repeat(resultC))
            }

            // Handle Tens
            (
                if(remainder >= 10) {
                    val result = remainder / 10
                    remainder -= result * 10
                    result
                }
                else 0
            ).let {

                // Remainder 10
                var resultX = it

                // Prepend 50
                var prependL = if(it >= 5) {
                    val result = resultX / 5
                    resultX -= result * 5
                    result
                } else 0

                // Append Chars
                append("L".repeat(prependL))
                append("X".repeat(resultX))
            }

            // Handle Remainder
            append(when(remainder) {
                9 -> "IX"
                8 -> "VIII"
                7 -> "VII"
                6 -> "VI"
                5 -> "V"
                4 -> "IV"
                3 -> "III"
                2 -> "II"
                1 -> "I"
                else -> ""
            })

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