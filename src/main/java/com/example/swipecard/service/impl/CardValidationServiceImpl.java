package com.example.swipecard.service.impl;

import org.springframework.stereotype.Service;
import com.example.swipecard.service.CardValidationService;

/**
 * @author aaron
 * @since 2021-02-23
 */
@Service
public class CardValidationServiceImpl implements CardValidationService {

    @Override
    public boolean cardCheck(String deviceIp, String icCardNumber) {
        return false;
    }
}
