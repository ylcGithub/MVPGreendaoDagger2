package mgd.ylc.com.mvpgreendaodagger2.dagger2;

public class SimpleMaker implements CoffeeMaker {
    Cooker cooker;  //现在需要咖啡师来制作咖啡了
    public SimpleMaker(Cooker cooker){
        this.cooker = cooker;
    }

    @Override
    public String makeCoffee() {
        return cooker.make();
    }
}
