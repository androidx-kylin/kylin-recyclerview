package androidx.kylin.recyclerview.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.WeakHashMap

/**
 * ItemViewHolder
 *
 * @author RAE
 * @date 2024/03/24
 */
open class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * View引用缓存，适用于findViewById的场景
     */
    private val viewRef: WeakHashMap<Int, View> = WeakHashMap()

    /**
     * 根据Id查找View
     */
    @Suppress("UNCHECKED_CAST")
    fun <T : View> findViewByIdOrNull(id: Int): T? {
        viewRef[id]?.also {
            return it as T
        }
        val view = itemView.findViewById<T>(id) ?: return null
        viewRef[id] = view
        return view
    }

    /**
     * 根据Id查找View
     */
    fun <T : View> findViewById(id: Int): T {
        return findViewByIdOrNull(id)
            ?: throw NullPointerException("can't find view by id: $id in $this")
    }

    /**
     * 设置文本
     */
    fun setText(id: Int, text: CharSequence) {
        findViewByIdOrNull<TextView>(id)?.text = text
    }

    /**
     * 设置可见状态
     */
    fun setVisible(id: Int, visible: Boolean) {
        findViewByIdOrNull<View>(id)?.visibility = if (visible) View.VISIBLE else View.GONE
    }

    /**
     * 设置占位状态
     */
    fun setInVisible(id: Int, visible: Boolean) {
        findViewByIdOrNull<View>(id)?.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    /**
     * 设置背景图片
     */
    fun setBackgroundResource(id: Int, resId: Int) {
        findViewByIdOrNull<View>(id)?.setBackgroundResource(resId)
    }

    /**
     * 设置背景颜色
     */
    fun setBackgroundColor(id: Int, color: Int) {
        findViewByIdOrNull<View>(id)?.setBackgroundColor(color)
    }
}