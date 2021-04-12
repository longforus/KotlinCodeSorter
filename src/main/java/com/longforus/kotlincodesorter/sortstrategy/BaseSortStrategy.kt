package com.longforus.kotlincodesorter.sortstrategy

import org.jetbrains.kotlin.psi.KtDeclaration


@Deprecated("indexOf function maybe throw a exception")
abstract class BaseSortStrategy(private val mAllDeclarations: List<out KtDeclaration>) {

    protected var mOrdering: List<String>? = null
    fun sort(): List<KtDeclaration> {
        if (mOrdering == null) {
            return mAllDeclarations
        }
        mAllDeclarations.sortedWith(Comparator.comparingInt<KtDeclaration> { o -> mOrdering!!.indexOf(o.javaClass.name) })


//       mAllDeclarations.sortedWith(kotlin.Comparator { o1, o2 ->
//           mOrdering!!.indexOf(o1.javaClass)- mOrdering!!.indexOf(o2.javaClass)
//       })

        return mAllDeclarations
    }
}
