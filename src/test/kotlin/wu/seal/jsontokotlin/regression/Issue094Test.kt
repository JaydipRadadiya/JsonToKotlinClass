package wu.seal.jsontokotlin.regression

import com.winterbe.expekt.should
import org.junit.Test
import wu.seal.jsontokotlin.KotlinDataClassCodeMaker
import wu.seal.jsontokotlin.KotlinDataClassMaker
import wu.seal.jsontokotlin.test.TestConfig

/**
 * Created by kezhenxu at 2018/12/30 11:45
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
class Issue094Test {
    private val testJson = """
    { "test": {} }
    """.trimIndent()
    private val expected = """data class A(
    @SerializedName("test")
    val test: Test = Test()
) {
    class Test(
    )
}"""

    @Test
    fun testIssue094() {
        TestConfig.setToTestInitState()
        val generated = KotlinDataClassCodeMaker(KotlinDataClassMaker("A", testJson).makeKotlinDataClass()).makeKotlinDataClassCode()
        generated.should.be.equal(expected)
    }
}
