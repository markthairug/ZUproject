using System;
using System.Net.ServerSentEvents;

class Program
{
    static void Main()
    {
        // Create products
        Product milk = new Product(
            "Milk",
            60.00m,
            VatCategory.ZeroRated);

        Product tv = new Product(
            "TV",
            35000.00m,
            VatCategory.Standard);

        Product mask = new Product(
            "Medical Mask",
            20.00m,
            VatCategory.Exempt);

        // Create receipt
        Receipt receipt = new Receipt();

        // Add products to the sale
        receipt.AddItem(new SaleItem(tv, 1));
        receipt.AddItem(new SaleItem(milk, 2));
        receipt.AddItem(new SaleItem(mask, 5));

        // Print receipt
        receipt.PrintReceipt();

        // Keep console open
        Console.ReadLine();
    }
}