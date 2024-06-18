@file:Suppress("MemberVisibilityCanBePrivate")

package androidx.kylin.recyclerview.holder

import androidx.viewbinding.ViewBinding

/**
 * ViewBinding item view holder.
 * @author RAE
 * @date 2024/03/24
 */
open class BindingViewHolder<T : ViewBinding>(
    /** 视图绑定 */
    protected val binding: T
) : ItemViewHolder(binding.root)