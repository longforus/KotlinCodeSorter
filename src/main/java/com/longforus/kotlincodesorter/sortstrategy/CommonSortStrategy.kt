package com.longforus.kotlincodesorter.sortstrategy

import com.intellij.ide.util.PropertiesComponent
import com.longforus.kotlincodesorter.config.ConfigComponent
import org.jetbrains.kotlin.psi.*

/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

class CommonSortStrategy(mAllDeclarations: List<KtDeclaration>) : BaseSortStrategyJ(mAllDeclarations) {
    init {
        mOrdering = PropertiesComponent.getInstance().getValues(ConfigComponent.SAVED_SORT_ORDER_ARRAY_KEY)?.toList() ?: getDefaultOrdering()
    }


    companion object {
        fun getDefaultOrdering(): List<String> {
            var list = mutableListOf<String>()
            list.add(KtProperty::class.java.name)
            list.add(KtClassInitializer::class.java.name)
            list.add(KtSecondaryConstructor::class.java.name)
            list.add(KtNamedFunction::class.java.name)
            list.add(KtClass::class.java.name)
            list.add(KtObjectDeclaration::class.java.name)
            return list
        }
    }
}