package com.longforus.Sort

import com.intellij.psi.PsiMethod
import com.longforus.sortstrategy.CommonSortStrategy
import org.jetbrains.kotlin.psi.KtClassOrObject

/**
 * Created by armand on 3/1/15.
 */

/**
 * This class determines if the current class is an Activity or a Fragment
 * and sorts the lifecycle methods based off that criteria.
 */
class Sorter
/**
 * @param psiClass     The class whose methods to sort
 */
(private val mPsiClass: KtClassOrObject) {

    /**
     * Formats the activity/fragment lifecycle methods
     */
    fun sort() {
        //Map<String, PsiMethod> methods = getMethodsMap();

        realSort(mPsiClass)

//        LifecycleFactory lifecycleFactory = new LifecycleFactory();
//        BaseSortStrategy lifecycle = lifecycleFactory.createLifecycle(mPsiClass, methods);
//
//        if (lifecycle != null && !methods.isEmpty()) {
//            sortedMethods = lifecycle.sort();
//            appendSortedMethods(sortedMethods);
//
//            // After obtaining and appending the new sorted list of PsiMethods,
//            // we must remove the old, unsorted list
//            deleteUnsortedLifecycleMethods(sortedMethods.values());
//        }

    }


    fun realSort(classOrObject: KtClassOrObject) {
        val declarations = classOrObject.declarations
        val sort = CommonSortStrategy(declarations).sort()
        println(sort)
        sort.forEach {
            if (it is KtClassOrObject) {
                realSort(it)
            }
        }
    }

    /**
     * Generates a Map of all the methods in the current class
     * @return a Map of all the methods in the current class
     */
    //@NotNull
    //private Map<String, PsiMethod> getMethodsMap() {
    //    PsiMethod[] psiClassMethods = mPsiClass.getBody().getProperties();
    //    mPsiClass.getBody().get
    //    Map<String, PsiMethod> methods = new LinkedHashMap<String, PsiMethod>();
    //
    //    for (PsiMethod method : psiClassMethods) {
    //        if (method != null) {
    //            methods.put(method.getName(), method);
    //        }
    //    }
    //    return methods;
    //}


    /**
     * Removes the collection of PsiMethods from the PsiClass
     *
     * @param methods the methods to remove from the PsiClass
     */
    private fun deleteUnsortedLifecycleMethods(methods: Collection<PsiMethod>) {
        for (method in methods) method.delete()
    }


    /**
     * Appends the sorted methods to the file
     *
     * @param sortedMethods The sorted methods to append
     */
    private fun appendSortedMethods(sortedMethods: Map<String, PsiMethod>) {
        //
        //switch (mSortPosition) {
        //    case START:
        //        appendToStart(sortedMethods); break;
        //    case END:
        //        appendToEnd(sortedMethods); break;
        //    default:
        //        appendToStart(sortedMethods); break;
        //}

    }

    /**
     * Appends the sorted lifecycle methods to the end of the class.
     * @param sortedMethods The sorted lifecycle methods
     */
    private fun appendToEnd(sortedMethods: Map<String, PsiMethod>) {
        for (method in sortedMethods.values) {
            //mPsiClass.add(method);
        }
    }

    /**
     * Appends the sorted lifecycle methods to the start of the class.
     * @param sortedMethods The sorted lifecycle methods
     */
    private fun appendToStart(sortedMethods: Map<String, PsiMethod>) {
        // We want the lifecycle methods to be the first methods in the class
        // so we grab the current first method and append the lifecycle
        // methods before it.
        //PsiElement anchorToAddBefore = mPsiClass.getMethods()[0];
        //
        //for (PsiMethod method : sortedMethods.values()) {
        //    mPsiClass.addBefore(method, anchorToAddBefore);
        //}
    }

}
