package wu.seal.jsontokotlin.interceptor

import wu.seal.jsontokotlin.classscodestruct.KotlinDataClass
import wu.seal.jsontokotlin.utils.KOTLIN_KEYWORD_LIST

/**
 * Interceptor to make kotlin keyword property names valid
 */
class FinalKotlinDataClassWrapperInterceptor : IKotlinDataClassInterceptor {

    override fun intercept(kotlinDataClass: KotlinDataClass): KotlinDataClass {

        val keywordValidProperties = kotlinDataClass.properties.map {
            it.copy(name = with(it.name) {
                if (isNotEmpty() && (KOTLIN_KEYWORD_LIST.contains(this) || first().isDigit() || contains('$'))) "`$this`" else this
            })
        }
        return kotlinDataClass.copy(properties = keywordValidProperties)
    }
}
