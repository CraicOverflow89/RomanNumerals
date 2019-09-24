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
            )
            .let {
                println("M result is $it")
                append("M".repeat(it))
            }
            // NOTE: need to take count into account here and turn multiple M into [D]M[D] format

            // Handle Hundreds
            (
                if(value >= 100) {
                    val result = remainder / 100
                    remainder -= result * 100
                    result
                }
                else 0
            )
            .let {
                var resultC = it
                println("C result is $it")
                //append("C".repeat(it))

                // TEMP
                var prependD = if(it >= 5) {
                    val result = resultC / 5
                    resultC -= result * 5
                    result
                } else 0
                append("D".repeat(prependD))
                append("C".repeat(resultC))
                val appendD = 0
                append("D".repeat(appendD))
            }
            // NOTE: need to take count into account here and turn multiple C into [L]C[L] format

            // Handle Tens
            (
                if(value >= 10) {
                    val result = remainder / 10
                    remainder -= result * 10
                    result
                }
                else 0
            )
            .let {
                println("X result is $it")
                append("X".repeat(it))
            }
            // NOTE: need to take count into account here and turn multiple X into [V]X[V] format

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