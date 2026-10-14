package app.warehouse;

import app.entity.ArrayStatistics;
import app.entity.IntArray;
import app.observer.RepositoryObserver;
import app.service.CalculateSumAverageService;
import app.service.FindMaxMinService;
import app.service.impl.CalculateSumAverageServiceImpl;
import app.service.impl.FindMaxMinServiceImpl;

import java.util.*;

public class Warehouse implements RepositoryObserver {

    private static Warehouse instance;

    private final List<ArrayStatistics> statistics;
    private final CalculateSumAverageService calculateSumAverageService;
    private final FindMaxMinService findMaxMinService;

    private Warehouse() {
        statistics = new ArrayList<>();
        calculateSumAverageService = new CalculateSumAverageServiceImpl();
        findMaxMinService = new FindMaxMinServiceImpl();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }

        return instance;
    }

    public List<ArrayStatistics> getStatistics() {
        return List.copyOf(statistics);
    }

    private ArrayStatistics calculateStatistics (IntArray array) {
        OptionalLong sum = calculateSumAverageService.calculateSum(array);
        OptionalDouble average = calculateSumAverageService.calculateAverage(array);
        OptionalInt min = findMaxMinService.findMin(array);
        OptionalInt max = findMaxMinService.findMax(array);

        return new ArrayStatistics(array.getId(), sum, average, min, max);
    }

    @Override
    public void onArrayAdded(IntArray array) {
        ArrayStatistics arrayStatistics = calculateStatistics(array);
        statistics.add(arrayStatistics);
    }

    @Override
    public void onArrayUpdated(IntArray array) {
        ArrayStatistics arrayStatistics = calculateStatistics(array);

        for (int i = 0; i < statistics.size(); i++) {
            if (statistics.get(i).id() == array.getId()) {
                statistics.set(i, arrayStatistics);
                return;
            }
        }
    }

    @Override
    public void onArrayRemoved(int id) {
        for (int i = 0; i <statistics.size(); i++){
            if (statistics.get(i).id() == id) {
                statistics.remove(i);
                return;
            }
        }
    }



}
