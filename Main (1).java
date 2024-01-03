public void mergeSort(int[] arr) {
    int n = arr.length;
    if (n < 2) {
        return;
    }

    int mid = n / 2;
    int[] left = new int[mid];
    int[] right = new int[n - mid];

    System.arraycopy(arr, 0, left, 0, mid);
    System.arraycopy(arr, mid, right, 0, n - mid);

    mergeSort(left);
    mergeSort(right);

    merge(left, right, arr);
}

public void merge(int[] left, int[] right, int[] arr) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            arr[k++] = left[i++];
        } else {
            arr[k++] = right[j++];
        }
    }

    while (i < left.length) {
        arr[k++] = left[i++];
    }

    while (j < right.length) {
        arr[k++] = right[j++];
    }
}