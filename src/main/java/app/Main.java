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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Arrays;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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

                LOGGER.info("Input: {}", line);
                LOGGER.info("Max: {}", max.isPresent() ? max.getAsInt() : "N/A");
                LOGGER.info("Min: {}", min.isPresent() ? min.getAsInt() : "N/A");
                LOGGER.info("Sum: {}", sum.isPresent() ? sum.getAsLong() : "N/A");
                LOGGER.info("Average: {}", average.isPresent() ? average.getAsDouble() : "N/A");
                LOGGER.info(
                        "Bubble sort: {}",
                        Arrays.toString(bubbleSorted.getArray()));
                LOGGER.info(
                        "Insertion sort: {}",
                        Arrays.toString(insertionSorted.getArray()));
                LOGGER.info("");
            } else {
                LOGGER.error("Invalid data: {}", line);
                return;
            }
        }
    }
}