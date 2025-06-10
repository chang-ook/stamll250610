package stamll.domain;

import java.util.*;
import lombok.*;
import stamll.domain.*;
import stamll.infra.AbstractEvent;

@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private String name;
    private Integer stock;
}
