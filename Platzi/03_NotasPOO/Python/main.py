from car import Car
from account import Account

if __name__ == "__main__":
    print("hola mundo")

    car =   Car("AMS234", Account("Andres Herrera", "ANDA876"))
    print(vars(car))
    print(vars(car.driver))