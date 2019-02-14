package mgd.ylc.com.mvpgreendaodagger2.dagger2;

public class CoffeeMachine {
    private CoffeeMaker maker;
    public CoffeeMachine(Cooker cooker){
        maker = new SimpleMaker(cooker);
    }
    public String makeCoffee(){
        return maker.makeCoffee();
    }
}
