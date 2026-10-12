package app.comparator;

import app.entity.IntArray;

import java.util.Comparator;

public enum ArrayComparator implements Comparator<IntArray> {

    BY_ID {
        @Override
        public int compare(IntArray first, IntArray second) {
            return Integer.compare(first.getId(), second.getId());
        }
    },

    BY_FIRST_ELEMENT {
        @Override
        public int compare(IntArray first, IntArray second) {
            int[] firstArray = first.getArray();
            int[] secondArray = second.getArray();

            if (firstArray.length == 0 && secondArray.length == 0) {
                return 0;
            } else if (firstArray.length == 0) {
                return -1;
            } else if (secondArray.length == 0) {
                return 1;
            }

            return Integer.compare(firstArray[0], secondArray[0]);
        }
    },

    BY_SIZE {
        @Override
        public int compare(IntArray first, IntArray second) {
            return Integer.compare(
                    first.getArray().length,
                    second.getArray().length
            );
        }
    },

    BY_SUM {
        @Override
        public int compare(IntArray first, IntArray second) {
            int firstSum = 0;

            for (int value : first.getArray()) {
                firstSum += value;
            }

            int secondSum = 0;

            for (int value : second.getArray()) {
                secondSum += value;
            }

            return Integer.compare(firstSum, secondSum);
        }
    }
}