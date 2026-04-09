public class QuickSort {

    static final int THRESHOLD = 10;

    static void sort(Asset[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(Asset[] arr, int low, int high) {
        if (low >= high) return;

        if (high - low < THRESHOLD) {
            insertionSort(arr, low, high);
            return;
        }

        int pivotIndex = medianOfThree(arr, low, high);
        swap(arr, pivotIndex, high);

        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }

    static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    static int compare(Asset a, Asset b) {
        if (a.returnRate != b.returnRate) {
            return Double.compare(b.returnRate, a.returnRate);
        }
        return Double.compare(a.volatility, b.volatility);
    }

    static int medianOfThree(Asset[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (compare(arr[low], arr[mid]) > 0) swap(arr, low, mid);
        if (compare(arr[low], arr[high]) > 0) swap(arr, low, high);
        if (compare(arr[mid], arr[high]) > 0) swap(arr, mid, high);

        return mid;
    }

    static void insertionSort(Asset[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            Asset key = arr[i];
            int j = i - 1;

            while (j >= low && compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void swap(Asset[] arr, int i, int j) {
        Asset temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
