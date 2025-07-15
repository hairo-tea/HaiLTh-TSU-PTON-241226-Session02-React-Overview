package entity;

public class StatisticCatalog {
    private String catalog;
    private int cntProducts;

    public StatisticCatalog() {
    }

    public StatisticCatalog(String catalog, int cntProducts) {
        this.catalog = catalog;
        this.cntProducts = cntProducts;
    }
    public String getCatalog() {
        return catalog;
    }
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
    public int getCntProducts() {
        return cntProducts;
    }
    public void setCntProducts(int cntProducts) {
        this.cntProducts = cntProducts;
    }
    @Override
    public String toString() {
        return String.format("catalog: %s, cntProducts: %d", catalog, cntProducts);
    }
}
