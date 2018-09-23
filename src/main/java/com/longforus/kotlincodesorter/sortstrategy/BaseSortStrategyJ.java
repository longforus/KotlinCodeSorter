package com.longforus.kotlincodesorter.sortstrategy;

import java.util.Comparator;
import java.util.List;
import org.jetbrains.kotlin.psi.KtDeclaration;

public abstract class BaseSortStrategyJ {
    private List<KtDeclaration> mAllDeclarations;

    protected List<String> mOrdering;

    public BaseSortStrategyJ(List<KtDeclaration> allDeclarations) {
        mAllDeclarations = allDeclarations;
    }

    public List<KtDeclaration> sort() {
        if (mOrdering == null) {
            return mAllDeclarations;
        }
        mAllDeclarations.sort(Comparator.comparingInt(o -> mOrdering.indexOf(o.getClass().getCanonicalName())));
        return mAllDeclarations;
    }
}
