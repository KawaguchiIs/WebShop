/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer Helios
 */
public class Cart {
    private List<Item> items;
    
    public Cart() {
        items = new ArrayList<>();   
    }
    
    public List<Item> getItems(){
        return items;
    }
    
    private Item getItemById(String id){
        for(Item i:items){
            if(i.getProduct().getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    
    public int getQuantityById(String id){
        return getItemById(id).getQuantity();
    }
    
    public void addItem(Item t){
        if(getItemById(t.getProduct().getId()) != null){
            Item m = getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        }else 
            items.add(t);
    }
    
    public void removeItem(String id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    
    public double getTotalMoney() {
        double total = 0;
        for(Item i:items)
            total+=(i.getQuantity()*i.getPrice());
        return total;
    }
    
    private Product getProductById(String id,List<Product> list){
        for(Product i:list){
            if(i.getId().equals(id))
                return i;
        }
        return null;
    }
    
    public Cart(String txt,List<Product> list ){
        items = new ArrayList<>();
        try{
            if(txt != null && txt.length() != 0){
                String[] s = txt.split("b");
                for(String i:s){
                    String[] n = i.split("a");
                    String id = String.valueOf(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product product = getProductById(id, list);
                    Item item = new Item(product, quantity, product.getPrice());
                    addItem(item);
                }
            }
        }catch(NumberFormatException e){
            
        }
    } 
   
}
