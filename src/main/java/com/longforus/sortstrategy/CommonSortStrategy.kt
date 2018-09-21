package com.longforus.sortstrategy

import org.jetbrains.kotlin.psi.*

/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

class CommonSortStrategy(mAllDeclarations: List<out KtDeclaration>):BaseSortStrategy(mAllDeclarations){
    init {
        mOrdering = arrayListOf(KtProperty::class.java.name,KtClassInitializer::class.java.name,KtSecondaryConstructor::class.java.name,KtNamedFunction::class.java.name,
            KtObjectDeclaration::class.java.name)
    }
}