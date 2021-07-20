package aula5;

public class UtilCompare {
    @SuppressWarnings("unchecked")
    public static <T> Comparable<T> findMax(Comparable<T>[] a) {
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i] != null && a[i].compareTo((T) a[maxIndex]) > 0)
                maxIndex = i;
        return a[maxIndex];
    }

    @SuppressWarnings("unchecked")
    public static <T> void sortArray(Comparable<T>[] a) {
        for(int i = a.length-1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(a[j].compareTo((T) a[j+1] )>0) {
					Comparable<T> tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
    }
}