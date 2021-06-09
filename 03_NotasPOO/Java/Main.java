class Main {
    public static void main(String[] args) {
        System.out.println("hola mundo");

        //Instanciacion del primer objeto "car"
        UberX uberX = new UberX("AMQ123", new Account("Andres Herrera", "AND123"), "Chevrolet", "Sonic");
        uberX.setPasseger(4);
        uberX.printDataCar();

        //Instaciacion del segundo objeto "car2"
       /* Car car2 = new Car("QWE567", new Account("Andrea Herrera", "ANDA876"));
        car2.passenger = 3;
        car2.printDataCar();*/

        UberVan uberVan = new UberVan("FGH345", new Account("Andres Herrera", "AND123"));
        uberVan.setPasseger(6);
        uberVan.printDataCar();
    }
}