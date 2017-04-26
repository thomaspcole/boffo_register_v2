package transaction;

import events.BoffoEvent;
import events.BoffoListenerInterface;
import java.util.ArrayList;
import java.util.List;
import product.ProductObject;

public class Ticket extends Transaction{
    
    private List<ProductObject> products;
    
    Ticket(List<ProductObject> products) {
        
    }
    
    public Ticket() {
        
    }
    
    public ProductObject addProductbyUPC(String UPC) {
        ProductObject product = (ProductObject) ProductObject.loadByUpc(UPC);
        this.products.add(product);
        return product;
    }
    
    public ProductObject addProductbyName(String name) {
        ProductObject product = (ProductObject) ProductObject.loadByName(name);
        this.products.add(product);
        return product;
    }
    
    public void removeProductbyUPC(String UPC) {
        ProductObject product = (ProductObject) ProductObject.loadByUpc(UPC);
        this.products.remove(product);
    }
    
    public void removeProductbyName(String name) {
        ProductObject product = (ProductObject) ProductObject.loadByName(name);
        this.products.remove(product);
    }
    
    public double getTotalPrice(String String_price) {
        double totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            Object obj = ProductObject.loadByPrice(String_price);
            ProductObject p = (ProductObject) obj;
            totalPrice = totalPrice + p.getPrice();
        }
        return totalPrice;
    }
    
    public void fireEvent(BoffoEvent _event) {
    }
    
    public void addListener(BoffoListenerInterface _event) {
    }
    
    public void removeListener(BoffoListenerInterface _event) {
    }
    
    public void messageReceived(BoffoEvent event) {

    }
}