public class Subneting {
    
    public IP red;
    public IP primero;
    public IP ultimo;
    public IP broadcast;

    Subneting(IP ip){

        this.red = ip;
        this.primero = ip;
        this.ultimo = ip;
        this.broadcast = ip;

    }

    // getters
    public IP getBroadcast() {
        return broadcast;
    }
    public IP getPrimero() {
        return primero;
    }
    public IP getRed() {
        return red;
    }
    public IP getUltimo() {
        return ultimo;
    }

    public String toString(){

        return "red: " + this.red.getDireccion() + "\nprimera red: " + this.primero.getDireccion() + "\nultima red: "
         + this.ultimo.getDireccion() + "\nbroadcast: " + this.broadcast.getDireccion(); 
        
    }



}
