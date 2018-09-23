package com.longforus.kotlincodesorter.sortstrategy

import org.jetbrains.kotlin.psi.*

/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

class CommonSortStrategy(mAllDeclarations: List<KtDeclaration>) : BaseSortStrategyJ(mAllDeclarations) {
    init {
        mOrdering = ArrayList()
        mOrdering.add(KtProperty::class.java.name)
        mOrdering.add(KtClassInitializer::class.java.name)
        mOrdering.add(KtSecondaryConstructor::class.java.name)
        mOrdering.add(KtNamedFunction::class.java.name)
        mOrdering.add(KtClass::class.java.name)
        mOrdering.add(KtObjectDeclaration::class.java.name)
    }
}