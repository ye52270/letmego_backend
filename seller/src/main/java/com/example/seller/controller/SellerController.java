package com.example.seller.controller;

import com.example.seller.dto.ResponseDTO;
import com.example.seller.dto.SellerDTO;
import com.example.seller.entity.SellerEntity;
import com.example.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
@Slf4j
public class SellerController {
    private final SellerService sellerService;
    @PostMapping("/proposal")
    public ResponseEntity<?> createProposal(
            @RequestBody SellerDTO sellerDTO
            ) {

        try{
            SellerEntity proposal = SellerEntity.builder()
                    .orderId(sellerDTO.getOrderId())
                    .orderEmail(sellerDTO.getOrderEmail())
                    .orderLocation(sellerDTO.getOrderLocation())
                    .orderAdult(sellerDTO.getOrderAdult())
                    .orderChild(sellerDTO.getOrderChild())
                    .startedAt(sellerDTO.getStartedAt())
                    .endedAt(sellerDTO.getEndedAt())
                    .orderContent(sellerDTO.getOrderContent())
                    .orderStatus(sellerDTO.getOrderStatus())
                    .proposalAmount(sellerDTO.getProposalAmount())
                    .proposalContent(sellerDTO.getProposalContent())
                    .build();

            sellerService.createProposal(proposal);
            return ResponseEntity.ok().body(sellerDTO);
        }catch(Exception e) {
            ResponseDTO<Object> responseDTO = ResponseDTO.builder()
                    .error(e.getMessage())
                    .build();

            return ResponseEntity.badRequest()
                    .body(responseDTO);
        }
    }

    @GetMapping(path = "/proposal/{orderId}")
    public ResponseEntity<?> getProposal(@PathVariable(required = true) String orderId) {
        log.info("get proposal detail : " + orderId);

        SellerEntity proposal = sellerService.getProposal(orderId);

        log.info("proposal : " + proposal);
        return ResponseEntity.ok().body(proposal);
    }
}
