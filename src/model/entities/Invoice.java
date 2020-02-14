package model.entities;

public class Invoice {
    
    private Double baseicPayment;
    private Double tax;
    
    public Invoice() {
    }

    public Invoice(Double baseicPayment, Double tax) {
        this.baseicPayment = baseicPayment;
        this.tax = tax;
    }

    public Double getBaseicPayment() {
        return baseicPayment;
    }

    public void setBaseicPayment(Double baseicPayment) {
        this.baseicPayment = baseicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
    
    public Double getTotalPayment() {
        return getBaseicPayment() + getTax();
    }
    
}
