package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product){
        if(product.getType().equals("l")){
            if(product.getName().equals("Brie")){
                if(product.getQuality()<50){
                    product.setSellIn(product.getSellIn()-1);
                    product.setQuality(product.getQuality()+1);
                }
            }else{
                if(product.getSellIn()>0){
                    product.setSellIn(product.getSellIn()-1);
                    if (product.getQuality()>1){
                        product.setQuality(product.getQuality()-2);
                    }else{
                        product.setQuality(0);
                    }

                }else {
                    if (product.getQuality() > 3) {
                        product.setQuality(product.getQuality() - 4);
                    }else {
                        product.setQuality(0);
                    }
                }
            }

        }
        else if(product.getSellIn()>0){
            product.setSellIn(product.getSellIn()-1);
            if (product.getQuality()>0){
                product.setQuality(product.getQuality()-1);
            }

        }else{
            if (product.getQuality()>1){
                product.setQuality(product.getQuality()-2);
            }else{
                product.setQuality(0);
            }
        }
    }
}
