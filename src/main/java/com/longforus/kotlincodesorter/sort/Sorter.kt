package com.longforus.kotlincodesorter.sort

import com.longforus.kotlincodesorter.sortstrategy.CommonSortStrategy
import org.jetbrains.kotlin.psi.KtClassOrObject


/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

class Sorter
(private val mPsiClass: KtClassOrObject) {

    fun sort() {
        realSort(mPsiClass)
    }


    fun realSort(classOrObject: KtClassOrObject) {
        val declarations = classOrObject.declarations
        val before = declarations.hashCode()
        val sort = CommonSortStrategy(declarations).sort()
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
