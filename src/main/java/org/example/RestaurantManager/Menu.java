package org.example.RestaurantManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, MenuItem> menuItems = new HashMap<>();

    public void addItem(MenuItem item){
        menuItems.put(item.getName(), item);
    }

    public void removeItem(String name){
        menuItems.remove(name);
    }

    public MenuItem menuItem(String name){
        return menuItems.get(name);
    }
    public Map<String, MenuItem> getMenuItems() {
        return Collections.unmodifiableMap(menuItems);
    }
}
