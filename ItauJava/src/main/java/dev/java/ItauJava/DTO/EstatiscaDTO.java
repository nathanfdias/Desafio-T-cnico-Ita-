package dev.java.ItauJava.DTO;

import lombok.Getter;

@Getter
public class EstatiscaDTO {

    private final long count;
    private final double avg;
    private final double max;
    private final double min;
    private final double sum;

    public EstatiscaDTO(long count, double avg, double max, double min, double sum){
        this.count = count;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
