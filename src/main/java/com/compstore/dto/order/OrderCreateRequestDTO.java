package com.compstore.dto.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.*;
import lombok.Data;

@Data
public class OrderCreateRequestDTO {

    @NotEmpty private List<@Valid @NotNull OrderItemDTO> orderItems;
}
