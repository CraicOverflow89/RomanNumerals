package craicoverflow89.romannumerals

import java.lang.IllegalArgumentException
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test

class RomanNumeralsTest {

    @Test
    fun parseInt1() = with(fun(input: Int, expected: String) {
        Assert.assertEquals(expected, RomanNumerals.parseInt(input))
    }) {
        this(0, "")
        this(7, "VII")
        this(9, "IX")
        this(10, "X")
        this(13, "XIII")
        this(22, "XXII")
        this(29, "XXIX")
        this(41, "XLI")
        this(58, "LVIII")
        this(69, "LXIX")
        this(84, "LXXXIV")
        this(117, "CXVII")
        this(496, "CDXCVI")
        this(859, "DCCCLIX")
        this(1301, "MCCCI")
        this(1989, "MCMLXXXIX")
    }

    @Test(expected = IllegalArgumentException::class)
    fun parseInt2() {
        RomanNumerals.parseInt(-1)
    }

}