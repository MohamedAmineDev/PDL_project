package com.pdl.PDL_Backend.supply;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/supply")
@RequiredArgsConstructor
public class SupplyController implements ISupply {
    private final SupplyService service;

    @GetMapping(path = "admin/supplies")
    @Override
    public List<Supply> getAll() {
        return service.getAll();
    }

    @PostMapping(path = "/admin/addition")
    @Override
    public String add(@RequestBody Supply supply) {
        try {
            return service.add(supply);
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping(path = "/admin/delete/{id}")
    @Override
    public String delete(@PathVariable("id") UUID id) {
        try {
            return service.delete(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            return exception.getMessage();
        }
    }
}
