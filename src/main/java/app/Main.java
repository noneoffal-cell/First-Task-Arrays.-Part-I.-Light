package app;

import app.entity.ArrayStatistics;
import app.entity.IntArray;
import app.exception.FileReadingException;
import app.exception.InvalidArrayDataException;
import app.parser.ArrayParse;
import app.parser.impl.ArrayParserImpl;
import app.reader.ArrayReader;
import app.reader.impl.ArrayReaderImpl;
import app.repository.ArrayRepository;
import app.repository.impl.ArrayRepositoryImpl;
import app.service.ArraySortService;
import app.service.CalculateSumAverageService;
import app.service.FindMaxMinService;
import app.service.impl.BubbleSortServiceImpl;
import app.service.impl.CalculateSumAverageServiceImpl;
import app.service.impl.FindMaxMinServiceImpl;
import app.service.impl.InsertionSortServiceImpl;
import app.warehouse.Warehouse;
import app.observer.RepositoryObserver;
import app.validator.ArrayValidator;
import app.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Main {

    private static final Logger LOGGER =
            LogManager.getLogger(Main.class);

    public static void main(String[] args)
            throws FileReadingException {

        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParse parser = new ArrayParserImpl(validator);

        ArrayRepository repository =
                ArrayRepositoryImpl.getInstance();

        Warehouse warehouse = Warehouse.getInstance();

        repository.setObserver(warehouse);

        FindMaxMinService maxMinService =
                new FindMaxMinServiceImpl();

        CalculateSumAverageService sumAverageService =
                new CalculateSumAverageServiceImpl();

        ArraySortService bubbleSortService =
                new BubbleSortServiceImpl();

        ArraySortService insertionSortService =
                new InsertionSortServiceImpl();

        List<String> lines = reader.read("data/array-data.txt");

        LOGGER.info("Starting array processing");

        for (String line : lines) {
            int[] values;

            try {
                values = parser.parse(line);
            } catch (InvalidArrayDataException exception) {
                LOGGER.error("Skipping invalid line: {}", line);
                continue;
            }

            IntArray array = repository.add(values);

            OptionalInt max = maxMinService.findMax(array);
            OptionalInt min = maxMinService.findMin(array);

            OptionalLong sum =
                    sumAverageService.calculateSum(array);

            OptionalDouble average =
                    sumAverageService.calculateAverage(array);

            int[] bubbleSorted = bubbleSortService.sort(array);

            int[] insertionSorted =
                    insertionSortService.sort(array);

            LOGGER.info("Input: {}", line);
            LOGGER.info("Array: {}", array);
            LOGGER.info("Array ID: {}", array.getId());

            LOGGER.info(
                    "Max: {}",
                    max.isPresent() ? max.getAsInt() : "N/A"
            );

            LOGGER.info(
                    "Min: {}",
                    min.isPresent() ? min.getAsInt() : "N/A"
            );

            LOGGER.info(
                    "Sum: {}",
                    sum.isPresent() ? sum.getAsLong() : "N/A"
            );

            LOGGER.info(
                    "Average: {}",
                    average.isPresent()
                            ? average.getAsDouble()
                            : "N/A"
            );

            LOGGER.info(
                    "Bubble sort: {}",
                    Arrays.toString(bubbleSorted)
            );

            LOGGER.info(
                    "Insertion sort: {}",
                    Arrays.toString(insertionSorted)
            );
        }

        LOGGER.info("Finished reading the file");

        logWarehouseStatistics(warehouse);

        List<IntArray> sortedArrays = repository.sort(
                Comparator.comparingInt(IntArray::getId)
        );

        LOGGER.info("Arrays sorted by ID: {}", sortedArrays);

        if (!sortedArrays.isEmpty()) {
            IntArray firstArray = sortedArrays.getFirst();
            int[] values = firstArray.getArray();

            if (values.length > 0) {
                LOGGER.info(
                        "Updating the first element of array ID {}",
                        firstArray.getId()
                );

                repository.updateValue(
                        firstArray.getId(),
                        0,
                        values[0] + 1
                );

                LOGGER.info("Warehouse statistics after update:");
                logWarehouseStatistics(warehouse);
            }

            LOGGER.info(
                    "Deleting array with ID {}",
                    firstArray.getId()
            );

            repository.deleteById(firstArray.getId());

            LOGGER.info("Warehouse statistics after deletion:");
            logWarehouseStatistics(warehouse);
        }

        LOGGER.info("Array processing completed");
    }

    private static void logWarehouseStatistics(Warehouse warehouse) {
        List<ArrayStatistics> statistics =
                warehouse.getStatistics();

        if (statistics.isEmpty()) {
            LOGGER.info("Warehouse is empty");
            return;
        }

        for (ArrayStatistics arrayStatistics : statistics) {
            LOGGER.info("{}", arrayStatistics);
        }
    }
}