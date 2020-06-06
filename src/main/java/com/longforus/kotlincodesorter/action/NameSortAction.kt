package com.longforus.kotlincodesorter.action

import com.longforus.kotlincodesorter.sort.ISorter
import com.longforus.kotlincodesorter.sort.NameSorter
import org.jetbrains.kotlin.psi.KtClassOrObject


/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

class NameSortAction : BaseSortAction() {


    override fun getSort(clazz: KtClassOrObject): ISorter  = NameSorter(clazz)
}
