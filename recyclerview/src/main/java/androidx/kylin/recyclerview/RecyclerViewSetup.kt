package androidx.kylin.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

/**
 * RecyclerView 装配器
 * @author RAE
 * @date 2024/06/12
 */
class RecyclerViewSetup(val rv: RecyclerView) {

    private var viewBinding: ViewBinding? = null

    fun layout(block: () -> Unit) {}

    fun datasource(block: () -> Unit) {}

    fun binding(block: () -> Unit) {}

    fun <VB : ViewBinding> binding(clazz: KClass<VB>, block: () -> Unit) {
        this.viewBinding = KylinRecyclerView.inflate(clazz.java, rv.context)
    }
}