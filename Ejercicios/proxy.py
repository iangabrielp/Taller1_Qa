from abc import ABC, abstractmethod


class Dron(ABC):
    @abstractmethod
    def enviar_paquete(self, paquete):
        pass


class DronReal(Dron):
    def __init__(self, id_dron):
        self.id_dron = id_dron

    def enviar_paquete(self, paquete):
        print(f"Dron {self.id_dron} enviando paquete: {paquete}")


class ProxyDron(Dron):
    def __init__(self, id_dron, usuario):
        self.id_dron = id_dron
        self.usuario = usuario
        self.dron_real = None
        self.usuarios_autorizados = ["admin", "operador1"]

    def enviar_paquete(self, paquete):
        if self.usuario in self.usuarios_autorizados:
            if self.dron_real is None:
                self.dron_real = DronReal(self.id_dron)
            self.dron_real.enviar_paquete(paquete)
        else:
            print(f"Acceso denegado al dron {self.id_dron} para el usuario: {self.usuario}")


dron1 = ProxyDron("DRN-001", "admin")
dron1.enviar_paquete("Paquete 1")

dron2 = ProxyDron("DRN-002", "invitado")
dron2.enviar_paquete("Paquete 2")
