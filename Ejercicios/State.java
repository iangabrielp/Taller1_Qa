package Ejercicios;

interface EstadoTarea {
    EstadoTarea comenzar();
    EstadoTarea completar();
}


class Pendiente implements EstadoTarea {
    public EstadoTarea comenzar() {
        System.out.println("Tarea en progreso...");
        return new EnProgreso();
    }

    public EstadoTarea completar() {
        System.out.println("No se puede completar una tarea pendiente");
        return this;
    }
}


class EnProgreso implements EstadoTarea {
    public EstadoTarea comenzar() {
        System.out.println("La tarea ya está en progreso");
        return this;
    }

    public EstadoTarea completar() {
        System.out.println("Tarea completada!");
        return new Completada();
    }
}


class Completada implements EstadoTarea {
    public EstadoTarea comenzar() {
        System.out.println("La tarea ya fue completada");
        return this;
    }

    public EstadoTarea completar() {
        System.out.println("La tarea ya está completada");
        return this;
    }
}


class Tarea {
    private String nombre ;
    private EstadoTarea estado;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = new Pendiente();
    }

    public void comenzar() {
        estado = estado.comenzar();
    }

    public void completar() {
        estado = estado.completar();
    }
}


public class State {
    public static void main(String[] args) {
        Tarea tarea1 = new Tarea("Desarrollar módulo de login");

        tarea1.completar(); 
        tarea1.comenzar();  
        tarea1.comenzar();  
        tarea1.completar(); 
        tarea1.completar();
    }
}

