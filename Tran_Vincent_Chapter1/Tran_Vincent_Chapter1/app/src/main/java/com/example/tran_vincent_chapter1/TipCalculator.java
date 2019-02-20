package com.example.tran_vincent_chapter1;

public class TipCalculator {
double tip,people,money,tax,moneyTaxed,tipCalc;

    Double totalWithTip,perPersonTotal,perPersonTip;
    public TipCalculator(double people,double money,double tax,double tip) {
        this.people=people;
        this.money=money;
        this.tax=tax;
        this.tip=tip;
    }
    private void calculate(){
        moneyTaxed=money*tax;
        money=money+moneyTaxed;
        tipCalc=money*tip;
        totalWithTip= tipCalc+money;

    }

    public double returnPersonTip(){
        this.calculate();
        perPersonTip= Math.round((tipCalc/people)*100.0)/100.0;
        return perPersonTip;
    }
    public double returnPersonTotal(){
        perPersonTotal= Math.round((totalWithTip/people)*100.0)/100.0;
        return perPersonTotal;
    }

}
