
class Pizza:
    def __init__(self):
        self.size = None
        self.dough = None
        self.ingredients = []
        self.price = 0
        
    def __str__(self):
        text = f"Pizza: {self.size}, masa {self.dough}\n"
        text += "Ingredientes: "+", ".join(self.ingredients) + "\n"
        text += f"Precio total: ${self.price:}"
        return text
    
class PizzaBuilder:
    def __init__(self):
        self.pizza = Pizza()
        
    def set_size(self, size):
        self.pizza.size = size
        if size == "pequeña":
            self.pizza.price += 5
        elif size == "mediana":
            self.pizza.price += 10
        elif size == "grande":
            self.pizza.price += 15
        return self
    
    def set_dough(self, dough):
        self.pizza.dough = dough
        return self
    
    def add_ingredient(self, ingredient,cost):
        self.pizza.ingredients.append(ingredient)
        self.pizza.price += cost
        return self
    
    def build(self):
        return self.pizza
    

builder = PizzaBuilder()
pizza = (builder.set_size("mediana")
            .set_dough("fina")
            .add_ingredient("queso extra", 2)
            .add_ingredient("pepperoni", 3)
            .build())

print(pizza)