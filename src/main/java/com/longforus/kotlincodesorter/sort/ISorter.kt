package com.longforus.kotlincodesorter.sort

import com.longforus.kotlincodesorter.sortstrategy.ISortStrategy
import org.jetbrains.kotlin.psi.KtClassOrObject

/**
 * @describe
 * @author  longforus
 * @date 2020/6/6  10:24
 */
interface ISorter {
    val mPsiClass: KtClassOrObject
    fun sort() {
        realSort(mPsiClass)
    }
    fun getStrategy(declarations: kotlin.collections.List<org.jetbrains.kotlin.psi.KtDeclaration>):ISortStrategy

    fun realSort(classOrObject: KtClassOrObject) {
        val declarations = classOrObject.declarations
        val before = declarations.hashCode()
        val sort = getStrategy(declarations).sort()
        val after = sort.hashCode()
        sort.forEach {
            if (it is KtClassOrObject) {
                realSort(it)
            }
        }
        if (before != after) {
            sort.forEach {
                classOrObject.addDeclaration(it)
            }
            declarations.forEach {
                it.delete()
            }
        }
    }
}