package iii.org.tw.littleproject2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by YunHua on 9/24/16.
 */
public class Menu extends Activity{
    private GridView menu_grid;
    private int[]icon={R.drawable.star1,R.drawable.star2,R.drawable.star3,
                        R.drawable.star4,R.drawable.star5,R.drawable.star6,
                        R.drawable.star7,R.drawable.star8,R.drawable.star9,
                        R.drawable.star10,R.drawable.star11,R.drawable.star12,
                        R.drawable.star13,R.drawable.star14,R.drawable.star15,};
    private String[]level={"Level 1","Level 2","Level 3","Level 4","Level 5",
                             "Level 6","Level 7","Level 8","Level 9","Level 10",
                             "Level 11","Level 12","Level 13","Level 14", "Level 15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu_grid=(GridView)findViewById(R.id.menu_grid);
        IconAdapter gAdapter=new IconAdapter();
        menu_grid.setAdapter(gAdapter);
        menu_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int levelindex, long id) {
                toLevel(levelindex);
            }
        });
    }
    private void toLevel(int levelindex){
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("levelindex",levelindex);
        startActivityForResult(intent,1102);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    class IconAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return level.length;
        }

        @Override
        public Object getItem(int position) {
            return level[position];
        }

        @Override
        public long getItemId(int position) {
            return icon[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            if(row==null){
                row=getLayoutInflater().inflate(R.layout.activity_level,null);
                ImageView img=(ImageView)row.findViewById(R.id.level_image);
                TextView txt=(TextView)row.findViewById(R.id.level_text);
                img.setImageResource(icon[position]);
                txt.setText(level[position]);
            }

            return row;
        }
    }
}
