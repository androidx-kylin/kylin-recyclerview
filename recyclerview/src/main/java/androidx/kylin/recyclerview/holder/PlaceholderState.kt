package androidx.kylin.recyclerview.holder

/**
 * 占位符状态
 * @author RAE
 * @date 2024/03/25
 */
sealed class PlaceholderState {

    /**
     * 空视图状态，一般无数据时展示
     */
    data object Empty : PlaceholderState()

    /**
     * 加载中状态
     */
    data object Loading : PlaceholderState()

    /**
     * 发生错误状态
     */
    data class Error(val message: String) : PlaceholderState()

    /**
     * 没有更多数据状态
     */
    data class NoMore(val message: String) : PlaceholderState()

    /**
     * 其他状态
     * @param code 状态码
     * @param message 状态信息
     */
    data class Other(val code: Int, val message: String) : PlaceholderState()
}