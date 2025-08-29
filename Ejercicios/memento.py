

class MementoEmpleado:
    def __init__(self, nombre, puesto, salario):
        self.nombre = nombre
        self.puesto = puesto
        self.salario = salario

class Empleado:
    def __init__(self):
        self.nombre = ""
        self.puesto = ""
        self.salario = 0.0

    def set_datos(self, nombre, puesto, salario):
        self.nombre = nombre
        self.puesto = puesto
        self.salario = salario

    def show(self):
        print(f"Empleado: {self.nombre}, Puesto: {self.puesto}, Salario: ${self.salario:.2f}")

    def save(self):
        return MementoEmpleado(self.nombre, self.puesto, self.salario)

    def restore(self, memento):
        self.nombre = memento.nombre
        self.puesto = memento.puesto
        self.salario = memento.salario

class History:
    def __init__(self):
        self.mementos = []

    def add(self, memento):
        self.mementos.append(memento)

    def undo(self):
        if self.mementos:
            return self.mementos.pop()
        return None


empleado = Empleado()
history = History()


empleado.set_datos("Gabriel Proaño", "Desarrollador Junior", 1200)
history.add(empleado.save())
empleado.show()


empleado.set_datos("Gabriel Proaño", "Desarrollador Senior", 2500)
empleado.show()


empleado.restore(history.undo())
empleado.show()
