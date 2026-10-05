using System;
using System.Collections.Generic;
using System.IO;

public class Receipt
{
    // Store all items in the sale
    public List<SaleItem> Items { get; } = new List<SaleItem>();

    // Store date and time of transaction
    public DateTime Timestamp { get; } = DateTime.Now;

    // Add an item to the receipt
    public void AddItem(SaleItem item)
    {
        Items.Add(item);
    }

    // Print receipt
    public void PrintReceipt()
    {
        Console.WriteLine("----- QUICKMART SUPERMARKET RECEIPT -----");
        Console.WriteLine($"Date: {Timestamp}");
        Console.WriteLine("-----------------------------------------");

        decimal totalVat = 0;
        decimal totalAmount = 0;

        foreach (var item in Items)
        {
            Console.WriteLine($"{item.Product.Name} x{item.Quantity}");

            Console.WriteLine(
                $" Subtotal: KES {item.Subtotal:F2}");

            Console.WriteLine(
                $" VAT ({item.Product.VatCategory}): KES {item.Vat:F2}");

            Console.WriteLine(
                $" Total: KES {item.Total:F2}");

            Console.WriteLine();

            totalVat += item.Vat;
            totalAmount += item.Total;
        }

        Console.WriteLine("-----------------------------------------");
        Console.WriteLine($"Total VAT: KES {totalVat:F2}");
        Console.WriteLine($"TOTAL: KES {totalAmount:F2}");
        Console.WriteLine("Thank you for shopping at QuickMart!");
        Console.WriteLine("-----------------------------------------");

        // Save transaction to file
        LogTransaction(totalAmount, totalVat);
    }

    // Log transaction
    private void LogTransaction(decimal total, decimal vat)
    {
        string logEntry =
            $"{Timestamp:yyyy-MM-dd HH:mm:ss}," +
            $"TOTAL:KES {total:F2}," +
            $"VAT:KES {vat:F2}";

        File.AppendAllText(
            "sales_log.txt",
            logEntry + Environment.NewLine);
    }
}