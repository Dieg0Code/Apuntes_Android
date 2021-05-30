class Car {
    private Integer id;
    private String license;
    private Account driver;
    protected Integer passenger;

    //El metodo constructor incializado con los datos obligatorios
    public Car(String license, Account driver ) {
        this.license = license;
        this.driver = driver;
    }

    void printDataCar() {
        if(passenger != null){
            System.out.println("License: " + license + " Name Driver: " + driver.name + " Passengers: " + passenger);
        }
    }


    public Integer getPasseger() {
        return passenger;
    }

    public void setPasseger(Integer passenger) {
        if(passenger == 4) {
            this.passenger = passenger;
        } else {
            System.out.println("Necesitas asignar 4 pasajeros");
        }
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Account getDriver() {
        return driver;
    }

    public void setDriver(Account driver) {
        this.driver = driver;
    }

    
}