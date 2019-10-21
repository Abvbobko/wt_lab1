package beans;

import java.io.Serializable;

public enum ServiceClass implements Serializable {
    ECONOMY("E"), BUSINESS("B");

    String id;

    ServiceClass(String serviceClassID){
        this.id = serviceClassID;
    }

    public String getServiceClass() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
