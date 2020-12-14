import java.util.Map;

import java.util.ArrayList;

class UberVan extends Car {
    
    Map<String, Map<String,Integer>> typeCarAccepted;
    ArrayList<String> seatsMaterial;
    //private Integer passenger;

   /* public UberVan(final String license, final Account driver,
     final Map<String, Map<String,Integer>> typeCarAccepted,
     final ArrayList<String> seatsMaterial) {
        super(license, driver);
        this.typeCarAccepted = typeCarAccepted;
        this.seatsMaterial = seatsMaterial;
    }*/

    public UberVan(String license, Account driver) {
        super(license,driver);
    }

    //Ej de Polimorfismo
    @Override
    public void setPasseger(Integer passenger) {
        if(passenger == 6) {
            this.passenger = passenger;
        } else {
            System.out.println("Necesitas asignar 6 pasajeros");
        }
    }
}