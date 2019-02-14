package mgd.ylc.com.mvpgreendaodagger2.dagger2;

public class CoffeeMachinWithInjection implements InjectMaker {
    private CoffeeMaker maker;

    /*依赖注入的3种常见形式
     *No.1  构造函数注入
     */
    public CoffeeMachinWithInjection(CoffeeMaker maker) {
        this.maker = maker;
    }

    //No.2  Setter注入
    public void setMaker(CoffeeMaker maker) {
        this.maker = maker;
    }

    // //No.3 接口注入
    @Override
    public void injectMaker(CoffeeMaker maker) {
        this.maker = maker;
    }

    public String makeCoffee() {
        return maker.makeCoffee();
    }
}
