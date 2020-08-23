package domain;

import customTypes.Money;
import java.util.Currency;
import java.util.Iterator;

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {
    //in this class if totalmoney has this threshold we can substract dicount from total
    private Money discount;
    private Money threshold;

    AbsoluteDiscountOverThresholdPricingStrategy(Money threshold, Money discount) {
        this.threshold = threshold;
        this.discount = discount;

    }

    @Override
    public Money getTotal(Sale sale) {
       // Money pdt = sale.getPreDiscountTotal();
        Money subTotal= new Money(0);
        Iterator i = sale.getLineItems().iterator();
        while (i.hasNext()) {
            SalesLineItem sli = (SalesLineItem) i.next();
            
            subTotal = subTotal.add(sli.getSubTotal()) ;
        }
        if (subTotal.getAmount().compareTo(threshold.getAmount()) < 0) {
            return subTotal;
        } else {
            Currency currency=subTotal.getCurrency();
            return new Money(subTotal.getAmount().subtract(discount.getAmount()),currency);
        }

    }

}
