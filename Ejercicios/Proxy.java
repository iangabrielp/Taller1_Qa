package Ejercicios;


interface Dron {
    void enviarPaquete(String paquete);
}


class DronReal implements Dron {
    private String idDron;

    public DronReal(String idDron) {
        this.idDron = idDron;
    }

    public void enviarPaquete(String paquete) {
        System.out.println("Dron " + idDron + " enviando paquete: " + paquete);
    }
}


class ProxyDron implements Dron {
    private String idDron;
    private String usuario;
    private DronReal dronReal;
    private String[] usuariosAutorizados = {"admin", "operador1"};

    public ProxyDron(String idDron, String usuario) {
        this.idDron = idDron;
        this.usuario = usuario;
    }

    public void enviarPaquete(String paquete) {
        boolean autorizado = false;
        for (String u : usuariosAutorizados) {
            if (u.equals(usuario)) {
                autorizado = true;
                break;
            }
        }

        if (autorizado) {
            if (dronReal == null) {
                dronReal = new DronReal(idDron);
            }
            dronReal.enviarPaquete(paquete);
        } else {
            System.out.println("Acceso denegado al dron " + idDron + " para el usuario: " + usuario);
        }
    }
}

public class Proxy {
    public static void main(String[] args) {
        Dron dron1 = new ProxyDron("DRN-001", "admin");
        dron1.enviarPaquete("Paquete 1");

        Dron dron2 = new ProxyDron("DRN-002", "invitado");
        dron2.enviarPaquete("Paquete 2");
    }
}
