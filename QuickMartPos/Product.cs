public class Product
{
    public string Name { get; set; }
    public decimal Price { get; set; }
    public VatCategory VatCategory { get; set; }

    // Constructor
    public Product(string name, decimal price, VatCategory vatCategory)
    {
        Name = name;
        Price = price;
        VatCategory = vatCategory;
    }

    // Calculate VAT for one product
    public decimal GetVatAmount()
    {
        decimal rate = VatRates.Rates[VatCategory];

        return Price * rate;
    }

    // Calculate price including VAT
    public decimal GetTotalPrice()
    {
        return Price + GetVatAmount();
    }
}