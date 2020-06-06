package com.longforus.kotlincodesorter.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.command.WriteCommandAction.writeCommandAction
import com.longforus.kotlincodesorter.sort.ISorter
import org.jetbrains.kotlin.psi.KtClassOrObject
import java.util.*


/**
 * Created by XQ Yang on 9/21/2018  5:06 PM.
 * Description :
 */

abstract class BaseSortAction : AnAction() {


    abstract fun getSort(clazz: KtClassOrObject):ISorter

    override fun actionPerformed(e: AnActionEvent) {

        val psiClass = getPsiClassFromContext(e)

        if (psiClass != null) {
            startSort(psiClass)
        }

    }

    private fun startSort(psiClass: List<KtClassOrObject>) {
        for (aClass in psiClass) {
            writeCommandAction(aClass.project,aClass.containingFile).run<Throwable> {
//                Sorter(aClass).sort()
                getSort(aClass).sort()
            }
        }
    }

    /**
     * @param e the action event that occurred
     * @return The PSIClass object based on which class your mouse cursor was in
     */
    protected fun getPsiClassFromContext(e: AnActionEvent): List<KtClassOrObject>? {
        val psiFile = e.getData(LangDataKeys.PSI_FILE) ?: return null

        val children = psiFile.children
        val result = ArrayList<KtClassOrObject>()
        for (child in children) {
            if (child is KtClassOrObject) {
                result.add(child)
            }
        }
        return result
    }
}
