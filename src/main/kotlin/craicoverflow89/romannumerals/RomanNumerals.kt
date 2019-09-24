package craicoverflow89.romannumerals

class RomanNumerals {

    companion object {

        fun parseInt(value: Int): String = StringBuffer().apply {

            // Define Remainder
            var remainder = value

            // Handle Thousands
            (
                if(value >= 1000) {
                    val result = remainder / 1000
                    remainder -= result * 1000
                    result
                }
                else 0
            ).let {

                // Remainder 1000
                var resultM = it
                println("M result is $it")

                // Prepend 1000
                var prependD = if(it >= 5) {
                    val result = resultM / 5
                    resultM -= result * 5
                    result
                } else 0

                // Append Chars
                append("D".repeat(prependD))
                append("M".repeat(resultM))
                val appendD = 0
                append("D".repeat(appendD))
            }

            // Handle Hundreds
            (
                if(value >= 100) {
                    val result = remainder / 100
                    remainder -= result * 100
                    result
                }
                else 0
            ).let {

                // Remainder 100
                var resultC = it
                println("C result is $it")

                // Prepend 100
                var prependL = if(it >= 5) {
                    val result = resultC / 5
                    resultC -= result * 5
                    result
                } else 0

                // Append Chars
                append("L".repeat(prependL))
                append("C".repeat(resultC))
                val appendL = 0
                append("L".repeat(appendL))
            }

            // Handle Tens
            (
                if(value >= 10) {
                    val result = remainder / 10
                    remainder -= result * 10
                    result
                }
                else 0
            ).let {

                // Remainder 10
                var resultX = it
                println("X result is $it")

                // Prepend 10
                var prependV = if(it >= 5) {
                    val result = resultX / 5
                    resultX -= result * 5
                    result
                } else 0

                // Append Chars
                append("V".repeat(prependV))
                append("X".repeat(resultX))
                val appendV = 0
                append("V".repeat(appendV))
            }

            // Handle Remainder
            remainder.let {
                println("I result is $it")
                append("I".repeat(it))
            }
            // NOTE: need to take count into account here and turn multiple I..?

        }.toString()

    }

    fun parseNumeral(input: String) = 0

}