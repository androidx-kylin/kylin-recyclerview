package androidx.kylin.recyclerview.widget

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * 扩展线性布局管理器
 * @author RAE
 * @date 2024/06/15
 */
open class KylinLinearLayoutManager : LinearLayoutManager {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, orientation: Int, reverseLayout: Boolean) : super(
        context,
        orientation,
        reverseLayout
    )
}