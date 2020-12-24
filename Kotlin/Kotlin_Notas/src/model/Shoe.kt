package model

class Shoe(name: String, description: String, sku: Int, var brand: String):
        Product(name, description, sku), ICrudActions {  // Clases para Datos - Data Class  || No es obligatorio poner : Any()

    override fun create(): String {
        saludar("hola desde create")
        return "Create Shoe"
    }

    override fun read(): String {
        return "Read Shoe"
    }

    override fun update(): String {
        return "Update Shoe"
    }

    override fun delete(): String {
        return "Delete Shoe"
    }

    override fun toString(): String {// Ejemplo de Polimorfismo
        return super.toString() +"SKU ID: $sku \nMarca: $brand \nModelo: $model \nSize: $size \nColor: $color"
    }

    init { // Constructor secundario, sera ejecutado al construirse la clase
        println("SKU Id: $sku")
        println("Brand: $brand")
    }

    var size: Int = 34 // Mínimo sea 34
        set(value) {
            if (value >= 34 )
                field = value
            else
                field = 34
        }
        get() = field

    var color: String = "White"
    var model: String = "Boots" //No se ponga tenis
        set(value) {
            if (value.equals("Tenis"))
                field = "Boots"
            else
                field = value
        }
}