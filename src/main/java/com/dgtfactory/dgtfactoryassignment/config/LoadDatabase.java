package com.dgtfactory.dgtfactoryassignment.config;

import com.dgtfactory.dgtfactoryassignment.client.Client;
import com.dgtfactory.dgtfactoryassignment.client.ClientRepository;
import com.dgtfactory.dgtfactoryassignment.client.ClientService;
import com.dgtfactory.dgtfactoryassignment.shared.enums.Currency;
import com.dgtfactory.dgtfactoryassignment.shared.enums.FeeCalculation;
import com.dgtfactory.dgtfactoryassignment.shared.enums.PriceRate;
import com.dgtfactory.dgtfactoryassignment.shared.enums.TransactionState;
import com.dgtfactory.dgtfactoryassignment.transaction.Transaction;
import com.dgtfactory.dgtfactoryassignment.transaction.TransactionService;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionType;
import com.dgtfactory.dgtfactoryassignment.transactiontype.TransactionTypeService;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPrice;
import com.dgtfactory.dgtfactoryassignment.unitprice.UnitPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(
            ClientService clientService,
            TransactionTypeService transactionTypeService,
            UnitPriceService unitPriceService,
            TransactionService transactionService) {
        return args -> {
            Client client1 = clientService.save(new Client("Kent", "Beck"));
            Client client2 = clientService.save(new Client("Martin", "Fowler"));
            Client client3 = clientService.save(new Client("Janis", "Joplin"));
            Client client4 = clientService.save(new Client("Lou", "Reed"));
            Client client5 = clientService.save(new Client("Phil", "Collins"));

            TransactionType transactionType1 = new TransactionType("Consulting", FeeCalculation.TIME_RATE);
            TransactionType transactionType2 = new TransactionType("Monthly tax processing - up to 100 turnovers", FeeCalculation.FIXED);
            TransactionType transactionType3 = new TransactionType("Monthly tax processing - up to 1000 turnovers", FeeCalculation.FIXED);
            TransactionType transactionType4 = new TransactionType("Monthly tax processing - up to 10000 turnovers", FeeCalculation.FIXED);
            TransactionType transactionType5 = new TransactionType("Monthly tax processing - over 10000 turnovers", FeeCalculation.FIXED);
            TransactionType transactionType6 = new TransactionType("Annual tax processing - up to 100000 turnovers", FeeCalculation.FIXED);
            TransactionType transactionType7 = new TransactionType("Annual tax processing - over 100000 turnovers", FeeCalculation.FIXED);
            TransactionType transactionType8 = new TransactionType("Consulting for startups", FeeCalculation.MIXED);

            UnitPrice unitPrice1 = new UnitPrice(14.99, PriceRate.HOUR, transactionType1);
            UnitPrice unitPrice2 = new UnitPrice(150.00, PriceRate.ONE_TIME, transactionType2);
            UnitPrice unitPrice3 = new UnitPrice(199.00, PriceRate.ONE_TIME, transactionType3);
            UnitPrice unitPrice4 = new UnitPrice(299.00, PriceRate.ONE_TIME, transactionType4);
            UnitPrice unitPrice5 = new UnitPrice(349.00, PriceRate.ONE_TIME, transactionType5);
            UnitPrice unitPrice6 = new UnitPrice(800.00, PriceRate.ONE_TIME, transactionType6);
            UnitPrice unitPrice7 = new UnitPrice(1500.00, PriceRate.ONE_TIME, transactionType7);
            UnitPrice unitPrice8 = new UnitPrice(300.00, PriceRate.ONE_TIME, transactionType8);
            UnitPrice unitPrice9 = new UnitPrice(14.99, PriceRate.HOUR, transactionType8);

            transactionType1.setUnitPrices(List.of(unitPrice1));
            transactionType2.setUnitPrices(List.of(unitPrice2));
            transactionType3.setUnitPrices(List.of(unitPrice3));
            transactionType4.setUnitPrices(List.of(unitPrice4));
            transactionType5.setUnitPrices(List.of(unitPrice5));
            transactionType6.setUnitPrices(List.of(unitPrice6));
            transactionType7.setUnitPrices(List.of(unitPrice7));
            transactionType8.setUnitPrices(List.of(unitPrice8, unitPrice9));

            transactionType1 = transactionTypeService.save(transactionType1);
            transactionType2 = transactionTypeService.save(transactionType2);
            transactionType3 = transactionTypeService.save(transactionType3);
            transactionType4 = transactionTypeService.save(transactionType4);
            transactionType5 = transactionTypeService.save(transactionType5);
            transactionType6 = transactionTypeService.save(transactionType6);
            transactionType7 = transactionTypeService.save(transactionType7);
            transactionType8 = transactionTypeService.save(transactionType8);

            Transaction transaction1 = new Transaction("Consulting for Kent Beck", 40, TransactionState.OPEN, client1, transactionType1, Currency.EUR);
            Transaction transaction2 = new Transaction("Annual tax processing fo Kent Beck", 0, TransactionState.OPEN, client1, transactionType6, Currency.EUR);
            Transaction transaction3 = new Transaction("Consulting for Janis Joplin", 20, TransactionState.OPEN, client3, transactionType1, Currency.EUR);
            Transaction transaction4 = new Transaction("Consulting for Janis Joplin", 40, TransactionState.OPEN, client3, transactionType1, Currency.EUR);
            Transaction transaction5 = new Transaction("Monthly tax processing for Martin Fowler - january", 0, TransactionState.OPEN, client2, transactionType3, Currency.EUR);
            Transaction transaction6 = new Transaction("Monthly tax processing for Martin Fowler - february", 0, TransactionState.OPEN, client2, transactionType3, Currency.EUR);
            Transaction transaction7 = new Transaction("Monthly tax processing for Martin Fowler - march", 0, TransactionState.OPEN, client2, transactionType3, Currency.EUR);
            Transaction transaction8 = new Transaction("Consulting for startup of Lou Reed", 30, TransactionState.OPEN, client4, transactionType8, Currency.EUR);

            transactionService.save(transaction1);
            transactionService.save(transaction2);
            transactionService.save(transaction3);
            transactionService.save(transaction4);
            transactionService.save(transaction5);
            transactionService.save(transaction6);
            transactionService.save(transaction7);
            transactionService.save(transaction8);
        };
    }
}
