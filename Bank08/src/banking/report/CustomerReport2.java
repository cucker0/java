package banking.report;

import banking.domain.*;

import java.text.NumberFormat;
import java.util.Iterator;


public class CustomerReport2 {
    /*
    Generate a report
    * */

    public void generateReport() {
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");
        Bank bank = Bank.getBank();
        Customer customer;
        NumberFormat currency_format = NumberFormat.getCurrencyInstance();

        Iterator<Customer> iteratorCustomers = bank.getCustomers();
        while (iteratorCustomers.hasNext()) {
            customer = iteratorCustomers.next();

            System.out.println();
            System.out.println(customer);

            Iterator<Account> iteratorAccounts = customer.getAccounts();
            while (iteratorAccounts.hasNext()) {
                Account account = iteratorAccounts.next();
                String account_type = "";

                // Determine the account type
                /*** Step 1:
                 **** Use the instanceof operator to test what type of account
                 **** we have and set account_type to an appropriate value, such
                 **** as "Savings Account" or "Checking Account".
                 ***/
                if (account instanceof SavingAccount) {
                    account_type = "Savings Account";
                } else if (account instanceof CheckingAccount) {
                    account_type = "Checking Account";
                }

                // Print the current balance of the account
                /*** Step 2:
                 **** Print out the type of account and the balance.
                 **** Feel free to use the currency_format formatter
                 **** to generate a "currency string" for the balance.
                 ***/
                System.out.printf("%s: current balance is %s\n", account_type, currency_format.format(account.getBalance()));

            }
        }
    }
}
