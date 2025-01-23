package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<Pagamento> savePay(@Valid @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = pagamentoService.savePay(pagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }


    @GetMapping
    public ResponseEntity<List<Pagamento>> findPay() {
        List<Pagamento> findPay = pagamentoService.findPay();
        return ResponseEntity.ok(findPay);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getFindPayById(@PathVariable Long id) {
        return pagamentoService.findPayById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> updatePay(@PathVariable Long id, @Valid @RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento updatedPay = pagamentoService.updatePay(id, pagamentoDTO);
        return ResponseEntity.ok(updatedPay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePay(@PathVariable Long id) {
        pagamentoService.deletePay(id);
        return ResponseEntity.noContent().build();
    }
}