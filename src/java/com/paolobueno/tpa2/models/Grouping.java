
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.models;

import java.util.LinkedList;
import java.util.List;

public class Grouping<TKey, TItem> {
    private TKey key;
    private List<TItem> items = new LinkedList<TItem>();

    public Grouping() {
    }

    
    public Grouping(TKey key) {
        this.setKey(key);
    }

    public TKey getKey() {
        return key;
    }
    public void setKey(TKey key) {
        this.key = key;
    }
    public List<TItem> getItems() {
        return items;
    }
    public void setItems(List<TItem> items) {
        this.items = items;
    }

    public void addItem(TItem item) {
        this.getItems().add(item);
    }
}
