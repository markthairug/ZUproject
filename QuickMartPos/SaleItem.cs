public class SaleItem
{
    public Product Product { get; set; }
    public int Quantity { get; set; }

    // Constructor
    public SaleItem(Product product, int quantity)
    {
        Product = product;
        Quantity = quantity;
    }

    // Calculate subtotal
    public decimal Subtotal
    {
        get
        {
            return Product.Price * Quantity;
        }
    }

    // Calculate VAT for the quantity
    public decimal Vat
    {
        get
        {
            return Product.GetVatAmount() * Quantity;
        }
    }

    // Calculate total including VAT
    public decimal Total
    {
        get
        {
            return Product.GetTotalPrice() * Quantity;
        }
    }
}