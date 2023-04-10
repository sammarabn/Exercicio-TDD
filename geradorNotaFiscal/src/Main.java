import enums.ServiceType;
import model.Address;
import model.Invoice;
import utils.InvoiceDao;
import utils.SAP;
import utils.Smtp;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner read = new Scanner(System.in);
        Invoice invoice = new Invoice();
        InvoiceDao invoiceDao = new InvoiceDao();
        SAP sap = new SAP();
        Smtp smtp = new Smtp();

        System.out.println("Bem-vindo ao sistema de emissao de Nota Fiscal!\n");

        System.out.print("Digite o nome do cliente: ");
        String name = read.nextLine();

        System.out.print("Digite a rua: ");
        String street = read.nextLine();

        System.out.print("Digite o numero: ");
        String number = read.nextLine();

        System.out.println("Possui complemento? Sim/Nao");
        String option = read.nextLine();
        String complement = "Nao possui";

        if(option.toLowerCase().equals("sim")){
            System.out.print("Digite o complemento: ");
            complement = read.nextLine();
        }

        System.out.print("Digite o bairro: ");
        String neighborhood = read.nextLine();

        System.out.print("Digite a cidade: ");
        String city = read.nextLine();

        System.out.print("Digite o CEP: ");
        String zipCode = read.nextLine();

        System.out.print("Digite o Estado: ");
        String federateState = read.nextLine();

        System.out.print("Digite o Pais: ");
        String country = read.nextLine();


        System.out.print("Digite o tipo do servico (CONSULTORIA, TREINAMENTO, OUTRO): ");
        String type = read.next();

        System.out.print("Digite o total: ");
        Double value = read.nextDouble();

        invoice.setAddress(new Address(street, number, complement, neighborhood, city, zipCode, federateState, country));
        invoice.setValue(value);
        invoice.setName(name);
        invoice.setServiceType(ServiceType.valueOf(type.toUpperCase()));
        invoice.calculateAmount();

        System.out.println("Segue os dados da nota fiscal: ");
        System.out.println("Nome: " + invoice.getName() + "\n");
        System.out.println("Dados de endereco: " + "\n" +
                "Rua: " + invoice.getAddress().getStreet() + " " +
                "Numero: " + invoice.getAddress().getNumber() + " " +
                "Complemento: " + invoice.getAddress().getComplement() + " " +
                "Bairro: " + invoice.getAddress().getNeighborhood() + " " +
                "Bairro: " + invoice.getAddress().getCity() + " " +
                "CEP: " + invoice.getAddress().getZipCode() + " " +
                "Estado: " + invoice.getAddress().getFederateState() + " " +
                "Pais: " + invoice.getAddress().getCountry() + "\n");

        System.out.println("Tipode servico: " + invoice.getServiceType());
        System.out.println("Valor de compra: " + invoice.getValue());
        System.out.println("Total com impostos: " + invoice.getAmount());

        invoiceDao.save(invoice);
        sap.send(invoice);
        smtp.send(invoice);

    }
}
