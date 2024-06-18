package androidx.kylin.recyclerview.holder

import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter 占位视图
 * @author RAE
 * @date 2024/03/24
 */
interface PlaceholderView {

    /**
     * 视图状态发生改变的时候回调。
     * @param state 视图状态
     * @param adapter adapter
     */
    fun onPlaceholderStateChanged(state: PlaceholderState, adapter: RecyclerView.Adapter<*>)
}