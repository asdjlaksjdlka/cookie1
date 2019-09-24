package com.qf;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl {

    private static List<Product> list = new ArrayList<>();

    static {
        for (int i=0;i<10;i++){
            list.add(new Product(""+i,"联想笔记本"+i,"T42"+i,5000.0+i*100));
        }
    }

    public  List<Product> findAll(){
        return list;

    }

    public Product findById(String id ){
        for (Product p : list){
            if (p.getId().equals(id)) {

                return p;
            }
        }
        return null;
    }


}
