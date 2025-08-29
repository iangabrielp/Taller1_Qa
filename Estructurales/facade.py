
class VerificadorTarjeta:
    def verificar(self, tarjeta, cvv):
        print(f"Verificando tarjeta {tarjeta} con CVV {cvv}...")
        return True
    
class ProcesadorPago:
    def procesar(self, tarjeta, monto):
        print(f"Procesando pago de ${monto} con tarjeta {tarjeta}...")
        return True
    
class Notificador:
    def enviar_confirmacion(self, usuario):
        print(f"Enviando confirmación de pago a {usuario}...")
        
class PagoFacade:
    def __init__(self):
        self.verificador = VerificadorTarjeta()
        self.procesador = ProcesadorPago()
        self.notificador = Notificador()
        
    def realizar_pago(self, usuario, tarjeta, cvv, monto):
        print("Iniciando proceso de pago...")
        if not self.verificador.verificar(tarjeta, cvv):
            print("Pago Fallido: tarjeta no valida")
            return False
        if not self.procesador.procesar(tarjeta, monto):
            print("Pago fallido: error en el procesamiento")
            return False
        self.notificador.enviar_confirmacion(usuario)
        print("Pago realizado con exito")
        return True
    
pago= PagoFacade()
pago.realizar_pago("Gabriel Proaño", "1569-6718-2366-5432", "123", 100)