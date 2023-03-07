package com.hamza.service;

import com.hamza.dto.InventoryResponse;
import com.hamza.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skewCode) {
        log.info("Wait Started");
//        Thread.sleep(5000);
        log.info("Wait Ended");
        return inventoryRepository.findBySkewCodeIn(skewCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skewCode(inventory.getSkewCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
