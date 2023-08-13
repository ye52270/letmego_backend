package com.example.seller.service;

import com.example.seller.client.OrderServiceClient;
import com.example.seller.entity.SellerEntity;
import com.example.seller.repository.SellerRepository;
import com.example.seller.vo.ResponseOrder;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository repository;
    private final Environment env;
    private final RestTemplate restTemplate;
    private final OrderServiceClient orderServiceClient;
    public SellerEntity createProposal(SellerEntity sellerEntity) {
        SellerEntity seller = SellerEntity.builder()
                .orderId(sellerEntity.getOrderId())
                .orderEmail(sellerEntity.getOrderEmail())
                .orderLocation(sellerEntity.getOrderLocation())
                .orderAdult(sellerEntity.getOrderAdult())
                .orderChild(sellerEntity.getOrderChild())
                .startedAt(sellerEntity.getStartedAt())
                .endedAt(sellerEntity.getEndedAt())
                .orderContent(sellerEntity.getOrderContent())
                .orderStatus("견적제출")
                .proposalAmount(sellerEntity.getProposalAmount())
                .proposalContent(sellerEntity.getProposalContent())
                .build();

        log.info("request DTO : " + sellerEntity.toString());

        log.info("Before call orders microservice");
        List<ResponseOrder> orderList = new ArrayList<>();
        try{
            orderList = orderServiceClient.updateOrderStatus(seller.getOrderId());

        }catch (FeignException ex){
            log.error(ex.getMessage());
        }

        log.info("After call orders microservice " + orderList.toString());
        return repository.save(seller);
    }

    public SellerEntity getProposal(String orderId) {
        SellerEntity proposal = repository.findByOrderId(orderId);
        return proposal;
    }
}
