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
        val sort = CommonSortStrategy(declarations).sort()
        sort.forEach {
            if (it is KtClassOrObject) {
                realSort(it)
            }
        }
        sort.forEach {
            classOrObject.addDeclaration(it)
        }
        declarations.forEach {
            it.delete()
        }
    }

}
