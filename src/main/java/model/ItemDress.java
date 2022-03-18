package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDress {

    private int id;
    private String type;
    private String size;
    private String color;

}
