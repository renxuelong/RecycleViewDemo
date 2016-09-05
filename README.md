# RecycleView

导包: compile 'com.android.support:recyclerview-v7:23.4.0'

## RecycleViewAdapter 创建步骤
1. 新建类继承 RecycleViewAdapter<MyRecycleViewAdapter.MyViewHolder>,
   泛型指定为 MyRecycleViewAdapter 的内部类 MyRecycleViewAdapter.MyViewHolder,
2. 快捷键导入 RecycleViewAdapter的抽象方法
3. 快捷键创建自定义内部类 MyViewHolder 类
4. 快捷键修改自定义的MyViewHolder 类继承自 V7 包的  RecyclerView.ViewHolder
5. 重写MyViewHolder 的一个参数的构造方法

## ViewHolder 类创建步骤
1. 首先声明需要显示的控件
2. 在构造方法中，通过构造方法的参数 View ，由 View.findViewById() 方法初始化各控件


## Adapter 实现步骤
1. 重写 onCreateViewHolder() ，调用 MyViewHolder 的参数为 View 的构造方法创建
   MyViewHolder 对象，并作为返回值返回。
2. 重写 onBindViewHolder() ，调用方法中的 ViewHolder 对象，以及由参数 position 
   得到要现实的数据， 将数据绑定至 ViewHolder
3. 重写 getItemCount() , 返回数据集合的 size



## RecycleView 配置步骤
1. 初始化 RecycleView 对象
2. 为 RecycleView 设置布局管理器,new 一个 LinearLayoutManager可以通过 setOrientation 
   设置水平或垂直滚动
   默认的是垂直滚动的
3. 初始化 RecycleViewAdapter
4. 为 RecycleView 设置 Adapter



## RecycleView 设置 ItemClickListener/ItemLongClickListener
1. 在 Adapter 中定义 Listener 接口，定义监听方法，在 Adapter 中定义 Listener 对象和 setListener 的方法
2. 在 onBindViewHolder() 方法中判断如果 Listener 对象如果不为空就为 viewHolder.itemView
   添加 onClickListener() 方法，在 onClick() 方法中调用 Listener 接口中的监听方法
3. 如果需要添加监听器，就在 RecycleViewAdapter 对象初始化后调用 setListener() 方法




## RecycleView 的布局管理器
1. **LinearLayoutManager ListView 型**  可以设置水平或垂直滑动
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
	
2. **GridLayoutMAnager GridView 型** 可以设置水平或垂直排列，最后一个参数表示是否反向排列，即数据从尾到头
    GridLayoutManager layoutManager = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false);

3. **StaggeredGridLayoutManager  瀑布流** onBindViewHolder() 方法中为每一个 item 设置不同高度后，即实现瀑布流效果
    StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
    

## RecycleView item 添加移除动画
RecycleViewAdapter 的 **notifyItemInserted(position)** 和 **notifyItemRemoved(position)** 方法默认添加了添加
和移除 item 时的动画  
**注意！！！**在添加数据时要将 item 高度的集合同时添加数据，要不然会报数组越界异常












