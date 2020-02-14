package locaçãointerfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class LocaçãoInterfaces {

    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH>mm");
        
        System.out.println("Enter rental data:"); // Entra com os dados de aluguel
        System.out.print("Car model: "); //Modelo do carro
        String carModel = sc.nextLine();
        System.out.print("Pick (dd/MM/yyyy hh:mm): "); //Dia que escolheu
        Date start = sdf.parse(sc.nextLine());
        System.out.println("Return (dd/MM/yyyy hh:mm): "); //Retorno
        Date finish = sdf.parse(sc.nextLine());
        
        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
        
        System.out.print("Enter price per hour: "); //Entra com o preço por hora
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter price per day: "); //Entra com o preço por dia
        double pricePerDay = sc.nextDouble();
        
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        
        rentalService.processInvoice(cr);
        
        System.out.println("INVOICE"); // Fatura
        System.out.println("Basic payment: " + String.format("%.2f", cr.getInvoice().getBaseicPayment())); //Pagamento basico
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax())); //Taxa
        System.out.println("Total payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment())); //Total pago   
    }
}
