package stamll.domain;

import java.util.*;
import lombok.*;
import stamll.domain.*;
import stamll.infra.AbstractEvent;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String itemId;
    private Integer qty;
    private String address;
}
