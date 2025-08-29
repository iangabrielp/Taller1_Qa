package Ejercicios;
import java.util.ArrayList;
import java.util.List;

class Pizza{
    private String size;
    private String dough;
    private List<String> ingredients = new ArrayList<>();
    private double price = 0;

    public void setSize(String size){ 
        this.size = size;
        switch(size){
            case "pequeña": price += 8; break;
            case "mediana": price += 10; break;
            case "grande": price += 12; break;
        }   
        
    }

    public void setDough(String dough){
        this.dough = dough; 
    }


    public void addIngredient(String ingredient, double cost){
        ingredients.add(ingredient);
        price += cost;
    }

    @Override
    public String toString(){
        return "Pizza" + size + ", masa" +dough +
        "\nIngredientes: " + String.join(",", ingredients) +
        "\nPrecio Total: $" + price;
    }
}

class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza();
    }

    public PizzaBuilder setSize(String size) {
        pizza.setSize(size);
        return this;
    }

    public PizzaBuilder setDough(String dough) {
        pizza.setDough(dough);
        return this;
    }

    public PizzaBuilder addIngredient(String ingredient, double cost) {
        pizza.addIngredient(ingredient, cost);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}

public class Builder {
    public static void main(String[] args) {
        PizzaBuilder builder = new PizzaBuilder();
        Pizza pizza = builder.setSize("mediana")
                            .setDough("fina")
                            .addIngredient("queso extra", 2)
                            .addIngredient("pepperoni", 3)
                            .build();

        System.out.println(pizza);
    }
}