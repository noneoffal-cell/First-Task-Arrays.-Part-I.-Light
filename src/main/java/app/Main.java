package app;

import app.entity.IntArray;
import app.exception.FileReadingException;
import app.exception.InvalidArrayDataException;
import app.factory.ArrayFactory;
import app.factory.impl.IntArrayFactory;
import app.parser.ArrayParse;
import app.parser.impl.ArrayParserImpl;
import app.reader.ArrayReader;
import app.reader.impl.ArrayReaderImpl;
import app.service.ArraySortService;
import app.service.CalculateSumAverageService;
import app.service.FindMaxMinService;
import app.service.impl.BubbleSortServiceImpl;
import app.service.impl.CalculateSumAverageServiceImpl;
import app.service.impl.FindMaxMinServiceImpl;
import app.service.impl.InsertionSortServiceImpl;
import app.validator.ArrayValidator;
import app.validator.impl.ArrayValidatorImpl;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Main {

    public static void main(String[] args)
            throws FileReadingException, InvalidArrayDataException {

        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);
        ArrayFactory<IntArray> factory = new IntArrayFactory();

        FindMaxMinService maxMinService = new FindMaxMinServiceImpl();
        CalculateSumAverageService sumAverageService =
                new CalculateSumAverageServiceImpl();

        ArraySortService bubbleSortService = new BubbleSortServiceImpl();
        ArraySortService insertionSortService = new InsertionSortServiceImpl();

        List<String> lines = reader.read("data/array-data.txt");

        for (String line : lines) {
            if (validator.isValid(line)) {
                int[] values = parser.parse(line);
                IntArray array = factory.create(values);

                OptionalInt max = maxMinService.findMax(array);
                OptionalInt min = maxMinService.findMin(array);

                OptionalLong sum = sumAverageService.calculateSum(array);
                OptionalDouble average =
                        sumAverageService.calculateAverage(array);

                IntArray bubbleSorted = bubbleSortService.sort(array);
                IntArray insertionSorted = insertionSortService.sort(array);

                System.out.println("Input: " + line);
                System.out.println("Max: " + max);
                System.out.println("Min: " + min);
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + average);
                System.out.println(
                        "Bubble sort: "
                                + java.util.Arrays.toString(
                                bubbleSorted.getArray()));
                System.out.println(
                        "Insertion sort: "
                                + java.util.Arrays.toString(
                                insertionSorted.getArray()));
                System.out.println();
            } else {
                System.out.println("Invalid data: " + line);
            }
        }
    }
}