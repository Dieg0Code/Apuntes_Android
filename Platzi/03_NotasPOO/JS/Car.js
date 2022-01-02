class Car {
    constructor(license, driver) {
        this.license = license;
        this.driver = driver;
        this.id;
        this.passenger;
    }

    printDataCar() {
        console.log(this.driver);
        console.log(this.driver.name);
        console.log(this.driver.document);
    }
}