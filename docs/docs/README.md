# 快速上手

```kotlin
// 使用ViewBinding方式进行快速装配。
rv.setup {}.datasource { arraryof(1, 2, 3, 4) }.binding<YourViewBinding> {
    titleView.text = it.title
    descView.text = "hello word!"
}.load()
```

## 高级用法

```kotlin
rv.setup {
    // 线性布局，不设置为默认。
    layout { liner() }
    // 设置数据源
    datasource {
        onLoad { api.loadData() }
        onMore { api.loadMore() }
    }
    // 普通数据绑定
    binding {
        setText(R.id.title, it.title)
    }
    // ViewBinding方式数据绑定
    binding<YourViewBing> {

    }
    // 过渡动画
    transition { fade() }
    // 数据变换，默认数据转换为HolderItem
    transform { position ->
        HolderItem(it, position)
    }
}.load().more()
```

## 重要概念解析

我们把一直使用的`adapter`进行弱化，改变为流行的`DSL`写法进行调用。开箱就支持刷新、加载更多、缺省页。

- `layout`: 布局管理器，本质为`LayoutManager`，目前有线性布局`liner()`、网格布局`grid()`
- `datasource`: 适配器的数据获取，在刷新或加载更多时候触发，`suspend` 挂起函数进行异步调用，非常易于扩展。
- `databinding`: 数据绑定，本质为适配器的`onBindViewHolder()`。
- `transform`: 数据转换，将`model`转化为`item`，以便支持各种类型的`viewType`；

## 数据源

```kotlin
// 默认数据源，能够处理集合数据
rv.datasource = DataSource()
// 分页数据源
rv.datasource = PagerDataSource()
// 数据库数据源
rv.datasource = RoomDataSource()
// 自定义数据源
rv.datasource = YourDataSource()
```

## 数据项绑定

```kotlin
rv.databinding {

}
```
