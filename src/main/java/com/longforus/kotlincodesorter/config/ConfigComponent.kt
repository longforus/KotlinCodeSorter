package com.longforus.kotlincodesorter.config

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.options.SearchableConfigurable
import com.longforus.kotlincodesorter.sortstrategy.CommonSortStrategy
import com.longforus.kotlincodesorter.ui.SortStrategySetting
import javax.swing.JComponent

class ConfigComponent : SearchableConfigurable {


    override fun getId(): String {
        return displayName
    }

    private val mCp: SortStrategySetting by lazy { SortStrategySetting() }
    lateinit var state: PropertiesComponent

    override fun isModified(): Boolean {
        return !originOrder.contentEquals(curOrder)
    }

    override fun getDisplayName(): String {
        return "Kotlin Code Sorter"
    }

    override fun apply() {
        state.setValues(SAVED_SORT_ORDER_ARRAY_KEY,curOrder)
    }


    override fun createComponent(): JComponent? {
        state = PropertiesComponent.getInstance()
        loadValues()
        return mCp.mPanel
    }

    private var originOrder :Array<String> = arrayOf()
    private var curOrder :Array<String> = arrayOf()

    private fun loadValues() {
        var order = state.getValues(SAVED_SORT_ORDER_ARRAY_KEY)
        if (order == null || order.isEmpty()) {
            order = CommonSortStrategy.getDefaultOrdering().toTypedArray()
        }
        originOrder = order.copyOf()
        curOrder = order.copyOf()
        mCp.mList1.setListData(curOrder)
        mCp.mButtonS.addActionListener {
            val selectedIndex = mCp.mList1.selectedIndex
            if (selectedIndex in 1..curOrder.size) {
                swapMy( selectedIndex, selectedIndex - 1)
            }
        }
        mCp.mButtonX.addActionListener {
            val selectedIndex = mCp.mList1.selectedIndex
            if (selectedIndex in 0..curOrder.size) {
                swapMy( selectedIndex, selectedIndex + 1)
            }
        }
    }

    private fun swapMy( i1: Int, i: Int) {
        var temp = curOrder[i]
        curOrder[i] = curOrder[i1]
        curOrder[i1] = temp
        mCp.mList1.setListData(curOrder)
        mCp.mList1.selectedIndex = i
    }


    companion object {
        const val SAVED_SORT_ORDER_ARRAY_KEY = "saved_sort_order_array_key"
    }


}