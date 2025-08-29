package Ejercicios;

class VerificadorTarjeta {
    public boolean verificar(String tarjeta, String cvv) {
        System.out.println("Verificando tarjeta " + tarjeta + " con CVV " + cvv);
        return true; 
    }
}

class ProcesadorPago {
    public boolean procesar(String tarjeta, double monto) {
        System.out.println("Procesando pago de $" + monto + " con tarjeta " + tarjeta);
        return true; 
    }
}

class Notificador {
    public void enviarConfirmacion(String usuario) {
        System.out.println("Enviando confirmación de pago a " + usuario);
    }
}


class PagoFacade {
    private VerificadorTarjeta verificador;
    private ProcesadorPago procesador;
    private Notificador notificador;

    public PagoFacade() {
        verificador = new VerificadorTarjeta();
        procesador = new ProcesadorPago();
        notificador = new Notificador();
    }

    public boolean realizarPago(String usuario, String tarjeta, String cvv, double monto) {
        System.out.println("Iniciando proceso de pago...");
        if (!verificador.verificar(tarjeta, cvv)) {
            System.out.println("Pago fallido: tarjeta no válida");
            return false;
        }
        if (!procesador.procesar(tarjeta, monto)) {
            System.out.println("Pago fallido: error en procesamiento");
            return false;
        }
        notificador.enviarConfirmacion(usuario);
        System.out.println("Pago realizado exitosamente");
        return true;
    }
}


public class Facade {
    public static void main(String[] args) {
        PagoFacade pago = new PagoFacade();
        pago.realizarPago("Gabriel Proaño", "1569-6718-2366-5432", "123", 100);
    }
}