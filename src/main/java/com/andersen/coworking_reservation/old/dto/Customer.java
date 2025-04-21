package dto;

import java.io.Serializable;

class Customer extends User implements Serializable {

    public Customer(String name){
        super(name);
    }
}