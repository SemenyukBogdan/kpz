package task1;

import java.util.List;

public abstract class Subscription {
    protected double monthlyFee;
    protected int minPeriodMonths;
    protected List<String> channels;
    protected List<String> features;

    public Subscription(double monthlyFee, int minPeriodMonths, List<String> channels, List<String> features) {
        this.monthlyFee = monthlyFee;
        this.minPeriodMonths = minPeriodMonths;
        this.channels = channels;
        this.features = features;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getMinPeriodMonths() {
        return minPeriodMonths;
    }

    public List<String> getChannels() {
        return channels;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void displayInfo() {
        System.out.println("Підписка: " + this.getClass().getSimpleName());
        System.out.println("Щомісячна плата: " + monthlyFee + " грн");
        System.out.println("Мінімальний період: " + minPeriodMonths + " місяців");
        System.out.println("Канали: " + channels);
        System.out.println("Можливості: " + features);
    }
}
