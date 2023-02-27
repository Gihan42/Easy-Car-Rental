package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.PaymentDto;

import java.util.ArrayList;

public interface PaymentService {
    public void savePayment(PaymentDto dto);
    public void deletePayment(String id);
    public ArrayList<PaymentDto> getAllPayments();
}
