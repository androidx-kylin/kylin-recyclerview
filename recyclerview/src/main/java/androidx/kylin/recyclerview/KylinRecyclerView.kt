/**
 * RecyclerView的扩展
 * @author RAE
 * @date 2024/06/11
 */
@file:Suppress("UNCHECKED_CAST")

package androidx.kylin.recyclerview

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/**
 * 装配函数
 */
fun RecyclerView.setup(block: RecyclerViewSetup.() -> Unit): RecyclerViewSetup {
    return RecyclerViewSetup(this).apply(block)
}

object KylinRecyclerView {

    /**
     * Inflates a view binding class from the given context.
     *
     * @param clazz The class of the view binding to inflate.
     * @param context The context to inflate the view binding in.
     * @return The inflated view binding object.
     */
    fun <T : ViewBinding> inflate(clazz: Class<T>, context: Context): T {
        val method = clazz.getMethod("inflate", LayoutInflater::class.java)
        method.isAccessible = true
        return method.invoke(null, LayoutInflater.from(context)) as T
    }
}