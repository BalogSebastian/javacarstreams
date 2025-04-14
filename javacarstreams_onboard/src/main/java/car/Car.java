package car;

import java.io.Serializable;

public record Car
        (String brand, String model, int year, double price)
        implements Serializable
{
}
