import java.util.Random;
// Programa original con todas los sort, el main los llama por medio de argumentos a la hora de la ejecuci
public class SortingAlgorithms {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java SortingAlgorithms <algoritmo>");
            return;
        }

        String algorithm = args[0].toLowerCase();
        int[] array;
        Random random = new Random();
        
        for (int size = 10; size <= 3000; size++) {
            array = new int[size];
            
            // Inicializar el arreglo con valores aleatorios
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(10);
            }

            long startTime = System.nanoTime();
            switch (algorithm) {
                case "gnome":
                    gnomeSort(array);
                    break;
                case "merge":
                    mergeSort(array);
                    break;
                case "quick":
                    quickSort(array);
                    break;
                case "radix":
                    radixSort(array);
                    break;
                case "bubble":
                    bubbleSort(array);
                    break;
                default:
                    System.out.println("Algoritmo de ordenamiento no reconocido");
                    return;
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Duración en milisegundos

            // Imprimir información sobre el tiempo de ejecución
            System.out.println(size + "," + duration);
        }
    }

    // Implementaciones de los algoritmos de ordenamiento
    public static void gnomeSort(int[] arr) {
        int index = 0;

	while (index < arr.length) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void radixSort(int[] arr) {
        if (arr.length == 0)
            return;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

