/*
 *  Adapter Design Pattern:
 *      - This pattern acts as a bridge or intermediate between 2 incompatible interfaces.
 *  Exp:
 *      - Client knows only weigt in kg's measurement.
 *      - But the Weighing Machine gives the weight in pounds.
 *      - In this case we need a adaptor that will convert pounds into kg's.
 */

import helperInterfaces.WeightMachine;
import helperInterfaces.WeightMachineAdaptor;

class WeighingMachine implements WeightMachine {
    int weighInPounds;
    WeighingMachine(int weighInPounds){
        this.weighInPounds = weighInPounds;
    }
    @Override
    public int getWeightInPounds() {
        return weighInPounds; // Weight in Pounds.
    }
}

class WeighingMachineAdaptor implements WeightMachineAdaptor{
    WeighingMachine weighingMachine;
    WeighingMachineAdaptor(WeighingMachine weighingMachine){
        this.weighingMachine = weighingMachine;
    }
    @Override
    public int getWeightInKg(){ 
        int weighInPounds = weighingMachine.getWeightInPounds();
        return (int)(weighInPounds * 0.45);
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        WeighingMachineAdaptor weighingMachineAdaptor = new WeighingMachineAdaptor(new WeighingMachine(30));
        System.out.println("Weight in KG's: " + weighingMachineAdaptor.getWeightInKg());
    }
}
