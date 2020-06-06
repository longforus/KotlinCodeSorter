package com.longforus.kotlincodesorter.sort

import com.longforus.kotlincodesorter.sortstrategy.ISortStrategy
import com.longforus.kotlincodesorter.sortstrategy.NameSortStrategy
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.psi.KtDeclaration


/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

class NameSorter(override val mPsiClass: KtClassOrObject) :ISorter{

    override fun getStrategy(declarations: List<KtDeclaration>): ISortStrategy {
        return NameSortStrategy(declarations)
    }

}
