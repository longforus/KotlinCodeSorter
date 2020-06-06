package com.longforus.kotlincodesorter.sortstrategy

import org.jetbrains.kotlin.psi.KtDeclaration

/**
 * @describe
 * @author  longforus
 * @date 2020/6/6  10:43
 */
class NameSortStrategy( override val mAllDeclarations: List<KtDeclaration>):ISortStrategy {


    override fun sort(): List<KtDeclaration> {
        return mAllDeclarations.sortedBy { it.name }
    }
}