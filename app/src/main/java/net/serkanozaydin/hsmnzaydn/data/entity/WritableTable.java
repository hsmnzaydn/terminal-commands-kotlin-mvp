package net.serkanozaydin.hsmnzaydn.data.entity;

import java.util.ArrayList;
import java.util.List;

public class WritableTable {
    private String title;
    private List<Category> categoryList;

    public WritableTable(String title, List<Category> categoryList){
        this.title=title;
        this.categoryList=categoryList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
