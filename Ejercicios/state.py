from abc import ABC, abstractmethod


class EstadoTarea(ABC):
    @abstractmethod
    def comenzar(self):
        pass

    @abstractmethod
    def completar(self):
        pass


class Pendiente(EstadoTarea):
    def comenzar(self):
        print("Tarea en progreso...")
        return EnProgreso()
    
    def completar(self):
        print("No se puede completar una tarea pendiente")
        return self


class EnProgreso(EstadoTarea):
    def comenzar(self):
        print("La tarea ya está en progreso")
        return self
    
    def completar(self):
        print("Tarea completada!")
        return Completada()

class Completada(EstadoTarea):
    def comenzar(self):
        print("La tarea ya fue completada")
        return self
    
    def completar(self):
        print("La tarea ya está completada")
        return self


class Tarea:
    def __init__(self, nombre):
        self.nombre = nombre
        self.estado = Pendiente()
    
    def comenzar(self):
        self.estado = self.estado.comenzar()
    
    def completar(self):
        self.estado = self.estado.completar()

tarea1 = Tarea("Desarrollar módulo de login")

tarea1.completar()    
tarea1.comenzar()     
tarea1.comenzar()     
tarea1.completar()    
tarea1.completar()    
