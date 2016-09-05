package datepicker.rxl.com.recycleviewstudy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private List<String> data;
    private List<Integer> hList;
    private MyRecycleViewAdapter adapter;
    private Button add, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add);
        del = (Button) findViewById(R.id.del);

        add.setOnClickListener(this);
        del.setOnClickListener(this);

        data = new ArrayList<>();
        hList = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            data.add((char) i + "");
            hList.add(100 + (int) (Math.random() * 300));
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL
//                , false);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyRecycleViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                adapter.add(2);
                break;
            case R.id.del:
                adapter.del(2);
                break;
        }
    }

    class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

        @Override
        public MyRecycleViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, parent, false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyRecycleViewAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(data.get(position));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.tv.getLayoutParams();
            layoutParams.height = hList.get(position);
            holder.tv.setLayoutParams(layoutParams);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.text);
            }
        }

        public void add(int position) {
            data.add(position, "addd");
            hList.add(position, 100 + (int) (Math.random() * 300));
            notifyItemInserted(position);
        }

        public void del(int position) {
            data.remove(position);
            notifyItemRemoved(position);
        }

    }

}
