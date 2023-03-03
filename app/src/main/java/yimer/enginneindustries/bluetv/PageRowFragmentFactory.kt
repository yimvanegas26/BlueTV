package yimer.enginneindustries.bluetv

import android.content.Context
import android.util.Log
import androidx.leanback.widget.HeaderItem
import androidx.fragment.app.Fragment
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.*
import yimer.enginneindustries.bluetv.custom.CardPresenter
import yimer.enginneindustries.bluetv.custom.CustomBannerCardPresenter
import yimer.enginneindustries.bluetv.custom.CustomHeaderItem
import yimer.enginneindustries.bluetv.custom.CustomListRowPresenter
import yimer.enginneindustries.bluetv.domain.Category
import yimer.enginneindustries.bluetv.domain.Data
import yimer.enginneindustries.bluetv.domain.BannerData
import yimer.enginneindustries.bluetv.domain.BannerDataOne

class PageRowFragmentFactory(var mContext: Context? = null): BrowseSupportFragment.FragmentFactory<Fragment?>() {

    private val TAG: String = javaClass.simpleName

    override fun createFragment(row: Any?): Fragment? {

        val row: Row = row as Row
        val headerItem: CustomHeaderItem = row.headerItem as CustomHeaderItem
        val item: Any? = headerItem.item
        item?.run {
            when(this){
                is Data -> {
                    val subCategoryList: List<Category>? = sub_categories
                    if(subCategoryList!=null && subCategoryList.isNotEmpty()){
                        val rowsSupportFragment: RowsSupportFragment = RowsSupportFragment()
                        val rowsAdapter: ArrayObjectAdapter = ArrayObjectAdapter(
                            CustomListRowPresenter(
                                mContext,
                                FocusType.START,
                                focusHightlightMode = FocusHighlight.ZOOM_FACTOR_XSMALL
                            )
                        )
                        for ((subCategoryIndex, subCategory) in subCategoryList.withIndex()){
                            val subCategoryName: String? = subCategory.id
                            if(BuildConfig.DEBUG) Log.d(TAG, "subCategoryName: $subCategoryName")
                            val items: String = subCategory.name
                            val listRowAdapter: ArrayObjectAdapter = ArrayObjectAdapter(
                                CardPresenter()
                            )
                            if(items!=null && items.isNotEmpty()){
                                for(item in items){
                                    if(BuildConfig.DEBUG) {

                                    }
                                    listRowAdapter.add(item)
                                }
                                val header: HeaderItem = HeaderItem(subCategoryIndex.toLong(), subCategoryName)
                                rowsAdapter.add(ListRow(header, listRowAdapter))
                            }
                        }
                        rowsSupportFragment.adapter = rowsAdapter
                        return  rowsSupportFragment
                    }
                }
                is BannerData -> {
                    val rowsSupportFragment: RowsSupportFragment = RowsSupportFragment()
                    val rowsAdapter: ArrayObjectAdapter = ArrayObjectAdapter(
                        CustomListRowPresenter(
                            mContext,
                            isBanner = true
                        ))
                    val listRowAdapter: ArrayObjectAdapter = ArrayObjectAdapter(
                        CustomBannerCardPresenter())
                    val items: List<String>? = banner_list
                    if(items!=null && items.isNotEmpty()){
                        for(item in items){
                            if(BuildConfig.DEBUG) Log.i(TAG, "imageUrl: $item")
                            listRowAdapter.add(item)
                        }
                        val header: HeaderItem = HeaderItem(0, "")
                        rowsAdapter.add(ListRow(header, listRowAdapter))
                        rowsSupportFragment.adapter = rowsAdapter
                        return  rowsSupportFragment
                    }
                }
                is BannerDataOne -> {
                    val rowsSupportFragment: RowsSupportFragment = RowsSupportFragment()
                    val rowsAdapter: ArrayObjectAdapter = ArrayObjectAdapter(
                        CustomListRowPresenter(
                            mContext,
                            isBanner = true
                        ))
                    val listRowAdapter: ArrayObjectAdapter = ArrayObjectAdapter(
                        CustomBannerCardPresenter())
                    val items: List<String>? = banner_list
                    if(items!=null && items.isNotEmpty()){
                        for(item in items){
                            if(BuildConfig.DEBUG) Log.i(TAG, "imageUrl: $item")
                            listRowAdapter.add(item)
                        }
                        val header: HeaderItem = HeaderItem(0, "")
                        rowsAdapter.add(ListRow(header, listRowAdapter))
                        rowsSupportFragment.adapter = rowsAdapter
                        return  rowsSupportFragment
                    }
                }
            }
        }
        return null

    }

}
