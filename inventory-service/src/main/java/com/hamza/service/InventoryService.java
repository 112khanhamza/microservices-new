package com.hamza.service;

import com.hamza.dto.InventoryResponse;
import com.hamza.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skewCode) {
        return inventoryRepository.findBySkewCodeIn(skewCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skewCode(inventory.getSkewCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
