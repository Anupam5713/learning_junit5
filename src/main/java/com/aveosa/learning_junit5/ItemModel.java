package com.aveosa.learning_junit5;

public class ItemModel {
    private long id;
    private String item_name;
    private String item_desc;
    private long item_price;

    public ItemModel() {

    }

    public ItemModel(long id, String name, String desc, long price) {
        // TODO Auto-generated constructor stub
        this.id = id;
        this.item_name = name;
        this.item_desc = desc;
        this.item_price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public long getItem_price() {
        return item_price;
    }

    public void setItem_price(long item_price) {
        this.item_price = item_price;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", item_name=" + item_name + ", item_desc=" + item_desc + ", item_price=" + item_price
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((item_desc == null) ? 0 : item_desc.hashCode());
        result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
        result = prime * result + (int) (item_price ^ (item_price >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemModel other = (ItemModel) obj;
        if (id != other.id)
            return false;
        if (item_desc == null) {
            if (other.item_desc != null)
                return false;
        } else if (!item_desc.equals(other.item_desc))
            return false;
        if (item_name == null) {
            if (other.item_name != null)
                return false;
        } else if (!item_name.equals(other.item_name))
            return false;
        if (item_price != other.item_price)
            return false;
        return true;
    }

}
