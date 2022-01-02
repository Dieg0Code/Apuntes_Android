package model

//Siempre las clases deben tener el mismo nombre del archivo y siempre deben iniciar en mayuscula
class Camera {
    private var isOn: Boolean = false
    private var resolution: Int = 1080

    fun setResolution(resolution: Int) {
        this.resolution = resolution
    }

    fun getResolution(): Int {
        return this.resolution
    }

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

    fun getCameraStatus(): String {
        return if (isOn) "Camera is Turned" else "Camera is not turned"

    }

    /*
    fun setCameraStatus(onOff: Boolean) {
        isOn = onOff
    }
    */
}