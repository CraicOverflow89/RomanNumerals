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

    @Test
    fun parseNumeral1() = with(fun(input: String, expected: Int) {
        Assert.assertEquals(expected, RomanNumerals.parseNumeral(input))
    }) {
        this("", 0)
        this("VII", 7)
        this("IX", 9)
        this("X", 10)
        this("XIII", 13)
        this("XXII", 22)
        this("XXIX", 29)
        this("XLI", 41)
        this("LVIII", 58)
        this("LXIX", 69)
        this("LXXXIV", 84)
        this("CXVII", 117)
        this("CDXCVI", 496)
        this("DCCCLIX", 859)
        this("MCCCI", 1301)
        this("MCMLXXXIX", 1989)
    }

    @Test(expected = IllegalArgumentException::class)
    fun parseNumeral2() {
        RomanNumerals.parseNumeral("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun parseNumeral3() {
        RomanNumerals.parseNumeral("A")
    }

    @Test(expected = IllegalArgumentException::class)
    fun parseNumeral4() {
        RomanNumerals.parseNumeral("CMC")
    }

}