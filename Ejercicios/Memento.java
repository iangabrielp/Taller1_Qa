package Ejercicios;

import java.util.Stack;


class MementoEmpleado {
    private String nombre;
    private String puesto;
    private double salario;

    public MementoEmpleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }
}


class Empleado {
    private String nombre;
    private String puesto;
    private double salario;

    public void setDatos(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public void show() {
        System.out.println("Empleado: " + nombre + ", Puesto: " + puesto + ", Salario: $" + salario);
    }

    public MementoEmpleado save() {
        return new MementoEmpleado(nombre, puesto, salario);
    }

    public void restore(MementoEmpleado memento) {
        if (memento != null) {
            this.nombre = memento.getNombre();
            this.puesto = memento.getPuesto();
            this.salario = memento.getSalario();
        }
    }
}


class History {
    private Stack<MementoEmpleado> mementos = new Stack<>();

    public void add(MementoEmpleado memento) {
        mementos.push(memento);
    }

    public MementoEmpleado undo() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}


public class Memento {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        History history = new History();

        
        empleado.setDatos("Gabriel Proaño", "Desarrollador Junior", 1200);
        history.add(empleado.save());
        empleado.show();

        
        empleado.setDatos("Gabriel Proaño", "Desarrollador Senior", 2500);
        empleado.show();

        
        empleado.restore(history.undo());
        empleado.show();
    }
}
