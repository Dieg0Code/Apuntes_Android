package model

abstract class Product(var name: String, var description: String, var sku: Int) {

    override fun toString(): String {
        return "\nName: $name \nDescription: $description \nSKU: $sku"
    }
    // Los metodos abtractos no pueden tener cuerpo

}