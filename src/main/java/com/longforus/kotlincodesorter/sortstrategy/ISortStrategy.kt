package com.longforus.kotlincodesorter.sortstrategy

import org.jetbrains.kotlin.psi.KtDeclaration

/**
 * @describe
 * @author  longforus
 * @date 2020/6/6  10:32
 */
interface ISortStrategy {
    val mAllDeclarations:List<KtDeclaration>
    fun sort():List<KtDeclaration>
}