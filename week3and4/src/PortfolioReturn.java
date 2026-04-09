import java.util.*;

public class PortfolioReturn {

    public static void main(String[] args) {

        Asset[] assets = {
                new Asset("AAPL", 12.0, 0.30),
                new Asset("TSLA", 8.0, 0.60),
                new Asset("GOOG", 15.0, 0.25),
                new Asset("MSFT", 12.0, 0.20)
        };

        Asset[] mergeArr = Arrays.copyOf(assets, assets.length);
        MergeSort.sort(mergeArr);

        System.out.println("Merge Sort (Ascending Return):");
        for (Asset a : mergeArr) {
            System.out.println(a);
        }

        Asset[] quickArr = Arrays.copyOf(assets, assets.length);
        QuickSort.sort(quickArr);

        System.out.println("\nQuick Sort (Desc Return + Low Volatility):");
        for (Asset a : quickArr) {
            System.out.println(a);
        }
    }
}
