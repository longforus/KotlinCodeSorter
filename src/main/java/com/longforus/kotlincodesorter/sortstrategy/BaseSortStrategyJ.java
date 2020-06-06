package com.longforus.kotlincodesorter.sortstrategy;

import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.psi.KtDeclaration;

public abstract class BaseSortStrategyJ implements ISortStrategy {

    private List<KtDeclaration> mAllDeclarations;

    @NotNull
    @Override
    public List<KtDeclaration> getMAllDeclarations() {
        return mAllDeclarations;
    }

    protected List<String> mOrdering;

    public BaseSortStrategyJ(List<KtDeclaration> allDeclarations) {
        mAllDeclarations = allDeclarations;
    }

    @Override
    public List<KtDeclaration> sort() {
        if (mOrdering == null) {
            return mAllDeclarations;
        }
        mAllDeclarations.sort(Comparator.comparingInt(o -> mOrdering.indexOf(o.getClass().getCanonicalName())));
        return mAllDeclarations;
    }
}
