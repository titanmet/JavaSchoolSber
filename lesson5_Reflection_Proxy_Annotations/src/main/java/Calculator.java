public interface Calculator {
    /**
     * Расчет факториала числа.
     *
     * @param number
     * @return
     */
    @Cache
    @Metric
    int calc(int number);
}
