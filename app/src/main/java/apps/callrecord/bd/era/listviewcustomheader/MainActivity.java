package apps.callrecord.bd.era.listviewcustomheader;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ItemModel> itemsList = new ArrayList<>();
        ListView list = (ListView) findViewById(R.id.listview);
        itemsList = sortAndAddSections(getItems());
        ListAdapter adapter = new ListAdapter(this, itemsList);
        list.setAdapter(adapter);
    }


    private ArrayList sortAndAddSections(ArrayList<ItemModel> itemList)
    {

        ArrayList<ItemModel> tempList = new ArrayList<>();
        //First we sort the array
        Collections.sort(itemList);

        //Loops thorugh the list and add a section before each sectioncell start
        String header = "";
        for(int i = 0; i < itemList.size(); i++)
        {
            //If it is the start of a new section we create a new listcell and add it to our array
            if(!(header.equals(itemList.get(i).getDate()))) {
                ItemModel sectionCell = new ItemModel(null, null,null,itemList.get(i).getDate());
                sectionCell.setToSectionHeader();
                tempList.add(sectionCell);
                header = itemList.get(i).getDate();
            }
            tempList.add(itemList.get(i));
        }

        return tempList;
    }


    public class ListAdapter extends ArrayAdapter {

        LayoutInflater inflater;
        public ListAdapter(Context context, ArrayList items) {
            super(context, 0, items);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            ItemModel cell = (ItemModel) getItem(position);

            //If the cell is a section header we inflate the header layout
            if(cell.isSectionHeader())
            {
                v = inflater.inflate(R.layout.section_header, null);

                v.setClickable(false);

                TextView header = (TextView) v.findViewById(R.id.section_header);
                header.setText(cell.getDate());
            }
            else
            {
                v = inflater.inflate(R.layout.row_item, null);
                TextView time_time = (TextView) v.findViewById(R.id.time_time);
                TextView tv_item_sysdia = (TextView) v.findViewById(R.id.tv_item_sysdia);

                TextView tv_item_plus = (TextView) v.findViewById(R.id.tv_item_plus);

                time_time.setText(cell.getItemTime());
                tv_item_sysdia.setText(cell.getItemSysDia());
                tv_item_plus.setText(cell.getItemPulse());


            }
            return v;
        }
    }


    private ArrayList<ItemModel>  getItems(){

        ArrayList<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel("10.30", "120/10","80","Tue,31 Oct 17"));
        items.add(new ItemModel("10.30", "142/95","95","Tue,31 Oct 17"));
        items.add(new ItemModel("15.30", "120/95","200","Tue,31 Oct 17"));
        items.add(new ItemModel("20.30", "120/10","80","Tue,29 Oct 17"));
        items.add(new ItemModel("10.30", "120/10","50","Tue,29 Oct 17"));

        items.add(new ItemModel("10.30", "140/10","80","Tue,28 Oct 17"));
        items.add(new ItemModel("10.30", "30/75","40","Tue,28 Oct 17"));
        items.add(new ItemModel("10.30", "150/80","70","Tue,28 Oct 17"));

        return  items;
    }
}
