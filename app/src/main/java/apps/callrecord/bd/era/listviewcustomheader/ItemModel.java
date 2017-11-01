package apps.callrecord.bd.era.listviewcustomheader;

import android.support.annotation.NonNull;

/**
 * Created by Enamul on 11/1/17.
 */

public class ItemModel implements Comparable<ItemModel>{
    private  boolean isSectionHeader;
    private String itemTime;
    private String itemSysDia;
    private String itemPulse;
    private String date;

    public ItemModel(String itemTime, String itemSysDia, String itemPulse, String date) {
        this.itemTime = itemTime;
        this.itemSysDia = itemSysDia;
        this.itemPulse = itemPulse;
        this.date =date;
        isSectionHeader = false;
    }

    public String getItemTime() {
        return itemTime;
    }

    public void setItemTime(String itemTime) {
        this.itemTime = itemTime;
    }

    public String getItemSysDia() {
        return itemSysDia;
    }

    public void setItemSysDia(String itemSysDia) {
        this.itemSysDia = itemSysDia;
    }

    public String getItemPulse() {
        return itemPulse;
    }

    public void setItemPulse(String itemPulse) {
        this.itemPulse = itemPulse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSectionHeader() {
        return isSectionHeader;
    }

    @Override
    public int compareTo(ItemModel itemModel) {
        return this.date.compareTo(itemModel.date);
    }

    public void setToSectionHeader() {
        isSectionHeader = true;
    }
}