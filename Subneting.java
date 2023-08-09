public class Subneting {
    
    public IP red;
    public IP primero;
    public IP ultimo;
    public IP broadcast;

    Subneting(IP ip){

        this.red = ip;
        this.primero = obtener(ip, 0);
        this.ultimo = obtener(ip, 1);
        this.broadcast = obtener(ip,2);

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

    private IP obtener(IP ip, int n) {

        String ref = "";
        String s = "";
        String red = "";
        String host = "";
        String apoyo = "";
        String todo;
        String dir = ip.getDireccion() + ".";
        int contador = 0;


        for (int i = 0; i < dir.length(); i++) {
            
            if(dir.charAt(i) == '.'){

                String str = Integer.toBinaryString(Integer.parseInt(apoyo));
                
                while (str.length() < 8) {

                    str = "0" + str;

                }

                red += str;
                apoyo = "";

            }else{

                apoyo += dir.charAt(i);

            }

        }

        for (int i = 0; i < 32; i++) {
            
            if(i >= ip.getMascara()){

                if(n == 0){

                    if(i == 31){

                        host += "1";

                    }else{

                        host += "0";

                    }

                }if(n == 1){

                    if(i == 31){

                        host += "0";

                    }else{

                        host += "1";

                    }
                }if(n == 2){

                    host += "1";

                }

            }

        }
        for (int i = 0; i < ip.getMascara(); i++) {

            ref += red.charAt(i);
            
        }


        todo = (ref + host + " ");


        for (int i = 0; i < todo.length(); i++) {
            
            if(contador == 8){

                s += Integer.parseInt(apoyo, 2);
                contador = 0;
                apoyo = "";

                if(i != todo.length() - 1){
                    
                    s += ".";
                    
                }
                
                i--;
                
            }else{

                apoyo += todo.charAt(i);
                contador++;
                
            }
            
        }

        return new IP(s, ip.getMascara());

    }

    public String toString(){

        return " \nred: " + this.red.getDireccion() + "\nprimera red: " + this.primero.getDireccion() + "\nultima red: "
         + this.ultimo.getDireccion() + "\nbroadcast: " + this.broadcast.getDireccion(); 
        
    }

}
